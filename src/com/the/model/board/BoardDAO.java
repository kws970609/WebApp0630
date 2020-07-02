package com.the.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.the.mybatis.MybatisConfigManager;

public class BoardDAO {
	MybatisConfigManager manager = MybatisConfigManager.getInstance();

	// 목록가져오기 selectAll
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("Board.selectAll");
		manager.closeSession(sqlSession);
		return list;
	}

	// 한건 가져오기 select
	public Board select(int board_id) {
		Board board = null;
		SqlSession sqlSession = manager.getSqlSession();
		board = sqlSession.selectOne("Board.select", board_id);
		manager.closeSession(sqlSession);
		return board;
	}

	// 1건 등록 insert
	public int insert(Board board) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();
		System.out.println("insert 하기전의 board_id" + board.getBoard_id());
		sqlSession.insert("Board.insert", board);
		sqlSession.commit();
		System.out.println("insert 한 후의 board_id" + board.getBoard_id());
		return result;

	}

	// 1건 수정 update
	public int update(Board board) {
		int result=0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.update("Board.updateBoard",board);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}

	// 1건 삭제 delete
	public int delete(Board board) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.delete("Board.delete", board);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}

	// 답변 등록 reply
	public int reply(Board board) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.insert("Board.reply", board);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}

	// rank +1 증가 updateRank
	public void updateRank(Board board) {
		SqlSession sqlSession = manager.getSqlSession();
		sqlSession.update("Board.updateBoard", board);
		sqlSession.commit();
		manager.closeSession(sqlSession);
	}
}



















