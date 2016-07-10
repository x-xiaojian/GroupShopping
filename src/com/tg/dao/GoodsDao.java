package com.tg.dao;

import java.sql.*;
import java.util.*;

import com.tg.tools.JDBConnection;
import com.tg.form.CityForm;
import com.tg.form.GoodsForm;

//����Ʒ��Ĳ���
public class GoodsDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public GoodsDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

//������Ʒ��ID�޸Ĺ�����Ʒ������
  public void updateGoodsNumber(int number, Integer id) {
    try {
      ps = connection.prepareStatement("update TG_goods set number=number+? where id_goods=?");
      ps.setInt(1, number);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
 }
  
//��ѯ����
	public CityForm selectOneCity(int cityid,int proid) {
		CityForm city = null;
	    try {
	      ps = connection.prepareStatement("select * from city where cityId=? and proId=?");
	      ps.setInt(1, cityid);
	      ps.setInt(2, proid);
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	  city = new CityForm(); 
	    	  city.setCityID(rs.getInt(1));
			  city.setCityName(rs.getString(2));
			  city.setProID(rs.getInt(3));
	      }
	    }  
	    catch (SQLException ex) {
	    }
	    return city;  
	  }
  

//��Ӳ���
  public void insertGoods(GoodsForm form) {
    try {
      ps = connection.prepareStatement("insert into TG_goods " +
          "(area,sort,goods_name,goods_form,introduce,creat_time,price,freeprice,number,goods_image) values (?,?,?,?,?,getDate(),?,?,?,?)");
      ps.setString(1, form.getArea());
      ps.setInt(2, form.getSort());
      ps.setString(3, form.getGoods_name());
      ps.setString(4, form.getGoods_form());
      ps.setString(5, form.getIntroduce());
      ps.setFloat(6, form.getPrice());
      ps.setFloat(7, form.getFreeprice());
      ps.setInt(8, 0);
      ps.setString(9, form.getGoods_image());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }
//
//����Ʒ���Ϊ����ɾ����Ϣ
  public void deleteGoods(Integer id) {
    try {
      ps = connection.prepareStatement("delete from TG_goods where id_goods=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//����Ʒ�ı��Ϊ������ѯ��Ϣ
  public GoodsForm selectOneGoods(int id) {
    GoodsForm goods = new GoodsForm();
    try {
      ps = connection.prepareStatement("select * from TG_goods where id_goods=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  System.out.println("ququ");
          goods.setId_goods(rs.getString(1));
          goods.setArea(rs.getString(2));
          goods.setSort(rs.getInt(3));
          goods.setGoods_name(rs.getString(4));
          goods.setGoods_form(rs.getString(5));
          goods.setIntroduce(rs.getString(6));
          goods.setCreat_time(rs.getString(7));
          goods.setEnd_time(rs.getString(8));
          goods.setPrice(rs.getFloat(9));
          goods.setFreeprice(rs.getFloat(10));
          goods.setGoods_image(rs.getString(11));
          goods.setNumber(rs.getInt(12));
          goods.setMark(rs.getBoolean(13));
      }
    }
    catch (SQLException ex) {
    }
    return goods;
  }

//  //����Ʒ��С���ı��Ϊ������ѯ��Ϣ
//  public List selectSmall(Integer small) {
//    List list = new ArrayList();
//    GoodsForm goods = null;
//    try {
//      ps = connection.prepareStatement("select * from tb_goods where smallId=? order by id DESC");
//      ps.setInt(1, small.intValue());
//      ResultSet rs = ps.executeQuery();
//      while (rs.next()) {
//        goods = new GoodsForm();
//        goods.setId(Integer.valueOf(rs.getString(1)));
//        goods.setBig(Integer.valueOf(rs.getString(2)));
//        goods.setSmall(Integer.valueOf(rs.getString(3)));
//        goods.setName(rs.getString(4));
//        goods.setFrom(rs.getString(5));
//        goods.setIntroduce(rs.getString(6));
//        goods.setCreaTime(rs.getString(7));
//        goods.setNowPrice(Float.valueOf(rs.getString(8)));
//        goods.setFreePrice(Float.valueOf(rs.getString(9)));
//        goods.setNumber(Integer.valueOf(rs.getString(10)));
//        goods.setPriture(rs.getString(11));
//        goods.setMark(Integer.valueOf(rs.getString(12)));
//        list.add(goods);
//      }
//    }
//    catch (SQLException ex) {
//    }
//    return list;
//  }
//
  
//����Ʒ�����ı��Ϊ������ѯ��Ϣ
  public List selectType(int id,String area){
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from TG_goods  where sort=? and area=? order by id_goods DESC");
      ps.setInt(1,id);
      ps.setString(2, area);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId_goods(rs.getString(1));
        goods.setArea(rs.getString(2));
        goods.setSort(rs.getInt(3));
        goods.setGoods_name(rs.getString(4));
        goods.setGoods_form(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreat_time(rs.getString(7));
        goods.setEnd_time(rs.getString(8));
        goods.setPrice(rs.getFloat(9));
        goods.setFreeprice(rs.getFloat(10));
        goods.setGoods_image(rs.getString(11));
        goods.setNumber(rs.getInt(12));
        goods.setMark(rs.getBoolean(13));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }
  
  
  //����Ʒ�����ı��Ϊ������ѯ��Ϣ
  public List selectFirst() {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from TG_goods  order by  id_goods DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId_goods(rs.getString(1));
        goods.setArea(rs.getString(2));
        goods.setSort(rs.getInt(3));
        goods.setGoods_name(rs.getString(4));
        goods.setGoods_form(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreat_time(rs.getString(7));
        goods.setEnd_time(rs.getString(8));
        goods.setPrice(rs.getFloat(9));
        goods.setFreeprice(rs.getFloat(10));
        goods.setGoods_image(rs.getString(11));
        goods.setNumber(rs.getInt(12));
        goods.setMark(rs.getBoolean(13));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //����Ʒ�����ı��Ϊ������ѯ��Ϣ
  public List selectGoodsByCity(String area) {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from TG_goods where area=? order by  id_goods DESC");
      ps.setString(1,area);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId_goods(rs.getString(1));
        goods.setArea(rs.getString(2));
        goods.setSort(rs.getInt(3));
        goods.setGoods_name(rs.getString(4));
        goods.setGoods_form(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreat_time(rs.getString(7));
        goods.setEnd_time(rs.getString(8));
        goods.setPrice(rs.getFloat(9));
        goods.setFreeprice(rs.getFloat(10));
        goods.setGoods_image(rs.getString(11));
        goods.setNumber(rs.getInt(12));
        goods.setMark(rs.getBoolean(13));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  } 
  
  
//ȫ����ѯ
  public List selectGoods() {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from TG_goods order by id_goods DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId_goods(rs.getString(1));
          goods.setArea(rs.getString(2));
          goods.setSort(rs.getInt(3));
          goods.setGoods_name(rs.getString(4));
          goods.setGoods_form(rs.getString(5));
          goods.setIntroduce(rs.getString(6));
          goods.setCreat_time(rs.getString(7));
          goods.setEnd_time(rs.getString(8));
          goods.setPrice(rs.getFloat(9));
          goods.setFreeprice(rs.getFloat(10));
          goods.setGoods_image(rs.getString(11));
          goods.setNumber(rs.getInt(12));
          goods.setMark(rs.getBoolean(13));
          list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //ȫ����ѯ
  public List selectGoodsNumber() {
    List list = new ArrayList();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from TG_goods order by number DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  goods = new GoodsForm();
          goods.setId_goods(rs.getString(1));
          goods.setArea(rs.getString(2));
          goods.setSort(rs.getInt(3));
          goods.setGoods_name(rs.getString(4));
          goods.setGoods_form(rs.getString(5));
          goods.setIntroduce(rs.getString(6));
          goods.setCreat_time(rs.getString(7));
          goods.setEnd_time(rs.getString(8));
          goods.setPrice(rs.getFloat(9));
          goods.setFreeprice(rs.getFloat(10));
          goods.setGoods_image(rs.getString(11));
          goods.setNumber(rs.getInt(12));
          goods.setMark(rs.getBoolean(13));
          list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }


}
