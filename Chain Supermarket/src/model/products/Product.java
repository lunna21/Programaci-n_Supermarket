package model.products;

import java.util.ArrayList;

import model.Supplier;

public class Product {
	private int id;
	private String name;
	private double price;
	private int stock;
	Supplier suplier=new Supplier();
	Category category =new Category();
	private ArrayList<Category> listCategory= new ArrayList<Category>();
	

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

	public ArrayList<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(ArrayList<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, double price, int stock,Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	
	public int findCategory(int id) {
		int position = -1;
		for (Category category : listCategory) {
			if (id == category.getId()) {
				position = listCategory.indexOf(category);
			}
		}
		return position;
	}
	public void addCategory(Category c) {
		listCategory.add(c);
	}
	public Category category(int position) {
		return listCategory.get(position);
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", suplier=" + suplier.getName()
				+ ", category=" + category + ", listCategory=" + listCategory.get(getId()) + "]";
	}


}
