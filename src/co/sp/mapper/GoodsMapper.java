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

//pet_goods table�� ��ȣ�ۿ��ϴ� ������ ����
public interface GoodsMapper {
	
	//�˻��� ���� ��� ��ǰ�� ��������
	@Select("select goods_name from pet_goods")
	String[] allGoodsKeyword();
	
	//��ǰ���
	@Insert("insert into pet_goods values(#{category_big}, #{category_small}, goods_seq.nextval, #{goods_name}, #{price}, #{option_1}, #{option_2}, #{info}, #{thumbnail_img_url}, #{detail_img_url}, 0, 0, 0)")
	void insertGoods(Pet_goods insertGoods);
	
	//��ǰ���� ��ü ��������
	@Select("select * from pet_goods order by goods_code desc")
	List<Pet_goods> allGoodsList();
	
	//��ǰ�̸����� ���� �� ��ǰ���� ��ü ��������
	@Select("select * from pet_goods where goods_name like '%"+"#{goods_name}"+"%'")
	List<Pet_goods> allGoodsByName(String goods_name);
	
	//��ǰ�̸����� ���ϻ�ǰ ���� ��ü ��������
	@Select("select * from pet_goods where goods_name=#{goods_name}")
	Pet_goods getGoodsByName(String goods_name);
		
	//��ǰ�ڵ�� ���ϻ�ǰ ���� ��ü ��������
	@Select("select * from pet_goods where goods_code=#{goods_code}")
	Pet_goods getGoodsByCode(long goods_code);
	
	//������������ ��ǰ����Ʈ �ڵ�(RowBounds�� ����Ǿ��ִ�)
	@Select("select * from pet_goods order by goods_code desc")
	List<Pet_goods> admin_allGoodsList(RowBounds rowBounds);
	
	//����¡�� ���� ��ǰ���� ��ȯ�ڵ�
	@Select("select count(*) from pet_goods")
	int getGoodsCnt();
	
	//������������ ��ǰ ������Ʈ �ڵ�
	@Update("update pet_goods set " +
			"category_big = #{category_big}, category_small = #{category_small}, " + 
			"goods_name = #{goods_name}, price = #{price}, " + 
			"option_1 = #{option_1}, option_2 = #{option_2}, " + 
			"info = #{info}, thumbnail_img_url = #{thumbnail_img_url}, " + 
			"detail_img_url = #{detail_img_url} " + 
			"where goods_code = #{goods_code}")
	void modifyGoodsInfo(Pet_goods pg);
	
	//������������ ��ǰ ���� �ڵ�
	@Delete("delete from pet_goods where goods_code = #{goods_code}")
	void deleteGoodsInfo(long goods_code);
	
	//��ī�װ� �ߺ������� ��������
	@Select("select distinct ctg_big_ko, ctg_big_eng from pet_category")
	List<Pet_category> getBigCtgInfo();
	
	//����ī�װ� ��������
	@Select("select ctg_small_ko, ctg_small_eng from pet_category where ctg_big_eng = #{ctg_big_eng}")
	List<Pet_category> getSmallCtgInfo(String ctg_big_eng);
	
	//����ī�װ� �ѱ۸� ��������
	@Select("select ctg_small_ko from pet_category where ctg_small_eng = #{ctg_small_eng}")
	String getSmallCtgKoName(String ctg_small_eng);
	
	//���������� ūī�װ����� �ֽż����� ��ǰ 4���� ��������
	@Select("select * from pet_goods where category_big=#{ctg_big_eng} and rownum <=4 order by goods_code desc")
	List<Pet_goods> getMainGoodsInfo(String ctg_big_eng);
	
	//ūī�װ������� ����ī�װ����� �ֽż����� ��ǰ 4���� ��������
	@Select("select * from pet_goods where category_small=#{ctg_small_eng} and rownum <=4 order by goods_code desc")
	List<Pet_goods> getBigCtgGoodsInfo(String ctg_small_eng);
	
	//����ī�װ������� �����ǰ ��������
	@Select("select * from pet_goods where category_big=#{category_big}")
	List<Pet_goods> getAllSmallCtgGoodsInfo(@Param("category_big")String category_big, @Param("rowBounds") RowBounds rowBounds);
	
	//����ī�װ������� �����ǰ ����¡�� ���� ��ǰ���� ��ȯ�ڵ�
	@Select("select count(*) from pet_goods where category_big=#{category_big}")
	int getAllSmallCtgGoodsCnt(@Param("category_big")String category_big);
		
	//����ī�װ������� Ư��ī�װ� ��ǰ ��������
	@Select("select * from pet_goods where category_big=#{category_big} and category_small=#{category_small}")
	List<Pet_goods> getSmallCtgGoodsInfo(@Param("category_big")String category_big, @Param("category_small")String category_small, @Param("rowBounds") RowBounds rowBounds);
	
	//����ī�װ������� Ư��ī�װ� ����¡�� ���� ��ǰ���� ��ȯ�ڵ�	
	@Select("select count(*) from pet_goods where category_big=#{category_big} and category_small=#{category_small}")
	int getSmallCtgGoodsCnt(@Param("category_big")String category_big, @Param("category_small")String category_small);
	
	//����ī�װ������� �����ǰ ��������(�ɼ�����)
	@Select("select * from pet_goods where category_big=#{category_big} order by ${option} desc")
	List<Pet_goods> getAllSmallCtgGoodsInfoByOption(@Param("category_big")String category_big, @Param("rowBounds") RowBounds rowBounds, @Param("option")String option);
	
	//����ī�װ������� Ư��ī�װ� ��ǰ ��������(�ɼ�����)
	@Select("select * from pet_goods where category_big=#{category_big} and category_small=#{category_small} order by ${option} desc")
	List<Pet_goods> getSmallCtgGoodsInfoByOption(@Param("category_big")String category_big, @Param("category_small")String category_small, @Param("rowBounds") RowBounds rowBounds, @Param("option")String option);
	
	//���������� ����Ʈ(������)
	@Select("select * from pet_goods where rownum <=3 order by purchase_number desc")
	List<Pet_goods> getAdminMainGoodsList();
	
}
