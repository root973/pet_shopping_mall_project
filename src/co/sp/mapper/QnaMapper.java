package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_qna;

public interface QnaMapper {
	
	//������
	@Insert("insert into Pet_qna values(qna_seq.nextval,#{goods_code},#{member_id},"+
			"#{q_content},#{a_content}, TO_CHAR(SYSDATE, 'YYYY-MM-DD'))")
	void insertQna(Pet_qna qnaBean);
	//��ǰ���� ��������
	@Select("select * from Pet_qna where goods_code=#{goods_code} order by q_num desc")
	List<Pet_qna> getAllQnaByGoods(@Param("goods_code")long goods_code, @Param("rowBounds")RowBounds rowBounds);
	//��������(Ŭ���̾�Ʈ)
	@Update("update Pet_qna set q_content=#{q_content}"
			+ " where q_num=#{q_num} and goods_code=#{goods_code} and member_id=#{member_id}")
	void updateQnaByClient(Pet_qna qnaBean);
	//Ŭ���̾�Ʈ ���䰡������
	@Select("select * from Pet_qna where member_id=#{member_id} order by q_num desc")
	List<Pet_qna> clientQnaList(String member_id);
	//��ü qna ��������(������)
	@Select("select * from Pet_qna order by q_num desc")
	List<Pet_qna> admin_allQna(RowBounds rowBounds); 
	//�亯(������)
	@Update("update Pet_qna set a_content=#{a_content} where q_num=#{q_num}")
	void updateQnaByAdmin(@Param("a_content")String a_content, @Param("q_num")long q_num);
	//�������(Ŭ���̾�Ʈ)
	@Delete("delete from Pet_qna where q_num=#{q_num}")
	void deleteQna(long q_num);
	//�������(ȸ��Ż��)
	@Delete("delete from Pet_qna where member_id=#{member_id}")
	void withdrawalQna(String member_id);
	//����¡�� ���� ��ü����
	@Select("select count(*) from pet_qna where goods_code=#{goods_code}")
	int getQnaCntBygoods(long goods_code);
	//����¡�� ���� ��ü����
	@Select("select count(*) from pet_qna")
	int getQnaCnt();
	//��ǰ�����ϳ� ���(������)
	@Select("select * from pet_qna where q_num=#{q_num}")
	Pet_qna getOneQna(long q_num);
	//qna �˻�(������
	@Select("select * from pet_qna where member_id = #{member_id}")
	List<Pet_qna> getQnaListByClient(String member_id);
	//���������� ����Ʈ(������)
	@Select("select * from pet_qna where rownum <=3 order by q_num desc")
	List<Pet_qna> getAdminMainQnaList();
}
