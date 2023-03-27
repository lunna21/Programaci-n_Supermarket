package model;

import java.util.ArrayList;
import model.products.Product;

public class Supplier extends Person {
	private String number;
	private String webPage;
	private ArrayList<Product> listProducts = new ArrayList<Product>();

	public Supplier() {
	}

	public Supplier(short rut, String name, String number, String webPage) {
		super(rut, name);
		this.number = number;
		this.webPage = webPage;
	}

	public Supplier(short rut, String name, String number, String webPage, ArrayList<Product> listProducts) {
		super(rut, name);
		this.webPage = webPage;
		this.number = number;
		this.listProducts = listProducts;
		// TODO Auto-generated constructor stub
	}

	public String getWebpage() {
		return webPage;
	}

	public void setWebpage(String webpage) {
		this.webPage = webpage;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public void addProduct(Product p) {
		listProducts.add(p);
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

	public Product product(int position) {
		return listProducts.get(position);
	}

	@Override
	public String toString() {
		return "Supplier [" + super.toString() + ", Number=" + number + ", WebPage=" + webPage + "\t\n"
				+ getListProducts() + "]";
	}
}
