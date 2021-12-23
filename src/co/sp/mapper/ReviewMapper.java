package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_review;

public interface ReviewMapper {
	
	//������
	@Insert("insert into Pet_review values(review_seq.NextVal,#{goods_code},#{member_id},"+
			"#{content},#{content_reply},TO_CHAR(SYSDATE, 'YYYY-MM-DD'))")
	void insertReview(Pet_review reviewBean);
	//��ǰ���� ��������
	@Select("select * from Pet_review where goods_code = #{goods_code} order by r_num desc")
	List<Pet_review> getAllReviewByGoods(@Param("goods_code")long goods_code, @Param("rowBounds")RowBounds rowBounds);
	//�������
	@Update("update Pet_review set content = #{content}"+
			" where r_num = #{r_num} and goods_code = #{goods_code} and member_id = #{member_id}")
	void updateReview(Pet_review reviewBean);
	//�� ������ ��ǰ���� ��������
	@Select("select * from Pet_review where member_id = #{member_id} order by r_num desc" )
	List<Pet_review> clientReviewList(String member_id);
	//���� ��ü ��������(������
	@Select("select * from pet_review order by r_num desc")
	List<Pet_review> admin_allReview(RowBounds rowBounds);
	//��� �ø���+�����ϱ�
	@Update("update pet_review set content_reply=#{content_reply} where r_num=#{r_num}")
	void updateReviewReply(@Param("content_reply")String content_reply, @Param("r_num")long r_num);
	//�������
	@Delete("delete from Pet_review where r_num = #{r_num}")
	void deleteReview(long r_num);
	//�������(ȸ��Ż��)
	@Delete("delete from Pet_review where member_id = #{member_id}")
	void withdrawalReview(String member_id);
	//����¡�� ���� ��ü����
	@Select("select count(*) from pet_review where goods_code = #{goods_code}")
	int getReviewCntBygoods(long goods_code);
	//������ ����¡�� ���� ��ü����
	@Select("select count(*) from pet_review")
	int getReviewCnt();
	@Select("select * from pet_review where r_num=#{r_num}")
	Pet_review getOneReview(long r_num);
	//���� �˻�(������)
	@Select("select * from pet_review where member_id = #{member_id}")
	List<Pet_review> getReviewListByClient(String member_id);
	//���������� ����Ʈ(������)
	@Select("select * from pet_review where rownum <=3 order by r_num desc")
	List<Pet_review> getAdminMainReviewList();
	
	
}
