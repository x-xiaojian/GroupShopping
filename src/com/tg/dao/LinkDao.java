package com.tg.dao;

import java.sql.*;
import java.util.*;

import com.tg.tools.JDBConnection;
import com.tg.form.LinkForm;

//对友情连接网站表的操作
public class LinkDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public LinkDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //删除的方法
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



//添加的方法
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




//全部查询的方法
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
