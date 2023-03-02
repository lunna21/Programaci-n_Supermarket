package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import exceptions.DuplicateException;
import exceptions.ValueNotFoundException;
import model.Client;
import model.Person;
import model.Sale;
import model.Sql;
import model.Supplier;
import model.products.Category;
import model.products.Product;
import view.IoManager;

public class Control {
	private IoManager io;
	private Person person = new Person();
	private Sql sql =new Sql() ;
	private Supplier supplier=new Supplier() ;
	private Product product=new Product();
	

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
		ArrayList<Category> listCategory = new ArrayList<Category>();
		Category ca=new Category(1,"Alimentos","alimentos saludables");
		listCategory.add(ca);
		ArrayList<Product> listProducts = new ArrayList<Product>();
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
					this.createCategory(io.readGraphicInt("Digite el ID del Producto"));
					break;
				case 4:
//					this.saleRecord(io.readGraphicInt("Ingrese el id del producto a vender"));
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
		short rut = io.readGraphicShort("Digite el Rut del Proveedor");
		if (sql.findSupplier(rut) == -1) {
			Supplier s = new Supplier(rut, io.readGraphicString("Digite un nombre"), io.readGraphicString("Digite un número"),
					io.readGraphicString("Digite su página web"));
			sql.addSupplier(s);
			io.showGraphicMessage("Supplier generated");
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
		} else {
			Exception e = new DuplicateException("Ya existe este empleado");
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
			 product = new Product(id, io.readGraphicString("Digite el nombre del producto"),
					 					 io.readGraphicDouble("Digite el precio"),
					                     io.readGraphicInt("Digite el stock"));
			sql.getListSuplliers().get(sql.findSupplier(rut)).addProduct(product);
			System.out.println(sql.getListSuplliers()); 
			io.showGraphicMessage("Product generated");
		} else {
			Exception e = new DuplicateException("No existe este proveedor por tanto no puedo crear el producto");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private void createCategory(int idP) {
		if (supplier.findProduct(idP)==-1) {
			int id=io.readGraphicInt("Digite el ID de la Categoría");
			if (sql.findCategory(id)==-1) {
				Category c=new Category(io.readGraphicInt("Digite el ID de la Categoría"),io.readGraphicString("Nombre"),io.readGraphicString("Descripcion"));
				sql.addCategory(c);
				c.addProduct(supplier.getListProducts().get(supplier.findProduct(idP)));
			} else {
				sql.getListCategory().get(sql.findCategory(id)).addProduct(supplier.getListProducts().get(supplier.findProduct(idP)));;
			}
		}else {
			Exception e = new DuplicateException("No existe este producto");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private Client showClient(short rut) {
		int positionClient = sql.findClient(rut);
		if (positionClient != -1) {
			sql.getListClients().get(positionClient);
		} else {
			Exception e = new ValueNotFoundException("No existe este cliente");
			io.showGraphicErrorMessage(e.getMessage());
		}
		return sql.getListClients().get(positionClient);
	}

	
//	private Supplier showSupplier(short rut) {
//		if (sql.findSupplier(rut)==-1) {
//			.supplier(sql.findSupplier(rut));
//		}else {
//			Exception e=new ValueNotFoundException("No existe este proveedor");
//			io.showGraphicErrorMessage(e.getMessage());
//		}
//		return sql.supplier(sql.findSupplier(rut));
//	}
//
//	public void saleRecord(int id) {
//		Supplier su = this.showSupplier(io.readGraphicShort("Digite el nÃºmero de Rut del proveedor"));
//		Client c = this.showClient(io.readGraphicShort("Digite el nÃºmero de Rut del Cliente"));
//		Product p = this.showProduct(su, id);
//
//		Sale s;
//		int uniSold = io.readGraphicInt("Digite el numero de unidades que vendio");
//
//		if (uniSold > p.getStock()) {
//			throw new RuntimeException("No hay suficiente stock del producto para realizar la venta.");
//		} else {
//			p.setStock(p.getStock() - uniSold);
//			double discount = io.readGraphicDouble("Ingrese el descuento porcentual (1-100): ");
//			double totalMount = (double) p.getPrice() * uniSold * (discount/100);
//			if(su != null && c != null && p != null) {
//				s = new Sale(sales.size(), this.getDate(), c, discount, totalMount);
//				this.sales.add(s);
//				io.showGraphicMessage((s.toString()));
//			} else {
//				io.showGraphicMessage("Algo salio mal.");
//			}
//		}
//
//
//	}
//
//
//	public String getDate(){
//        String format = "yyyy-MM-dd HH:mm:ss";
//        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(format);
//        LocalDateTime date = LocalDateTime.now();
//        return formateador.format(date);
//        
//        //Para llamar en el control
//        //String fechayHora = fecha();
//        //syso: fecha y hora + fechayhora
//        }
}
