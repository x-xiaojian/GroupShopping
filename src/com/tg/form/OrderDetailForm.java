package com.tg.form;

import javax.servlet.http.*;

import org.apache.struts.action.*;
//订货明细表的bean
public class OrderDetailForm
    extends ActionForm {
  private int goodsId=-1;
  private int id=-1;
  private String orderNumber;
  private float price;

  private int number;

  public int getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public int getNumber() {
    return number;
  }

  public float getPrice() {
    return price;
  }

  public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
      /** @todo: finish this method, this is just the skeleton.*/
    return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
}
