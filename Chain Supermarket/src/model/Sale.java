package model;

public class Sale {
	private int id;
	private String date;
	private Client client;
	private double discount;
	private double finalAmount;
	
	public Sale() {
		
	}
	
	public Sale(int id, String date, Client client, double discount, double finalAmount) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		this.discount = discount;
		this.finalAmount = finalAmount;
	}
	public Sale(int id, String date, String name, double discount, double finalAmount) {
		super();
		this.id = id;
		this.date = date;
		name = name;
		this.discount = discount;
		this.finalAmount = finalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String fecha) {
		this.date = fecha;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	@Override
	public String toString() {
		return  id +","+ date +","+ client.getName()+"," + discount
				+ "," + finalAmount;
	}
}
