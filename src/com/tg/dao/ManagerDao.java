package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;

import com.tg.form.ManagerForm;

//�Ի�Ա��Ĳ���
public class ManagerDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public ManagerDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//ȫ����ѯ��Ϣ����
  public List selectManager() {
    List list = new ArrayList();
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement("select * from TG_manager order by id_manager DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	manager = new ManagerForm();
    	manager.setId_manager(rs.getInt(1));
    	manager.setName(rs.getString(2));
    	manager.setUsename(rs.getString(3));
    	manager.setPassword(rs.getString(4));
    	manager.setSign(rs.getInt(5));
        list.add(manager);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//�Թ���Ա��Ĳ�ѯ����
public void insertManager(ManagerForm form) {
  try {

    ps = connection.prepareStatement("insert into TG_manager values (?,?,?,?)");
    ps.setString(1, form.getUsename());
    ps.setString(2, form.getPassword());
    ps.setString(3, form.getName());
    ps.setInt(4, 0);
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException ex) {
  }
}

//�޸Ĺ���Ա����ķ���
public void updateManagerPassword(String password,int id) {
  try {
    ps = connection.prepareStatement("update TG_manager set password=? where id_manager=?");
    ps.setString(1, password);
    ps.setInt(2,id);
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException ex) {
  }
}


//ɾ������Ա�Ĳ���
public void deleteManager(int id) {
  try {
    ps = connection.prepareStatement("delete from TG_manager where id_manager=?");
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException ex) {
  }
}


//�Թ���Ա�˺�Ϊ������ѯ����Ա��Ϣ
public ManagerForm selectOne(String account) {
  ManagerForm manager = null;
  try {
    ps = connection.prepareStatement("select * from TG_manager where usename=?");
    ps.setString(1, account);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    	manager = new ManagerForm();
    	manager.setId_manager(rs.getInt(1));
    	manager.setName(rs.getString(2));
    	manager.setUsename(rs.getString(3));
    	manager.setPassword(rs.getString(4));
    	manager.setSign(rs.getInt(5));
    }
  }
  catch (SQLException ex) {
  }
  return manager;
}



}
