package com.tg.dao;

import java.sql.*;
import java.util.*;

import com.tg.tools.JDBConnection;
import com.tg.form.AfficheForm;

//�Թ�����Ϣ�Ĳ���
public class AfficheDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public AfficheDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

  //ɾ���ķ���
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

  //�޸ĵķ���
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

//��ӵķ���
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

//�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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

//ȫ����ѯ�ķ���
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
