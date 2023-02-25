package model;

import java.util.ArrayList;

import model.Person;

public class Client extends Person {
	private ArrayList<String> listNumbers = new ArrayList<String>();
	

	public ArrayList<String> getListNumbers() {
		return listNumbers;
	}

	public void setListNumbers(ArrayList<String> listNumbers) {
		this.listNumbers = listNumbers;
	}

	public Client(short rut, String name,ArrayList<String> listNumbers) {
		super(rut, name);
		this.listNumbers=listNumbers;
	}
	public Client (ArrayList<String> listNumbers) {
		
	}

	public Client() {
	}

}
