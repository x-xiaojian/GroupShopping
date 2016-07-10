package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;
import com.tg.form.MemberForm;

//�Ի�Ա��Ĳ���
public class MemberDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public MemberDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//�����ݿ���ˮ��Ϊ�����޸Ļ�Ա������
  public boolean updatePassword(String password, int id_member) {
    try {
      ps = connection.prepareStatement("update tb_member set password=? where member_id=?");
      ps.setString(1, password);
      ps.setInt(2, id_member);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }


  
//�һ�����֮��
  public MemberForm selectFind(String name, String result) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select * from tg_member where name=? and result=?");
      ps.setString(1, name);
      ps.setString(2, result);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setEmail(rs.getString(1));
        member.setId_member(rs.getInt(2));
        member.setName(rs.getString(3));
        member.setUsename(rs.getString(4));
        member.setPassword(rs.getString(5));
        member.setTel(rs.getString(6));
        member.setBirthdate(rs.getString(7));
        member.setSex(rs.getBoolean(8));
        member.setArea(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

  //ȫ����ѯ�Ĳ������Ի�Ա����Ϊ������ѯ��Ϣ
  public MemberForm selectMemberForm(String email) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select * from TG_member where email=?");
      ps.setString(1,email);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setEmail(rs.getString(1));
        member.setId_member(rs.getInt(2));
        member.setName(rs.getString(3));
        member.setUsename(rs.getString(4));
        member.setPassword(rs.getString(5));
        member.setTel(rs.getString(6));
        member.setBirthdate(rs.getString(7));
        member.setSex(rs.getBoolean(8));
        member.setArea(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

//ȫ����ѯ�Ĳ������Ի�Ա����Ϊ������ѯ��Ϣ
  public MemberForm selectMemberName(String name) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select * from TG_member where usename=?");
      ps.setString(1,name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setEmail(rs.getString(1));
        member.setId_member(rs.getInt(2));
        member.setName(rs.getString(3));
        member.setUsename(rs.getString(4));
        member.setPassword(rs.getString(5));
        member.setTel(rs.getString(6));
        member.setBirthdate(rs.getString(7));
        member.setSex(rs.getBoolean(8));
        member.setArea(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

  
  
  //ȫ����ѯ�Ĳ������Ի�Ա����Ϊ������ѯ��Ϣ
  public MemberForm selectMemberFormByName(String usename) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select * from TG_member where usename=?");
      ps.setString(1,usename);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setEmail(rs.getString(1));
        member.setId_member(rs.getInt(2));
        member.setName(rs.getString(3));
        member.setUsename(rs.getString(4));
        member.setPassword(rs.getString(5));
        member.setTel(rs.getString(6));
        member.setBirthdate(rs.getString(7));
        member.setSex(rs.getBoolean(8));
        member.setArea(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }
  
//ɾ������
  public boolean deleteMember(int id) {
    try {
      ps = connection.prepareStatement("delete from TG_member where id_member=?");
      ps.setInt(1, id);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

//�����Ϣ
  public void insertMember(MemberForm form) {
    try {
      ps = connection.prepareStatement("insert into TG_member (email,usename,password,area) values (?,?,?,?)");
      ps.setString(1, form.getEmail());
      ps.setString(2, form.getUsename());
      ps.setString(3, form.getPassword());
      ps.setString(4, form.getArea());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //�����ݿ���ˮ��Ϊ�����޸���Ϣ
  public void updateMember(MemberForm form) {
    try {
      ps = connection.prepareStatement("update TG_member set email=?,name=?,usename=?,password=?,tel=?,birthdate=?,sex=?,area=? where id_member=?");
      ps.setString(1, form.getEmail());
      ps.setString(2, form.getName());
      ps.setString(3, form.getUsename());
      ps.setString(4, form.getPassword());
      ps.setString(5, form.getTel());
      ps.setString(6, form.getBirthdate());
      ps.setBoolean(7, form.getSex());
      ps.setString(8, form.getArea());
      ps.setInt(9, form.getId_member());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }



//ȫ����ѯ��Ϣ����
  public List selectMember() {
    List list = new ArrayList();
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select * from TG_member order by id_member DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setEmail(rs.getString(1));
        member.setId_member(rs.getInt(2));
        member.setName(rs.getString(3));
        member.setUsename(rs.getString(4));
        member.setPassword(rs.getString(5));
        member.setTel(rs.getString(6));
        member.setBirthdate(rs.getString(7));
        member.setSex(rs.getBoolean(8));
        member.setArea(rs.getString(9));
        list.add(member);
        System.out.println("10");
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//�����ݿ���ˮ��Ϊ������ѯ��Ϣ
  public MemberForm selectOneMember(int id) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select * from TG_member where id_member=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setEmail(rs.getString(1));
        member.setId_member(rs.getInt(2));
        member.setName(rs.getString(3));
        member.setUsename(rs.getString(4));
        member.setPassword(rs.getString(5));
        member.setTel(rs.getString(6));
        member.setBirthdate(rs.getString(7));
        member.setSex(rs.getBoolean(8));
        member.setArea(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }




}
