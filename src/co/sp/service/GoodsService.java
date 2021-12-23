package co.sp.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import co.sp.beans.Page;
import co.sp.beans.Pet_category;
import co.sp.beans.Pet_goods;
import co.sp.dao.GoodsDao;

@Service
@PropertySource("/WEB-INF/properties/page.properties")
public class GoodsService {
	
	//출력할 게시글갯수
	@Value("${admin_goods.page.listcount}")
	private int admin_goods_page_list_cnt;
	
	//출력할 이전, 다음사이 페이징갯수
	@Value("${admin_goods.page.pa}")
	private int admin_goods_page_pa;
	
	//출력할 게시글갯수
	@Value("${client_goods.page.listcount}")
	private int client_goods_page_list_cnt;
		
	//출력할 이전, 다음사이 페이징갯수
	@Value("${client_goods.page.pa}")
	private int client_goods_page_pa;
	
	@Autowired
	private GoodsDao goodsDao;
	
	public void InsertGoodsInfo(Pet_goods addGoods) {
		goodsDao.insertGoodsInfo(addGoods);
	}
	
	public List<Pet_goods> allGoodsList(){
		return goodsDao.allGoodsList();
	}
	
	public Pet_goods getGoodsInfo(long goods_code) {
		return goodsDao.getGoodsInfo(goods_code);
	}
	
	public Pet_goods getGoodsByCode(long goods_code) {
		return goodsDao.getGoodsByCode(goods_code);
	}

	public List<Pet_goods> admin_allGoodsList(int page) {
		int start = (page - 1) * admin_goods_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, admin_goods_page_list_cnt);
		return goodsDao.admin_allGoodsList(rowBounds);
	}
	
	public List<Pet_goods> getAllSmallCtgGoodsInfo(String big_ctg, int page) {
		int start = (page - 1) * client_goods_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, client_goods_page_list_cnt);
		return goodsDao.getAllSmallCtgGoodsInfo(big_ctg, rowBounds);
	}

	public List<Pet_goods> getSmallCtgGoodsInfo(String category_big, String category_small, int page) {
		int start = (page - 1) * client_goods_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, client_goods_page_list_cnt);
		return goodsDao.getSmallCtgGoodsInfo(category_big, category_small, rowBounds);
	}

	public Page getGoodsCnt(int current_page) {
		int goods_cnt = goodsDao.getGoodsCnt();
		Page pageBean = new Page(goods_cnt, current_page, admin_goods_page_list_cnt, admin_goods_page_pa);
		return pageBean;
	}
	
	public Page getClientGoodsCnt(int current_page) {
		int goods_cnt = goodsDao.getGoodsCnt();
		Page pageBean = new Page(goods_cnt, current_page, client_goods_page_list_cnt, client_goods_page_pa);
		return pageBean;
	}

	public void modifyGoodsInfo(Pet_goods pg) {
		goodsDao.modifyGoodsInfo(pg);
	}

	public void deleteGoodsInfo(long goods_code) {
		goodsDao.deleteGoodsInfo(goods_code);
	}

	public List<Pet_category> getBigCtgInfo() {
		 return goodsDao.getBigCtgInfo();
	}

	public List<Pet_goods> getMainGoodsInfo(String ctg_big_eng) {
		return goodsDao.getMainGoodsInfo(ctg_big_eng);
	}

	public List<Pet_category> getSmallCtgInfo(String big_ctg) {
		return goodsDao.getSmallCtgInfo(big_ctg);
	}

	public List<Pet_goods> getBigCtgGoodsInfo(String ctg_small_eng) {
		return goodsDao.getBigCtgGoodsInfo(ctg_small_eng);
	}

	public String getSmallCtgKoName(String small_ctg) {
		return goodsDao.getSmallCtgKoName(small_ctg);
	}

	public Page getAllSmallCtgGoodsCnt(int current_page, String big_ctg) {
		int goods_cnt = goodsDao.getAllSmallCtgGoodsCnt(big_ctg);
		Page pageBean = new Page(goods_cnt, current_page, client_goods_page_list_cnt, client_goods_page_pa);
		return pageBean;
	}

	public Page getSmallCtgGoodsCnt(int current_page, String big_ctg, String small_ctg) {
		int goods_cnt = goodsDao.getSmallCtgGoodsCnt(big_ctg, small_ctg);
		Page pageBean = new Page(goods_cnt, current_page, client_goods_page_list_cnt, client_goods_page_pa);
		return pageBean;
	}

	public List<Pet_goods> getAllSmallCtgGoodsInfoByOption(String big_ctg, int page, String option) {
		int start = (page - 1) * client_goods_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, client_goods_page_list_cnt);
		return goodsDao.getAllSmallCtgGoodsInfoByOption(big_ctg, rowBounds, option);
	}

	public List<Pet_goods> getSmallCtgGoodsInfoByOption(String category_big, String category_small, int page, String option) {
		int start = (page - 1) * client_goods_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, client_goods_page_list_cnt);
		return goodsDao.getSmallCtgGoodsInfoByOption(category_big, category_small, rowBounds, option);
	}

	public String[] allGoodsKeyword() {
		return goodsDao.allGoodsKeyword();
	}

	public Pet_goods getGoodsByName(String keyword) {
		return goodsDao.getGoodsByName(keyword);
	}

	public List<Pet_goods> getAdminMainGoodsList() {
		return goodsDao.getAdminMainGoodsList();
	}

	

	

}
