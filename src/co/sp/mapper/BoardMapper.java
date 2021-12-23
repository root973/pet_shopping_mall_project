package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_event;

public interface BoardMapper {
	
	//이벤트게시물 등록
	@Insert("insert into pet_event values(event_seq.nextval, #{board_type}, #{admin_id}, #{position}, #{title}, #{content}, #{event_img_url}, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 0)")
	void insertEventInfo(Pet_event event);
	
	//관리자페이지 이벤트리스트 코드(RowBound가 적용되었다)
	@Select("select * from pet_event order by board_index desc")
	List<Pet_event> allEventList(RowBounds rowBounds);
	
	//페이징을 위한 이벤트개수 반환코드
	@Select("select count(*) from pet_event")
	int getEventCnt();
	
	//인덱스를 이용한 이벤트게시판 정보 가져오기
	@Select("select * from pet_event where board_index = #{board_index}")
	Pet_event getEventInfo(long board_index);
	
	//관리자페이지 이벤트 게시물 업데이트 코드
	@Update("update pet_event set " + 
			"board_type = #{board_type}, "+
			"title = #{title}, content = #{content}, " +
			"event_img_url = #{event_img_url} " +
			"where board_index = #{board_index}")
	void modifyEventInfo(Pet_event ev);

	//관리자페이지 이벤트 게시물 삭제코드 
	@Delete("delete from pet_event where board_index = #{board_index}")
	void deleteEventInfo(long board_index);

}
