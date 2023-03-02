package model;

import java.util.ArrayList;
import java.util.Iterator;

import model.products.Category;

public class Person {
	private short rut;
	private String name;
	
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

	
	
}
