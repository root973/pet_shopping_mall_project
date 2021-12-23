package co.sp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_event;
import co.sp.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;

	public void insertEventInfo(Pet_event event) {
		boardMapper.insertEventInfo(event);
	}

	public List<Pet_event> allEventList(RowBounds rowBounds) {
		return boardMapper.allEventList(rowBounds);
	}

	public int getEventCnt() {
		return boardMapper.getEventCnt();
	}

	public Pet_event getEventInfo(long board_index) {
		return boardMapper.getEventInfo(board_index);
	}

	public void modifyEventInfo(Pet_event ev) {
		boardMapper.modifyEventInfo(ev);
		
	}

	public void deleteEventInfo(long board_index) {
		boardMapper.deleteEventInfo(board_index);
	}

}
