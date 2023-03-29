package model.products;

import java.util.ArrayList;


public class Category {
	private int id;
	private String name;
	private String description;
	private ArrayList<Product> listProducts= new ArrayList<Product>();
	
	public Category() {
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
	@Override
	public String toString() {
		return "Category [Id=" + id + ", Name=" + name + ", Description=" + description + "]\n" +"ListProducts"
				+"\n"+ getListProducts().toString()+ "\n";
	}

	public String showProduct() {
		return "Category [Id=" + id + 
				"ListProducts"+"\t\n"+ getListProducts();
	}

}
