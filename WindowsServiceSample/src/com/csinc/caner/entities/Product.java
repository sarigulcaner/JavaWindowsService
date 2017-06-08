package com.csinc.caner.entities;
import org.json.simple.*;
public class Product extends EntityBase {

	public String Name;
	public int OrderNo;
	
	public Product()
	{
	super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
	
	public JSONObject toJson() {
		JSONObject jsObj = new JSONObject();
		jsObj.put("ID".toString(),String.valueOf(this.ID));
		jsObj.put("Name", this.Name);
		jsObj.put("OrderNo",String.valueOf( this.OrderNo));
		
		return jsObj;
	}
}
