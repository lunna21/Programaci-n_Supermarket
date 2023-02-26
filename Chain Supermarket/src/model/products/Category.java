package model.products;

import java.util.ArrayList;

public class Category {
	
	private int id;
	private String name;
	private String description;
	private ArrayList<Product> listProducts= new ArrayList<Product>();
	
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
	public ArrayList<Product> getListaEmpleados() {
		return listProducts;
	}
	public void setListaEmpleados(ArrayList<Product> listaEmpleados) {
		this.listProducts = listaEmpleados;
	}
	
}
