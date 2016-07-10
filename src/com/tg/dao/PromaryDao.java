package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;

import com.tg.form.PromaryForm;
import com.tg.form.MemberForm;

//�Ի�Ա��Ĳ���
public class PromaryDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public PromaryDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//ȫ����ѯ�Ĳ���
  public List selectPromary() {
	    List list = new ArrayList();
	    PromaryForm promary = null;
	    try {
	      this.ps = connection.prepareStatement("select * from promary order by proID DESC");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        promary = new PromaryForm();
	        promary.setProID(rs.getInt(1));
	        promary.setProName(rs.getString(2));
	        list.add(promary);
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return list;
	  }

  //�����ݿ���ˮ��Ϊ������ѯʡ�ݵ�����
  public String selectName(int id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement("select * from promary where proId=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("ProName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

}
