package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import co.sp.beans.Pet_cart;

//��ٱ���
public interface CartMapper {
		
	//��ٱ��Ͽ� ��ǰ �߰�
	@Insert("insert into pet_cart values(cart_seq.nextval, #{member_id}, #{goods_code}, "+
			"#{goods_name}, #{img_url}, #{price}, #{ea}, #{option1}, #{option2}, "+
			"#{total})")
	void insertGoodsIntoCart(Pet_cart goodsInCartBean);
	
	//��ٱ��� ������ǰ ��������
	@Update("update pet_cart set ea = #{ea}, total = #{total} where cart_idx = #{cart_idx}")
	void updateEaInCart(Pet_cart goodsInCartBean);
	
	//��ٱ��� �ҷ�����
	@Select("Select * from pet_cart where member_id=#{member_id}")
	List<Pet_cart> getAllGoodsintoCart(String member_id);
	
	//������ǰ �ҷ�����
	@Select("Select * from pet_cart where member_id=#{member_id} and cart_idx=#{cart_idx}")
	Pet_cart getGoodsintoCart(@Param("member_id")String member_id, @Param("cart_idx")long cart_idx);
	
	//��ٱ��Ͽ��� ��ǰ ����
	@Delete("delete from pet_cart where member_id=#{member_id} and cart_idx=#{cart_idx}")
	void deleteGoodsIntoCart(@Param("member_id")String member_id, @Param("cart_idx")long cart_idx);
	
	//��ٱ��� �ʱ�ȭ
	@Delete("delete from pet_cart where member_id=#{member_id}")
	void resetCart(String member_id);
}
