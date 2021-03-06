package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;
import com.tg.form.OrderForm;

//订货表的操作
public class OrderDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public OrderDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

//前台订货查询
  public List selectOrderHead(String name) {
  List list=new ArrayList();
    OrderForm order = null;
   try {
     ps = connection.prepareStatement("select * from TG_order where usename=?");
     ps.setString(1, name);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {
       order = new OrderForm();
       order.setId(Integer.valueOf(rs.getString(1)));
       order.setNumber(rs.getString(2));
       order.setName(rs.getString(3));
       order.setReallyName(rs.getString(4));
       order.setAddress(rs.getString(5));
       order.setTel(rs.getString(6));
       order.setSetMoney(rs.getString(7));
       order.setPost(rs.getString(8));
       order.setBz(rs.getString(9));
       order.setSign(rs.getString(10));
       order.setCreaTime(rs.getString(11));
       list.add(order);

     }
   }
   catch (SQLException ex) {
   }
   return list;
 }



  //以订货编号为条件查询信息
  public OrderForm selectOrderNumber(String number) {

    OrderForm order = null;
    try {
      ps = connection.prepareStatement("select * from TG_order where number=?");
      ps.setString(1, number);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new OrderForm();
        order.setId(Integer.valueOf(rs.getString(1)));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setSetMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(rs.getString(10));
        order.setCreaTime(rs.getString(11));

      }
    }
    catch (SQLException ex) {
    }
    return order;
  }

  //出货操作
  public void updateSignOrder(String number) {
    try {
      ps = connection.prepareStatement("update TG_order set sign=1 where number=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }

  }

//删除订货信息
  public boolean deleteOrder(String number) {
    try {
      ps = connection.prepareStatement("delete from TG_order where number=?");
      ps.setString(1, number);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }

  }

//以订货标记为条件查询信息
  public List selectOrderSign(int id) {
    List list = new ArrayList();
    OrderForm order = null;
    try {
      if (id ==-1) {
        ps = connection.prepareStatement("select * from TG_order order by id_order DESC");
      }
      else {
        ps = connection.prepareStatement("select * from TG_order where sign=? order by id_order DESC");
        ps.setInt(1, id);
      }
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        order = new OrderForm();
        order.setId(Integer.valueOf(rs.getString(1)));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setSetMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(rs.getString(10));
        order.setCreaTime(rs.getString(11));
        list.add(order);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//添加的方法
  public void insertOrderDetail(OrderForm form) {
    try {
      ps = connection.prepareStatement("insert into TG_order values (?,?,?,?,?,?,?,?,?,getDate())");
      ps.setString(1, form.getNumber());
      ps.setString(2, form.getName());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAddress());
      ps.setString(5, form.getTel());
      ps.setString(6, form.getSetMoney());
      ps.setString(7, form.getPost());
      ps.setString(8, form.getBz());
      ps.setString(9, form.getSign());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {

    }
  }
}
