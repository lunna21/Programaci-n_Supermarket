package model;

import java.util.ArrayList;

public class Person {
	private short rut;
	private String name;
	private ArrayList<Supplier> listSuplliers = new ArrayList<Supplier>();
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
	
	public Supplier supplier(int position) {
		return listSuplliers.get(position);
	}

	
}
