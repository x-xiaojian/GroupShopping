package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;
import com.tg.form.OrderDetailForm;

//������ϸ��Ĳ���
public class OrderDetailDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public OrderDetailDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }
public List selectOrderDetailNumber(String number){
  List list =new ArrayList();
  OrderDetailForm orderDetail=null;
  try {
    ps = connection.prepareStatement("select * from TG_orderDetail where orderNumber=?");
    ps.setString(1,number);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
      orderDetail=new OrderDetailForm();
      orderDetail.setId(Integer.parseInt(rs.getString(1)));
      orderDetail.setOrderNumber(rs.getString(2));
      orderDetail.setGoodsId(Integer.parseInt(rs.getString(3)));
      orderDetail.setPrice(Float.parseFloat(rs.getString(4)));
      orderDetail.setNumber(Integer.parseInt(rs.getString(5)));
      list.add(orderDetail);
    }
  }
  catch (SQLException ex) {
  }
    return list;
}


//��ӵķ���
  public void insertOrderDetail(OrderDetailForm form) {
    try {
      ps = connection.prepareStatement("insert into TG_orderDetail values (?,?,?,?)");
      ps.setString(1, form.getOrderNumber());
      ps.setInt(2, form.getGoodsId());
      ps.setFloat(3, form.getPrice());
      ps.setInt(4, form.getNumber());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //ɾ���ӱ�Ĳ���
  public void deleteOrderDetail(String number){
    try {
      ps = connection.prepareStatement("delete from TG_orderDetail where orderNumber=?");
      ps.setString(1,number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }


  }

}
