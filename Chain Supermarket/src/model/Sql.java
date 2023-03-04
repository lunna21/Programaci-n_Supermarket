package model;

import java.util.ArrayList;
import java.util.Iterator;
import model.products.Category;


public class Sql {
	private Category category;
	private ArrayList<Supplier> listSuplliers = new ArrayList<Supplier>();
	private ArrayList<Client> listClients = new ArrayList<Client>();
	private ArrayList<Category>listCategory = new ArrayList<Category>();
    private ArrayList<Sale> listSales = new ArrayList<Sale>();

	public ArrayList<Supplier> getListSuplliers() {
		return listSuplliers;
	}
	public void setListSuplliers(ArrayList<Supplier> listSuplliers) {
		this.listSuplliers = listSuplliers;
	}
	public ArrayList<Client> getListClients() {
		return listClients;
	}
	public void setListClients(ArrayList<Client> listClients) {
		this.listClients = listClients;
	}
	public ArrayList<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(ArrayList<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public ArrayList<Sale> getListSales() {
		return listSales;
	}
	public void setListSales(ArrayList<Sale> listSales) {
		this.listSales = listSales;
	}
	public void addSupplier(Supplier supplier) {
		listSuplliers.add(supplier);
	}
	public void addClient(Client client) {
		listClients.add(client);
	}
	public void addCategory(Category category) {
		listCategory.add(category);
	}
    public void addSale(Sale sale) {
        listSales.add(sale);
    }
	public Category category() {
		int position=this.findCategory(category.getId());
		return listCategory.get(position);
	}
	public int findSupplier(short rut) {
		int position = -1;
		for (Supplier supllier : listSuplliers) {
			if (rut == supllier.getRut()) {
				position = listSuplliers.indexOf(supllier);
			}
		}
		return position;
	}
	public int findClient(short rut) {
		int position = -1;
		for (Client client : listClients) {
			if (rut == client.getRut()) {
				position = listClients.indexOf(client);
			}
		}
		return position;
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
//REVISAR CAMBIAR CLIENT
	public int findSale(int id) {
		int position = -1;
		for (Sale sale : listSales) {
			if (id == sale.getId()) {
				position = listClients.indexOf(sale);
			}
		}
		return position;
	}
    public Supplier supplier(int position) {
        return listSuplliers.get(position);
    }

    public Client client(int position) {
        return listClients.get(position);
    }
    public Category category(int position) {
        return listCategory.get(position);
    }
    public String showClients() {
		String salida="--------------------------------------------------LIST OF CLIENTS--------------------------------------------------"+
					  "\n";
		Iterator it = listClients.iterator(); 
		while(it.hasNext()){
			salida+=(it.next());
		}
		return salida;
	}
    public String showSuppliers() {
		String salida="--------------------------------------------------LIST OF SUPPLIERS--------------------------------------------------"+
					  "\n";
		Iterator it = listSuplliers.iterator(); 
		while(it.hasNext()){
			salida+=(it.next());
		}
		return salida;
	}
    
    
    //Agregando historial
    
    public String toString(){
    String info = "";
        for (Sale sale : listSales) {
            info += "Id: " + sale.getId() + " Date: " + sale.getDate() + " Cliente: " + sale.getClient() + " descuento: " + sale.getDiscount() + " monto final: " + sale.getFinalAmount() + " \n";
        }
        
        return info;
    }

}
