package com.tj.ch14.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.tj.ch14.constant.Constant;
import com.tj.ch14.dto.BoardDto;

public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private JdbcTemplate template;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		template = Constant.template;
	}
	//글목록
	public ArrayList<BoardDto> list(final int startRow, final int endRow){
		String sql ="SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, BSTEP) A) WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	//글갯수
	public int boardcnt() {
		String sql ="SELECT COUNT(*) CNT FROM MVC_BOARD";
		return template.queryForInt(sql);
	}
	//글쓰기
	public int write(final BoardDto dto) {
		String sql ="INSERT INTO MVC_BOARD (bID,bNAME,bTITLE,bCONTENT,bGROUP,bSTEP,bINDENT,bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?,?,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname()	);
				pstmt.setString(2, dto.getBtitle()	);
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip()		);
			}
		});
	}
	// 조회수 증가
	public void hitup(int bid) {
		String sql ="UPDATE MVC_BOARD SET bHIT = bHIT+1 WHERE bID="+bid;
		template.update(sql);
	}
	// 글상세 보기(조회수 증가 포함)
	public BoardDto contentView(int bid) {
		hitup(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	
	// 답변글 쓰기 위해 원글 dto가져오기
	public BoardDto modifyView_replyView(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
		
	// stepA
	public void preReplyStepA(final int bgroup, final int bstep) {
		String sql ="UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BSTEP>? AND BGROUP=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bstep );
				pstmt.setInt(2, bgroup);
			}
		});
	}
		
	// 답변글 쓰기 -bname, btitle, bcontent, bip => bgroup, bstep, bindent
	public int reply(final BoardDto dto) {
		String sql = "INSERT INTO MVC_BOARD (BID,BNAME,BTITLE,BCONTENT,BGROUP,BSTEP,BINDENT,BIP) " + 
						 "VALUES (MVC_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname()		);
				pstmt.setString(2, dto.getBtitle()		);
				pstmt.setString(3, dto.getBcontent()	);
				pstmt.setInt   (4, dto.getBgroup()		);
				pstmt.setInt   (5, dto.getBstep()+1		);
				pstmt.setInt   (6, dto.getBindent()+1	);
				pstmt.setString(7, dto.getBip()			);
			}
		});
	}
	// 글 수정하기
	public int modify(final BoardDto dto) {
		return template.update(new PreparedStatementCreator() {
			String sql = "UPDATE MVC_BOARD SET bNAME=?,bTITLE=?,bCONTENT=?,bIP=? WHERE bID=?";
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBname()	);
				pstmt.setString(2, dto.getBtitle()	);
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip()		);
				pstmt.setInt   (5, dto.getBid()		);
				return pstmt;
			}
		});
	}
	// 글 삭제
	public int delete(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID="+bid;
		return template.update(sql);
	}
}
