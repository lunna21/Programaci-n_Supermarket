package model;

import java.util.ArrayList;

import model.products.Product;
import model.products.Category;

public class Supplier extends Person {

	private String webPage;
	private ArrayList<Product> listProducts= new ArrayList<Product>();
	private ArrayList<Category> listCategorys= new ArrayList<Category>();

	
	
	public ArrayList<Product> getListProducts() {
		return listProducts;
	}
	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}
	public String getWebpage() {
		return webPage;
	}
	public void setWebpage(String webpage) {
		this.webPage = webpage;
	}
	public Supplier(short rut, String name, String number, String webPage) {
		super(rut, name);
		this.webPage=webPage;
		// TODO Auto-generated constructor stub
	}
	public Supplier() {
		// TODO Auto-generated constructor stub
	}
	public int findProduct(int id) {
		int position = -1;
		for (Product product : listProducts) {
			if (id == product.getId()) {
				position = listProducts.indexOf(product);
			}
		}
		return position;
	}
	public int findCategory(int id) {
		int position = -1;
		for (Category category : listCategorys) {
			if (id == category.getId()) {
				position = listProducts.indexOf(category);
			}
		}
		return position;
	}
	public void addProduct(Product p) {
		listProducts.add(p);
		
	}

	public Category category(int position) {
		return listCategorys.get(position);
	}
	

}
