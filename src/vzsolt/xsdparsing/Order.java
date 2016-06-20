package vzsolt.xsdparsing;
import java.util.List;

import vzsolt.xsdparsing.item;


public abstract class Order {
  private String orderPerson;
  private String destination;
  private List<item> orderedItem;
  private String orderId;
  
  

  public String getOrderPerson() {
    return orderPerson;
  }



  public void setOrderPerson(String orderPerson) {
    this.orderPerson = orderPerson;
  }



  public String getDestination() {
    return destination;
  }



  public void setDestination(String destination) {
    this.destination = destination;
  }



  public List<item> getOrderedItem() {
    return orderedItem;
  }



  public void setOrderedItem(List<item> orderedItem) {
    this.orderedItem = orderedItem;
  }



  public String getOrderId() {
    return orderId;
  }



  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }



  public Order() {
    // TODO Auto-generated constructor stub
  }
  
  

}
