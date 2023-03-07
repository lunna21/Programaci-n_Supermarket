package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import exceptions.DuplicateException;
import exceptions.ValueNotFoundException;
import model.Address;
import model.Client;
import model.Sale;
import model.Sql;
import model.Supplier;
import model.products.Category;
import model.products.Product;
import persistence.MyFile;
import view.IoManager;

public class Control {
	IoManager io;
	Sql sql =new Sql() ;
	Supplier supplier=new Supplier() ;
	Product product=new Product();
	Category category=new Category();
	MyFile f =new MyFile("src/persistence/listcategorydat.txt");
	MyFile j =new MyFile("src/persistence/categories.txt");
	MyFile k =new MyFile("src/persistence/bills.txt");

	public Control() {
		io = new IoManager();
	}

	public void init() {
		int opcion = 0;	
		do {
			try {
				opcion=io.readMenu();
				switch (opcion) {
				case 1:
					this.addSupllier();
					break;
				case 2:
					this.addClient();
					break;
				case 3:
					this.readCategoryList();
					this.writeCategory(j);
					break;
				case 4:
					this.addProduct();
					break;
				case 5:
					this.saleRecord(io.readGraphicInt("Ingrese el id del producto a vender"));
					break;
				case 6:
					this.showAllSale();
					break;
				case 7:
					break;
				default:
					io.showGraphicMessage("You have selected an invalid option!");

					break;
				}
			} catch (NumberFormatException e) {
				io.showGraphicErrorMessage("You must enter an integer");
				io.showGraphicErrorMessage(e.getMessage());
			}
		} while (opcion != 7);
		io.showGraphicMessage("See you later");

	}


	private void showAllSale() {
		MyFile j =new MyFile("src\\persistence\\items.txt");
		this.readbills();
		this.writeItems(j);
		io.showGraphicMessage(sql.getListSales()+"\n");
	}
	public void readbills() {
		k.openFile('r');
		String cad;
		while ((cad=f.readRecord())!=null){
			String []dataS = cad.split(",");
			Sale s =new Sale(
					Integer.parseInt(dataS[1]),
					dataS[2],
					dataS[3],
					Double.parseDouble(dataS[4]),
					Double.parseDouble(dataS[5])
					);
			if (sql.findSale( s.getId())==-1) {
				sql.addSale(s);
				io.showGraphicMessage("Venta generada");
			}else {
				Exception em=new DuplicateException("Ya existe este empleado");
				io.showGraphicErrorMessage(em.getMessage());
			}	
		}}

	private void writeItems(MyFile f) {
		try {
			f.openFile('w');
			String cad="\"--------------------------------------------------LIST OF ITEMS--------------------------------------------------\"+\r\n"
					   +"\n"+sql.getListSales().toString();
			f.addRecord(cad);
			f.closeFile();
		}catch (Exception e) {
			Exception em=new Exception("Ha ocurrido un error");
			io.showGraphicErrorMessage(em.getMessage());
		}	}

	private void addSupllier() {
		try {
			MyFile j =new MyFile("src\\persistence\\supplier.txt");
			short rut = io.readGraphicShort("Digite el Rut del Proveedor");
			if (sql.findSupplier(rut) == -1) {
				Supplier s = new Supplier(rut, io.readGraphicString("Digite un nombre"), io.readGraphicString("Digite un número"),
						io.readGraphicString("Digite su página web"));
				sql.addSupplier(s);
				io.showGraphicMessage("Supplier generated");
				io.showGraphicMessage(s.toString());
				this.writeSupplier(j);
			} else {
				Exception e = new DuplicateException("Ya existe este proveedor");
				io.showGraphicErrorMessage(e.getMessage());
			}
		}catch (Exception em) {
			Exception e = new ValueNotFoundException("Ya existe este proveedor");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}

	private void addClient() {
		MyFile j =new MyFile("src\\persistence\\clients.txt");
		Address a=new Address();
		short rut = io.readGraphicShort("Digite el Rut");
		if (sql.findClient(rut) == -1) {
			Client c = new Client();
			c = new Client(rut, io.readGraphicString("Digite un nombre"),this.whichNumbers(),
					a=new Address(io.readGraphicString("Digite la ciudad"),
							io.readGraphicString("Digite el barrio"),
							io.readGraphicString("Digite el tipo de vía (Calle,Carrera,Avenida,Transversal"),
							io.readGraphicString("Digite el Nombre o número del tipo de vía"),
							io.readGraphicString("Digite el prefijo o el cuadrante del tipo de vía"),
							io.readGraphicInt("Digite el número de la vía generadora"),
							io.readGraphicInt("Digite el número de placa")));
			sql.addClient(c);
			io.showGraphicMessage("Client generated");
			io.showGraphicMessage(c.toString());
			this.writeClient(j);
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
		MyFile f =new MyFile("src\\persistence\\suppliers.txt");
		MyFile j =new MyFile("src\\persistence\\products.txt");
		short rut = io.readGraphicShort("Digite el Rut del proveedor");
		if (sql.findSupplier(rut)!=-1) {
			int id=io.readGraphicInt("Digite el ID del producto");
			if (sql.getListSuplliers().get(sql.findSupplier(rut)).findProduct(id)==-1) {
				product = new Product(id, 
						io.readGraphicString("Digite el nombre del producto"),
						io.readGraphicDouble("Digite el precio"),
						io.readGraphicInt("Digite el stock"));
				sql.getListSuplliers().get(sql.findSupplier(rut)).addProduct(product);
				this.writeProduct(j);
				io.showGraphicMessage("Product generated");
				this.insertCategory(id,rut);
				io.showGraphicMessage(""+product);
				this.writeSupplier(f);
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
		MyFile f =new MyFile("src\\persistence\\categories.txt");
		Supplier s=sql.getListSuplliers().get(sql.findSupplier(rut));
		product=s.getListProducts().get(s.findProduct(id));
		int idC=io.readGraphicInt("Digite el ID de la Categoría a la que quiere vincular su producto");
		if (sql.findCategory(idC)==-1) {
			category=new Category(idC,
					io.readGraphicString("Nombre"),
					io.readGraphicString("Descripcion"));
			sql.addCategory(category);
			sql.category(sql.findCategory(idC)).addProduct(product);;
			this.writeCategory(f);
		} else {
			sql.category(sql.findCategory(idC)).addProduct(product);
		}
	}

	private void writeCategory(MyFile f) {
		try {
			j.openFile('w');
			String cad=sql.showCategories();
			j.addRecord(cad);
			j.closeFile();
		}catch (Exception e) {
			Exception em=new Exception("Ha ocurrido un error");
			io.showGraphicErrorMessage(em.getMessage());
		}	
	}

	public void saleRecord(int id) {
		try {
			MyFile f =new MyFile("src\\persistence\\bills.txt");
			int positionS = sql.findSupplier(io.readGraphicShort("Digite el numero de Rut del proveedor."));
			int positionC = sql.findClient(io.readGraphicShort("Digite el numero del Rut del Cliente"));
			int positionP;

			if (positionS == -1) {
				throw new RuntimeException("El provedor no existe");
			} else if (positionC == -1) {
				throw new RuntimeException("El cliente no existe");
			}

			Supplier su = sql.supplier(positionS);
			Client c = sql.client(positionC);
			positionP = su.findProduct(id);

			if (positionP == -1) {
				throw new RuntimeException("El producto no existe");
			}

			Product p = su.product(positionP);
			Sale s;
			int uniSold = io.readGraphicInt("Digite el numero de unidades que vendio");

			if (uniSold > p.getStock()) {
				throw new RuntimeException("No hay suficiente stock del producto para realizar la venta.");
			} else {
				p.setStock(p.getStock() - uniSold);
				double discount = io.readGraphicDouble("Ingrese el descuento porcentual (1-100): ");
				double totalMount = (double) p.getPrice() * uniSold * (discount / 100);
				s = new Sale(sql.getListSales().size(), this.getDate(), c, discount, totalMount);
				sql.addSale(s);
				io.showGraphicMessage((s.toString()));
				this.writeBills(f);
			}

		} catch (Exception e) {
			io.showGraphicErrorMessage(e.getMessage());
		}

	}
	private void writeBills(MyFile f) {
		try {
			f.openFile('w');
			String cad="\"--------------------------------------------------LIST OF BILLS--------------------------------------------------\"+\r\n"
					   +"\n"+sql.getListSales().toString();
			f.addRecord(cad);
			f.closeFile();
		}catch (Exception e) {
			Exception em=new Exception("Ha ocurrido un error");
			io.showGraphicErrorMessage(em.getMessage());
		}	}

	public String getDate() {
		String format = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(format);
		LocalDateTime date = LocalDateTime.now();
		return formateador.format(date);
	}
	public void writeSupplier(MyFile j) {
		try {
			j.openFile('w');
			String cad=sql.showSuppliers();
			j.addRecord(cad);
			j.closeFile();
		}catch (Exception e) {
			Exception em=new Exception("Ha ocurrido un error");
			io.showGraphicErrorMessage(em.getMessage());
		}
	}
	public void writeClient(MyFile j) {
		try {
			j.openFile('w');
			String cad=sql.showClients();
			j.addRecord(cad);
			j.closeFile();
		}catch (Exception em) {
			em=new Exception("Ha ocurrido un error");
			io.showGraphicErrorMessage(em.getMessage());
		}
	}
	public void writeProduct(MyFile j) {
		try {
			j.openFile('w');
			String cad="\"--------------------------------------------------LIST OF PRODUCTS--------------------------------------------------\"+\r\n"
					   +"\n"+product.toString();
			j.addRecord(cad);
			j.closeFile();
		}catch (Exception e) {
			Exception em=new Exception("Ha ocurrido un error");
			io.showGraphicErrorMessage(em.getMessage());
		}
	}
	public void readCategoryList() {
		try {
			f.openFile('r');
			String cad;
			while ((cad=f.readRecord())!=null){
				String []dataCa = cad.split(",");
				Category c =new Category(
						Integer.parseInt(dataCa[0]),
						dataCa[1],
						dataCa[2]);
				if (sql.findCategory(c.getId())==-1) {
					sql.addCategory(c);
					int count=0;
					while(Integer.parseInt(dataCa[3])!=count) {
						sql.getListCategory().get(sql.findCategory(c.getId())).getListProducts().add(this.splitProduct(dataCa[5+count]));
						sql.getListSuplliers().get(sql.findSupplier(Short.parseShort(dataCa[4]))).addProduct(this.splitProduct(dataCa[5+count]));;
						count++;
					}
					io.showGraphicMessage("Categoría generada");
					io.showGraphicMessage(""+sql.getListCategory().get(sql.findCategory(c.getId())));
				}else {
					Exception em=new DuplicateException("Ya existe esta categoría");
					io.showGraphicErrorMessage(em.getMessage());
				}	
			}
		} catch (Exception e) {
			e=new Exception("Ha ocurrido un error no existe un productor");
			io.showGraphicErrorMessage(e.getMessage());
		}
	}
	public Product splitProduct(String cad) {
		String []product = cad.split("/");
		Product p=new Product(Integer.parseInt(product[0]),
				product[1],
				Double.parseDouble(product[2]),
				Integer.parseInt(product[3]));
		return p;
	}


}
