package co.sp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_category;
import co.sp.beans.Pet_goods;
import co.sp.mapper.GoodsMapper;


@Repository
public class GoodsDao {

	@Autowired
	private GoodsMapper goodsMapper;
	
	public void insertGoodsInfo(Pet_goods insertGoods) {
		goodsMapper.insertGoods(insertGoods);
	}
	
	public List<Pet_goods> allGoodsList(){
		return goodsMapper.allGoodsList();
	}
	
	public Pet_goods getGoodsInfo(long goods_code) {
		return goodsMapper.getGoodsByCode(goods_code);
	}

	public List<Pet_goods> admin_allGoodsList(RowBounds rowBounds) {
		return goodsMapper.admin_allGoodsList(rowBounds);
	}
	
	public Pet_goods getGoodsByCode(long goods_code) {
		return goodsMapper.getGoodsByCode(goods_code);
	}

	public int getGoodsCnt() {
		return goodsMapper.getGoodsCnt();
	}

	public void modifyGoodsInfo(Pet_goods pg) {
		goodsMapper.modifyGoodsInfo(pg);
	}

	public void deleteGoodsInfo(long goods_code) {
		goodsMapper.deleteGoodsInfo(goods_code);
	}

	public List<Pet_category> getBigCtgInfo() {
		 return goodsMapper.getBigCtgInfo();
	}

	public List<Pet_goods> getMainGoodsInfo(String ctg_big_eng) {
		return goodsMapper.getMainGoodsInfo(ctg_big_eng);
	}

	public List<Pet_category> getSmallCtgInfo(String big_ctg) {
		return goodsMapper.getSmallCtgInfo(big_ctg);
	}

	public List<Pet_goods> getBigCtgGoodsInfo(String ctg_small_eng) {
		return goodsMapper.getBigCtgGoodsInfo(ctg_small_eng);
	}

	public String getSmallCtgKoName(String small_ctg) {
		return goodsMapper.getSmallCtgKoName(small_ctg);
	}

	public List<Pet_goods> getAllSmallCtgGoodsInfo(String big_ctg, RowBounds rowBounds) {
		return goodsMapper.getAllSmallCtgGoodsInfo(big_ctg, rowBounds);
	}

	public List<Pet_goods> getSmallCtgGoodsInfo(String category_big, String category_small, RowBounds rowBounds) {
		return goodsMapper.getSmallCtgGoodsInfo(category_big, category_small, rowBounds);
	}

	public int getAllSmallCtgGoodsCnt(String big_ctg) {
		return goodsMapper.getAllSmallCtgGoodsCnt(big_ctg);
	}

	public int getSmallCtgGoodsCnt(String big_ctg, String small_ctg) {
		return goodsMapper.getSmallCtgGoodsCnt(big_ctg, small_ctg);
	}

	public List<Pet_goods> getAllSmallCtgGoodsInfoByOption(String big_ctg, RowBounds rowBounds, String option) {
		return goodsMapper.getAllSmallCtgGoodsInfoByOption(big_ctg, rowBounds, option);
	}

	public List<Pet_goods> getSmallCtgGoodsInfoByOption(String category_big, String category_small, RowBounds rowBounds,
			String option) {
		return goodsMapper.getSmallCtgGoodsInfoByOption(category_big, category_small, rowBounds, option);
	}

	public String[] allGoodsKeyword() {
		return goodsMapper.allGoodsKeyword();
	}

	public Pet_goods getGoodsByName(String keyword) {
		return goodsMapper.getGoodsByName(keyword);
	}

	public List<Pet_goods> getAdminMainGoodsList() {
		return goodsMapper.getAdminMainGoodsList();
	}

	
}
