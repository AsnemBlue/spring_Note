package com.tj.ch15.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileUploadService {
	public boolean FileUp(MultipartHttpServletRequest mRequest, Model model) {
		boolean isUpload = false;
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/mega_IT/source/9_sprinng/ch15_fileup/src/main/webapp/upload/";
		String[] fileNames = new String[3];
		int i = 0;
		Iterator<String> params = mRequest.getFileNames();
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);	//파라미터의 파일 객체
			String originalFileName = mFile.getOriginalFilename();	//업로드 했을 때 원래 파일 이름
			fileNames[i] = originalFileName;
			if(fileNames[i]!=null && !fileNames[i].equals("")) {
				if(new File(uploadPath + fileNames[i]).exists()) {
					//첨부파일과 같은 이름의 파일이 서버에 존재하는 경우 - 파일이름을 변경
					fileNames[i] = System.currentTimeMillis() + fileNames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath+fileNames[i]));
					System.out.println("서버에 저장된 파일 : "+uploadPath+fileNames[i]);
					System.out.println("백업위해 복사할 파일 : "+backupPath+fileNames[i]);
					isUpload = filecopy(uploadPath+fileNames[i],backupPath+fileNames[i]);
				}  catch (IOException e) {
					System.out.println(e.getMessage());
				} 	//서버에 파일 저장
			}
			i++;
		}// while
		model.addAttribute("fileNames", fileNames);
		return isUpload;
	}
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte==-1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
 			} catch (IOException  e2) {
 				System.out.println(e2.getMessage());
			}
		}
		return isCopy;
	}
}
