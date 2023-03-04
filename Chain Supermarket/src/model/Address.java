package model;

public class Address {
	private String city; // Ciudad
	private String neighborhood; // Barrio
	private String type; // Tipo de vía (calle, carrera, avenida, transversal)
	private String nameOrNumberofType; // Nombre o número
	private String prefixOrQuadrant; // Prefijo o cuadrante
	private int generatingWayNumber; // Número de vía generadora
	private int plateNumber; // Número de placa
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String city, String neighborhood, String type, String nameOrNumberofType, String prefixOrQuadrant,
			int generatingWayNumber, int plateNumber) {
		super();
		this.city = city;
		this.neighborhood = neighborhood;
		this.type = type;
		this.nameOrNumberofType = nameOrNumberofType;
		this.prefixOrQuadrant = prefixOrQuadrant;
		this.generatingWayNumber = generatingWayNumber;
		this.plateNumber = plateNumber;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNameOrNumberofType() {
		return nameOrNumberofType;
	}
	public void setNameOrNumberofType(String nameOrNumberofType) {
		this.nameOrNumberofType = nameOrNumberofType;
	}
	public String getPrefixOrQuadrant() {
		return prefixOrQuadrant;
	}
	public void setPrefixOrQuadrant(String prefixOrQuadrant) {
		this.prefixOrQuadrant = prefixOrQuadrant;
	}
	public int getGeneratingWayNumber() {
		return generatingWayNumber;
	}
	public void setGeneratingWayNumber(int generatingWayNumber) {
		this.generatingWayNumber = generatingWayNumber;
	}
	public int getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(int plateNumber) {
		this.plateNumber = plateNumber;
	}
	@Override
	public String toString() {
		return "Address [City:" + city + ", Neighborhood:" + neighborhood+" " + type + "-"
				+ nameOrNumberofType + "-" + prefixOrQuadrant + "-"
				+ generatingWayNumber + "-" + plateNumber +"]\n";
	}
}