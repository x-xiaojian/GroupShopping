package com.tg.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

//��Ա���bean
public class GoodsForm extends ActionForm {

	private String id_goods=""; // ��Ʒ�Զ�����

	
	private String area="" ; //����

	private int sort=0; //  ��Ʒ�������

	private String goods_name=""; // ��Ʒ����

	private String goods_form=""; // ��Ʒ����

	private String introduce=""; // ��Ʒ����

	private String creat_time=""; //��Ʒ���ʱ��

	private String end_time=""; //��Ʒ����ʱ��
	
	private float price=0; //��Ʒ�۸�
	
	private float freeprice=0; //��Ʒ�Żݼ۸�
	
	private String goods_image="";//��ƷͼƬ
	
	private int number=1;//��Ʒ���Ź���

	private boolean mark=true;//�Ƿ��ؼ���Ʒ
	
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
	