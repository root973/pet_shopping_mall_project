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
	
	//질답등록
	@Insert("insert into Pet_qna values(qna_seq.nextval,#{goods_code},#{member_id},"+
			"#{q_content},#{a_content}, TO_CHAR(SYSDATE, 'YYYY-MM-DD'))")
	void insertQna(Pet_qna qnaBean);
	//상품질답 가져오기
	@Select("select * from Pet_qna where goods_code=#{goods_code} order by q_num desc")
	List<Pet_qna> getAllQnaByGoods(@Param("goods_code")long goods_code, @Param("rowBounds")RowBounds rowBounds);
	//질문수정(클라이언트)
	@Update("update Pet_qna set q_content=#{q_content}"
			+ " where q_num=#{q_num} and goods_code=#{goods_code} and member_id=#{member_id}")
	void updateQnaByClient(Pet_qna qnaBean);
	//클라이언트 질답가져오기
	@Select("select * from Pet_qna where member_id=#{member_id} order by q_num desc")
	List<Pet_qna> clientQnaList(String member_id);
	//전체 qna 가져오기(관리자)
	@Select("select * from Pet_qna order by q_num desc")
	List<Pet_qna> admin_allQna(RowBounds rowBounds); 
	//답변(관리자)
	@Update("update Pet_qna set a_content=#{a_content} where q_num=#{q_num}")
	void updateQnaByAdmin(@Param("a_content")String a_content, @Param("q_num")long q_num);
	//질답삭제(클라이언트)
	@Delete("delete from Pet_qna where q_num=#{q_num}")
	void deleteQna(long q_num);
	//질답삭제(회원탈퇴)
	@Delete("delete from Pet_qna where member_id=#{member_id}")
	void withdrawalQna(String member_id);
	//페이징을 위한 전체갯수
	@Select("select count(*) from pet_qna where goods_code=#{goods_code}")
	int getQnaCntBygoods(long goods_code);
	//페이징을 위한 전체갯수
	@Select("select count(*) from pet_qna")
	int getQnaCnt();
	//상품문의하나 답글(관리자)
	@Select("select * from pet_qna where q_num=#{q_num}")
	Pet_qna getOneQna(long q_num);
	//qna 검색(관리자
	@Select("select * from pet_qna where member_id = #{member_id}")
	List<Pet_qna> getQnaListByClient(String member_id);
	//메인페이지 리스트(관리자)
	@Select("select * from pet_qna where rownum <=3 order by q_num desc")
	List<Pet_qna> getAdminMainQnaList();
}
