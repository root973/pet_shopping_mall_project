package co.sp.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import co.sp.beans.Page;
import co.sp.beans.Pet_event;
import co.sp.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/page.properties")
public class BoardService {
	
	
	//출력할 게시글갯수
	@Value("${event.page.listcount}")
	private int event_page_list_cnt;
		
	//출력할 이전, 다음사이 페이징갯수
	@Value("${event.page.pa}")
	private int event_page_pa;
	
	
	
	@Autowired
	private BoardDao boardDao;

	public void insertEventInfo(Pet_event event) {
		boardDao.insertEventInfo(event);
	}

	public List<Pet_event> allEventList(int page) {
		int start = (page - 1) * event_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, event_page_list_cnt);
		return boardDao.allEventList(rowBounds);
	}

	public Page getEventCnt(int current_page) {
		int event_cnt = boardDao.getEventCnt();
		Page pageBean = new Page(event_cnt, current_page, event_page_list_cnt, event_page_pa);
		return pageBean;
	}

	public Pet_event getEventInfo(long board_index) {
		return boardDao.getEventInfo(board_index);
	}

	public void modifyEventInfo(Pet_event ev) {
		boardDao.modifyEventInfo(ev);
		
	}

	public void deleteEventInfo(long board_index) {
		boardDao.deleteEventInfo(board_index);
		
	}

	
	
}
