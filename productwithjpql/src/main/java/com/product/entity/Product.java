package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "product.Name_Quantity",query = "select pname,quantity from Product")
@NamedQuery(name = "product.getPrice",query = "select price from Product where pid=:id")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	private int quantity;
	private int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, int quantity, int price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}

	public Product(String pname, int quantity, int price) {
		super();
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
