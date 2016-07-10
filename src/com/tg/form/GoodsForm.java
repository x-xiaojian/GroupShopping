package com.tg.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

//会员表的bean
public class GoodsForm extends ActionForm {

	private String id_goods=""; // 商品自动编码

	
	private String area="" ; //地区

	private int sort=0; //  商品种类编码

	private String goods_name=""; // 商品名称

	private String goods_form=""; // 商品厂商

	private String introduce=""; // 商品介绍

	private String creat_time=""; //商品添加时间

	private String end_time=""; //商品结束时间
	
	private float price=0; //商品价格
	
	private float freeprice=0; //商品优惠价格
	
	private String goods_image="";//商品图片
	
	private int number=1;//商品已团购数

	private boolean mark=true;//是否特价商品
	
	private FormFile formFile;
	
	public GoodsForm() {
	}
	
	public String getId_goods() {
		return id_goods;
	}
	
	public void setId_goods(String id_goods) {
		this.id_goods = id_goods;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_form() {
		return goods_form;
	}
	public void setGoods_form(String goods_form) {
		this.goods_form = goods_form;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}
	
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getFreeprice() {
		return freeprice;
	}
	public void setFreeprice(float freeprice) {
		this.freeprice = freeprice;
	}
	public String getGoods_image() {
		return goods_image;
	}
	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isMark() {
		return mark;
	}
	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	
}
	