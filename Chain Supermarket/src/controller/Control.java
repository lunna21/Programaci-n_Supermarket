package controller;

import java.util.ArrayList;

import exceptions.DuplicateException;
import exceptions.ValueNotFoundException;
import model.Client;
import model.Sql;
import model.Supplier;
import model.products.Category;
import model.products.Product;
import view.IoManager;

public class Control {
	IoManager io;
	Sql sql =new Sql() ;
	Supplier supplier=new Supplier() ;
	Product product=new Product();
	Category category=new Category();
	

	public Control() {
		io = new IoManager();
	}

	public void init() {
		int opcion = 0;
		ArrayList<String> listNumbers = new ArrayList<String>();
		listNumbers.add("3137065045");
		listNumbers.add("313245679");
		Client c=new Client((short) 1,"Karina",listNumbers);
		sql.addClient(c);
		category=new Category(1,"Alimentos","alimentos saludables");
		sql.addCategory(category);
		ArrayList<Product> listProducts = new ArrayList<Product>();
		product=new Product(1,"Papas",200,20);
		listProducts.add(product);
		Supplier s=new Supplier((short) 1,"Lunna","3137065045","lunna.com",listProducts);
		sql.addSupplier(s);
		do {
			try {
				opcion = io.readMenu();
				switch (opcion) {
				case 1:
					this.addSupllier();
					break;
				case 2:
					this.addClient();
					
					break;
				case 3:
					this.addProduct();
					break;
				case 4:
//					this.saleRecord(io.readGraphicInt("Ingrese el id del producto a vender"));
					break;
				case 5:
//Ver las ventas totales
					break;
				case 6:
					break;
					
				default:
					io.showGraphicMessage("You have selected an invalid option!");

					break;
				}
			} catch (NumberFormatException e) {
				io.showGraphicErrorMessage("You must enter an intege");
				io.showGraphicErrorMessage(e.getMessage());
			}
		} while (opcion != 6);
		io.showGraphicMessage("See you later");

	}


	private void addSupllier() {
		short rut = io.readGraphicShort("Digite el Rut del Proveedor");
		if (sql.findSupplier(rut) == -1) {
			Supplier s = new Supplier(rut, io.readGraphicString("Digite un nombre"), io.readGraphicString("Digite un número"),
					io.readGraphicString("Digite su página web"));
			sql.addSupplier(s);
			io.showGraphicMessage("Supplier generated");
			io.showGraphicMessage(s.toString());
		} else {
			Exception e = new DuplicateException("Ya existe este proveedor");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private void addClient() {
		short rut = io.readGraphicShort("Digite el Rut");
		if (sql.findClient(rut) == -1) {
			Client c = new Client();
			c = new Client(rut, io.readGraphicString("Digite un nombre"),this.whichNumbers());
			sql.addClient(c);
			io.showGraphicMessage("Client generated");
			io.showGraphicMessage(c.toString());
		} else {
			Exception e = new DuplicateException("Ya existe este cliente");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private ArrayList<String> whichNumbers(){
		int wichNumbers=io.readGraphicInt("Digite cuantos números desea agregar");
		int cont=0;
		ArrayList<String> listNumbers = new ArrayList<String>();
		//		Client c= new Client();
		while (cont!=wichNumbers) {
			listNumbers.add(io.readGraphicString("Digite el número "));
			cont++;
		}
		return listNumbers;
	}
	private void addProduct() {
		short rut = io.readGraphicShort("Digite el Rut del proveedor");
		if (sql.findSupplier(rut)!=-1) {
			int id=io.readGraphicInt("Digite el ID del producto");
			if (sql.getListSuplliers().get(sql.findSupplier(rut)).findProduct(id)==-1) {
				product = new Product(id, 
						 			   io.readGraphicString("Digite el nombre del producto"),
						 			   io.readGraphicDouble("Digite el precio"),
						               io.readGraphicInt("Digite el stock"));
				sql.getListSuplliers().get(sql.findSupplier(rut)).addProduct(product);
				io.showGraphicMessage("Product generated");
				this.insertCategory(id,rut);
				io.showGraphicMessage(product.toString());
			} else {
				Exception e = new DuplicateException("Ya existe este producto");
				io.showGraphicErrorMessage(e.getMessage());
			}
		} else {
			Exception e = new ValueNotFoundException("No existe este proveedor por tanto no puedo crear el producto");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private void insertCategory(int id,short rut) {
		Supplier s=sql.getListSuplliers().get(sql.findSupplier(rut));
		product=s.getListProducts().get(s.findProduct(id));
		if (product.getId()!=-1) {
			int idC=io.readGraphicInt("Digite el ID de la Categoría");
			if (sql.findCategory(idC)==-1) {
				category=new Category(idC,
										io.readGraphicString("Nombre"),
										io.readGraphicString("Descripcion"));
				sql.addCategory(category);
				sql.getListCategory().get(sql.findCategory(idC)).addProduct(product);
			} else {
				sql.getListCategory().get(sql.findCategory(idC)).addProduct(product);
			}
		}else {
			Exception e = new ValueNotFoundException("No  existe este producto");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

}
