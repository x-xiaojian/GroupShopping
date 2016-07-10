package com.tg.dao;

import java.sql.*;
import java.util.*;

import com.tg.tools.JDBConnection;
import com.tg.form.LinkForm;

//������������վ��Ĳ���
public class LinkDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public LinkDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

  //ɾ���ķ���
  public void deleteLink(int id) {
    try {
      ps = connection.prepareStatement("delete from TG_link where id_link=?");
      ps.setInt(1, id);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }



//��ӵķ���
  public void insertLink(LinkForm form) {
    try {
      ps = connection.prepareStatement("insert into TG_link values (?,?)");
      ps.setString(1, form.getLinkName());
      ps.setString(2, form.getLinkAddress());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }




//ȫ����ѯ�ķ���
  public List selectLink() {
    List list = new ArrayList();
    LinkForm link = null;
    try {
      ps = connection.prepareStatement("select * from TG_link order by id_link DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        link = new LinkForm();
        link.setId(Integer.valueOf(rs.getString(1)));
        link.setLinkName(rs.getString(2));
        link.setLinkAddress(rs.getString(3));
        list.add(link);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
