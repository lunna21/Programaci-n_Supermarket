package controller;

import java.util.ArrayList;

import exceptions.DuplicateException;
import exceptions.ValueNotFoundException;
import model.Client;
import model.Person;
import model.Sale;
import model.Supplier;
import model.products.Category;
import model.products.Product;
import view.IoManager;

public class Control {
	private IoManager io;
	Person person = new Person();

	public Control() {
		io = new IoManager();
	}

	public void init() {
		int opcion = 0;
		// this.readEmployeeList();
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
					this.saleRecord(io.readGraphicInt("Ingrese el id del producto a vender"));
					break;
				case 5:
					// this.showEmployee();
					break;
				case 6:
					// this.showAllEmployees();
					break;
				case 7:
					// this.liquidar();
					break;
				case 8:
					// this.readEmployeeListNews();
					// io.showGraphicMessage(""+business.sizeArrayList());
					// io.showGraphicMessage(""+business.findEmployee(18));
					// io.showGraphicMessage(business.arrayListToArray());
					//
					break;
				case 9:
					// io.showGraphicArrayStringInLine(business.mySplit(',', "10,Hugo,25000"));
					// business.ordenamientoBurbuja();
					// io.showGraphicMessage(business.showAllEmployee());
					// this.addEmployee();
					// business.ordenamientoBurbuja();
					// io.showGraphicMessage(business.showAllEmployee());
					break;
				default:
					io.showGraphicMessage("¡Ha seleccionado una Opcion Invalida!");

					break;
				}
			} catch (NumberFormatException e) {
				io.showGraphicErrorMessage("Debe ingresar un numero entero");
			}
		} while (opcion != 6);
		io.showGraphicMessage("Hasta Luego");

	}


	private void addSupllier() {
		short rut = io.readGraphicShort("Digite el Rut");
		if (person.findSupplier(rut) == -1) {
			Supplier s = new Supplier();
			s = new Supplier(rut, io.readGraphicString("Digite un nombre"), io.readGraphicString("Digite un número"),
					io.readGraphicString("Digite su página web"));
			person.addSupplier(s);
			io.showGraphicMessage("Supplier generated");
		} else {
			Exception e = new DuplicateException("Ya existe este empleado");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private void addClient() {
		short rut = io.readGraphicShort("Digite el Rut");
		if (person.findClient(rut) == -1) {
			Client c = new Client();
			c = new Client(rut, io.readGraphicString("Digite un nombre"),this.whichNumbers());
			person.addClient(c);
			io.showGraphicMessage("Client generated");
		} else {
			Exception e = new DuplicateException("Ya existe este empleado");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private ArrayList<String> whichNumbers(){
		int wichNumbers=io.readGraphicInt("Digite cuantos números desea agregar");
		int cont=0;
		ArrayList<String> listNumbers = new ArrayList<String>();
		Client c= new Client();
		while (cont!=wichNumbers) {
			listNumbers.add(io.readGraphicString("Digite el número "));
			cont++;
		}
		return listNumbers;
	}
	private void addProduct() {
		int id = io.readGraphicInt("Digite el ID");
		Supplier s = new Supplier(); 
		if (s.findProduct(id) == -1) {
			Product p = new Product();
			p = new Product(id, io.readGraphicString("Digite el nombre del producto"),
					io.readGraphicDouble("Digite el precio"), 
					io.readGraphicInt("Digite el stock"),this.showSupplier(io.readGraphicShort("Digite el número de Rut del proveedor")),
					this.showCategory(io.readGraphicInt("Digite el número de ID de la categoría")));		 
			s.addProduct(p);
			io.showGraphicMessage("Product generated");
		} else {
			Exception e = new DuplicateException("Ya existe este producto");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private Category showCategory(int id) {
		Supplier s =new Supplier();
		if (s.findCategory(id)!=-1) {
			s.category(s.findCategory(id));
		}else {
			Exception e=new ValueNotFoundException("No existe este provedor");
			io.showGraphicErrorMessage(e.getMessage());
		}
		return s.category(s.findCategory(id));
	}

	private Supplier showSupplier(short rut) {
		if (person.findSupplier(rut)!=-1) {
			person.supplier(person.findSupplier(rut));
		}else {
			Exception e=new ValueNotFoundException("No existe este empleado");
			io.showGraphicErrorMessage(e.getMessage());
		}
		return person.supplier(person.findSupplier(rut));
	}
	

	private ArrayList<Product> listProducts= new ArrayList<Product>();
	int countId;
	public void saleRecord(int id) {
		Product p = new Product();
		Sale s = new Sale();
		int unidadesV;
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getId() == id) {
				unidadesV = io.readGraphicInt("Digite el numero de unidades que vendio");
				if (unidadesV > p.getStock()) {
					throw new RuntimeException("No hay suficiente stock del producto para realizar la venta.");
				} else {
					p.setStock(p.getStock() - unidadesV);
					countId++;
					s.setId(countId);
				} 
			} else {
				throw new RuntimeException("el id no fue encontrado.");
			}

		}


	}

}
