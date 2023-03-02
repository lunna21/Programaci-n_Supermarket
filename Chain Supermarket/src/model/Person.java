package model;

import java.util.ArrayList;
import java.util.Iterator;

import model.products.Category;

public class Person {
	private short rut;
	private String name;
	private ArrayList<Supplier> listSuplliers = new ArrayList<Supplier>();
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
	private ArrayList<Client> listClients = new ArrayList<Client>();

	public Person() {

	}

	public Person(short rut, String name) {
		super();
		this.rut = rut;
		this.name = name;
	}

	public short getRut() {
		return rut;
	}

	public void setRut(short rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSupplier(Supplier supplier) {
		listSuplliers.add(supplier);
	}

	public void addClient(Client client) {
		listClients.add(client);
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
	public Supplier supplier(short position) {
		return listSuplliers.get(position);
	}
	public Supplier supplier(int position) {
		return listSuplliers.get(position);
	}
	public String showSuppliers(short id) {
		int posicion=this.findSupplier(id);
		return ""+listSuplliers.get(posicion);
	}
	public String showAllSuppliers() {
		String salida="__________________________________________"+"\n";
		Iterator it = listSuplliers.iterator(); 
		while(it.hasNext()){
			salida+=(it.next())+"\n";
		}
		return salida;
	}
	public String showClients(short id) {
		int posicion=this.findClient(id);
		return ""+listClients.get(posicion);
	}
	public String showAllClients() {
		String salida="__________________________________________"+"\n";
		Iterator it = listSuplliers.iterator(); 
		while(it.hasNext()){
			salida+=(it.next())+"\n";
		}
		return salida;
	}

	
}
