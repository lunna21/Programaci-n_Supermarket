package model.products;

import java.util.ArrayList;

import model.Sql;
import model.Supplier;

public class Product {
	private int id;
	private String name;
	private double price;
	private int stock;
	Supplier suplier=new Supplier();
	Category category =new Category();


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Supplier getSuplier() {
		return suplier;
	}
	public void setSuplier(Supplier suplier) {
		this.suplier = suplier;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, double price, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", suplier=" +suplier
				+ ", category=" + category + "]";
	}




}
