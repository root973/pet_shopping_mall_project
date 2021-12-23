package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_category;
import co.sp.beans.Pet_goods;

//pet_goods table과 상호작용하는 쿼리문 모음
public interface GoodsMapper {
	
	//검색을 위한 모든 상품명 가져오기
	@Select("select goods_name from pet_goods")
	String[] allGoodsKeyword();
	
	//상품등록
	@Insert("insert into pet_goods values(#{category_big}, #{category_small}, goods_seq.nextval, #{goods_name}, #{price}, #{option_1}, #{option_2}, #{info}, #{thumbnail_img_url}, #{detail_img_url}, 0, 0, 0)")
	void insertGoods(Pet_goods insertGoods);
	
	//상품정보 전체 가져오기
	@Select("select * from pet_goods order by goods_code desc")
	List<Pet_goods> allGoodsList();
	
	//상품이름으로 범위 내 상품정보 전체 가져오기
	@Select("select * from pet_goods where goods_name like '%"+"#{goods_name}"+"%'")
	List<Pet_goods> allGoodsByName(String goods_name);
	
	//상품이름으로 단일상품 정보 전체 가져오기
	@Select("select * from pet_goods where goods_name=#{goods_name}")
	Pet_goods getGoodsByName(String goods_name);
		
	//상품코드로 단일상품 정보 전체 가져오기
	@Select("select * from pet_goods where goods_code=#{goods_code}")
	Pet_goods getGoodsByCode(long goods_code);
	
	//관리자페이지 상품리스트 코드(RowBounds가 적용되어있다)
	@Select("select * from pet_goods order by goods_code desc")
	List<Pet_goods> admin_allGoodsList(RowBounds rowBounds);
	
	//페이징을 위한 상품개수 반환코드
	@Select("select count(*) from pet_goods")
	int getGoodsCnt();
	
	//관리자페이지 상품 업데이트 코드
	@Update("update pet_goods set " +
			"category_big = #{category_big}, category_small = #{category_small}, " + 
			"goods_name = #{goods_name}, price = #{price}, " + 
			"option_1 = #{option_1}, option_2 = #{option_2}, " + 
			"info = #{info}, thumbnail_img_url = #{thumbnail_img_url}, " + 
			"detail_img_url = #{detail_img_url} " + 
			"where goods_code = #{goods_code}")
	void modifyGoodsInfo(Pet_goods pg);
	
	//관리자페이지 상품 삭제 코드
	@Delete("delete from pet_goods where goods_code = #{goods_code}")
	void deleteGoodsInfo(long goods_code);
	
	//대카테고리 중복제거후 가져오기
	@Select("select distinct ctg_big_ko, ctg_big_eng from pet_category")
	List<Pet_category> getBigCtgInfo();
	
	//작은카테고리 가져오기
	@Select("select ctg_small_ko, ctg_small_eng from pet_category where ctg_big_eng = #{ctg_big_eng}")
	List<Pet_category> getSmallCtgInfo(String ctg_big_eng);
	
	//세부카테고리 한글명 가져오기
	@Select("select ctg_small_ko from pet_category where ctg_small_eng = #{ctg_small_eng}")
	String getSmallCtgKoName(String ctg_small_eng);
	
	//메인페이지 큰카테고리기준 최신순으로 상품 4개씩 가져오기
	@Select("select * from pet_goods where category_big=#{ctg_big_eng} and rownum <=4 order by goods_code desc")
	List<Pet_goods> getMainGoodsInfo(String ctg_big_eng);
	
	//큰카테고리페이지 작은카테고리기준 최신순으로 상품 4개씩 가져오기
	@Select("select * from pet_goods where category_small=#{ctg_small_eng} and rownum <=4 order by goods_code desc")
	List<Pet_goods> getBigCtgGoodsInfo(String ctg_small_eng);
	
	//세부카테고리페이지 모든제품 가져오기
	@Select("select * from pet_goods where category_big=#{category_big}")
	List<Pet_goods> getAllSmallCtgGoodsInfo(@Param("category_big")String category_big, @Param("rowBounds") RowBounds rowBounds);
	
	//세부카테고리페이지 모든제품 페이징을 위한 상품개수 반환코드
	@Select("select count(*) from pet_goods where category_big=#{category_big}")
	int getAllSmallCtgGoodsCnt(@Param("category_big")String category_big);
		
	//세부카테고리페이지 특정카테고리 제품 가져오기
	@Select("select * from pet_goods where category_big=#{category_big} and category_small=#{category_small}")
	List<Pet_goods> getSmallCtgGoodsInfo(@Param("category_big")String category_big, @Param("category_small")String category_small, @Param("rowBounds") RowBounds rowBounds);
	
	//세부카테고리페이지 특정카테고리 페이징을 위한 상품개수 반환코드	
	@Select("select count(*) from pet_goods where category_big=#{category_big} and category_small=#{category_small}")
	int getSmallCtgGoodsCnt(@Param("category_big")String category_big, @Param("category_small")String category_small);
	
	//세부카테고리페이지 모든제품 가져오기(옵션적용)
	@Select("select * from pet_goods where category_big=#{category_big} order by ${option} desc")
	List<Pet_goods> getAllSmallCtgGoodsInfoByOption(@Param("category_big")String category_big, @Param("rowBounds") RowBounds rowBounds, @Param("option")String option);
	
	//세부카테고리페이지 특정카테고리 제품 가져오기(옵션적용)
	@Select("select * from pet_goods where category_big=#{category_big} and category_small=#{category_small} order by ${option} desc")
	List<Pet_goods> getSmallCtgGoodsInfoByOption(@Param("category_big")String category_big, @Param("category_small")String category_small, @Param("rowBounds") RowBounds rowBounds, @Param("option")String option);
	
	//메인페이지 리스트(관리자)
	@Select("select * from pet_goods where rownum <=3 order by purchase_number desc")
	List<Pet_goods> getAdminMainGoodsList();
	
}
