package model;

import java.util.ArrayList;

public class Client extends Person {
	private Address adress;
	private ArrayList<String> listNumbers = new ArrayList<String>();
	
	public Client() {
	}
	public Client(String name) {
		name=getName();
	}
	public Client(short rut, String name,ArrayList<String> listNumbers) {
		super(rut, name);
		this.listNumbers=listNumbers;
	}
	public Client(short rut, String name,ArrayList<String> listNumbers, Address adress) {
		super(rut, name);
		this.listNumbers=listNumbers;
		this.adress=adress;
	}
	public Client (ArrayList<String> listNumbers) {
	}
	public ArrayList<String> getListNumbers() {
		return listNumbers;
	}
	public void setListNumbers(ArrayList<String> listNumbers) {
		this.listNumbers = listNumbers;
	}
	public void addNumbers(String numbers) {
		listNumbers.add(numbers);
	}

	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Client" + " "+super.toString() + ", ListNumbers=" + listNumbers + ",  "+ adress.toString();
	}
	
}

