package model;

import java.util.ArrayList;

import model.Person;
import model.products.Product;

public class Client extends Person {
	private ArrayList<String> listNumbers = new ArrayList<String>();
	
	public Client() {
	}
	public Client(short rut, String name,ArrayList<String> listNumbers) {
		super(rut, name);
		this.listNumbers=listNumbers;
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
	@Override
	public String toString() {
		return "Supplier [Name= "+getName()+", Rut= " + getRut()+", List Numbers= " + listNumbers+"]";
	}
}
