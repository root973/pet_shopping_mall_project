package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_event;

public interface BoardMapper {
	
	//�̺�Ʈ�Խù� ���
	@Insert("insert into pet_event values(event_seq.nextval, #{board_type}, #{admin_id}, #{position}, #{title}, #{content}, #{event_img_url}, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 0)")
	void insertEventInfo(Pet_event event);
	
	//������������ �̺�Ʈ����Ʈ �ڵ�(RowBound�� ����Ǿ���)
	@Select("select * from pet_event order by board_index desc")
	List<Pet_event> allEventList(RowBounds rowBounds);
	
	//����¡�� ���� �̺�Ʈ���� ��ȯ�ڵ�
	@Select("select count(*) from pet_event")
	int getEventCnt();
	
	//�ε����� �̿��� �̺�Ʈ�Խ��� ���� ��������
	@Select("select * from pet_event where board_index = #{board_index}")
	Pet_event getEventInfo(long board_index);
	
	//������������ �̺�Ʈ �Խù� ������Ʈ �ڵ�
	@Update("update pet_event set " + 
			"board_type = #{board_type}, "+
			"title = #{title}, content = #{content}, " +
			"event_img_url = #{event_img_url} " +
			"where board_index = #{board_index}")
	void modifyEventInfo(Pet_event ev);

	//������������ �̺�Ʈ �Խù� �����ڵ� 
	@Delete("delete from pet_event where board_index = #{board_index}")
	void deleteEventInfo(long board_index);

}
