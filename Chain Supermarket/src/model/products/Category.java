package model.products;

import java.util.ArrayList;

public class Category {
	private int id;
	private String name;
	private String description;
	private ArrayList<Product> listProducts= new ArrayList<Product>();
	
	public ArrayList<Product> getListProducts() {
		return listProducts;
	}
	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}
	public Category(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public void addProduct(Product p) {
		listProducts.add(p);
	}
	public Product product(int position) {
		return listProducts.get(position);
	}

	public Category() {

	}

}
