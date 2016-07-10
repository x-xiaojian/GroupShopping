package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;
import com.tg.form.TypeForm;

//�Գ��б�Ĳ���
public class TypeDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public TypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//ȫ����ѯ�Ĳ���
  public List selectType() {
	    List list = new ArrayList();
	    TypeForm sort = null;
	    try {
	      this.ps = connection.prepareStatement("select * from tg_type order by typ_id DESC");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	sort = new TypeForm();
	    	sort.setTyp_id(rs.getInt(1));
	    	sort.setTyp_name(rs.getString(2));
	    	sort.setCreat_time(rs.getString(3));
	        list.add(sort);
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return list;
	  }

//ȫ����ѯ�Ĳ���
  public TypeForm selectOneType(int id) {
	    TypeForm sort = null;
	    try {
	      this.ps = connection.prepareStatement("select * from tg_type where typ_id=? order by typ_id DESC");
	      ps.setInt(1, id);
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	sort = new TypeForm();
	    	sort.setTyp_id(rs.getInt(1));
	    	sort.setTyp_name(rs.getString(2));
	    	sort.setCreat_time(rs.getString(3));
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return sort;
	  }


}
