package com.tg.dao;

import java.sql.*;
import java.util.*;

import com.tg.tools.JDBConnection;
import com.tg.form.AfficheForm;

//对公告信息的操作
public class AfficheDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public AfficheDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //删除的方法
  public void deleteAffiche(Integer id) {
    try {
      ps = connection.prepareStatement("delete from TG_affiche where id_affiche=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //修改的方法
  public void updateAffiche(AfficheForm form) {
    try {
      ps = connection.prepareStatement("update TG_affiche set affiche_name=?,content=? where id_affiche=?");
      ps.setString(1, form.getAffiche_name());
      ps.setString(2, form.getContent());
      ps.setInt(3, form.getId_affiche());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//添加的方法
  public void insertAffiche(AfficheForm form) {
    try {
      ps = connection.prepareStatement("insert into TG_affiche values (?,?,getDate())");
      ps.setString(1, form.getAffiche_name());
      ps.setString(2, form.getContent());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//以数据库流水号为条件查询信息
  public AfficheForm selectOneAffiche(Integer id) {
    AfficheForm affiche = null;
    try {
      ps = connection.prepareStatement("select * from TG_affiche where id_affiche=?");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        affiche = new AfficheForm();
        affiche.setId_affiche(rs.getInt(1));
        affiche.setAffiche_name(rs.getString(2));
        affiche.setContent(rs.getString(3));
        affiche.setCreat_time(rs.getString(4));
      }
    } 
    catch (SQLException ex) {
    }
    return affiche;
  }

//全部查询的方法
  public List selectAffiche() {
    List list = new ArrayList();
    AfficheForm affiche = null;
    try {
      ps = connection.prepareStatement("select * from TG_affiche order by id_affiche DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        affiche = new AfficheForm();
        affiche.setId_affiche(rs.getInt(1));
        affiche.setAffiche_name(rs.getString(2));
        affiche.setContent(rs.getString(3));
        affiche.setCreat_time(rs.getString(4));
        list.add(affiche);
      }
    }
    catch (SQLException ex) {
    }
    return list;

  }

}
