package model;

public class Sale {
	private int id;
	private String fecha;
	private Client client;
	private double discount;
	private double finalAmount;
	
	public Sale() {
		
	}
	
	public Sale(int id, String fecha, Client client, double discount, double finalAmount) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.client = client;
		this.discount = discount;
		this.finalAmount = finalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
		return "Sale [id=" + id + ", fecha=" + fecha + ", client=" + client + ", discount=" + discount
				+ ", finalAmount=" + finalAmount + "]";
	}

	
	
}
