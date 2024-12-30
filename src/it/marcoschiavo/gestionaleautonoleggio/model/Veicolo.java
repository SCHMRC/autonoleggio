package it.marcoschiavo.gestionaleautonoleggio.model;

public class Veicolo {
	private int codice;
	private String targa;
	private MARCA marca;
	private MODELLO modello;
	private int numeroPosti;
	
	public Veicolo() {}

	public Veicolo(int codice, String targa, MARCA marca, MODELLO modello, int numeroPosti) {
		super();
		this.codice = codice;
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.numeroPosti = numeroPosti;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public MARCA getMarca() {
		return marca;
	}

	public void setMarca(MARCA marca) {
		this.marca = marca;
	}

	public MODELLO getModello() {
		return modello;
	}

	public void setModello(MODELLO modello) {
		this.modello = modello;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	@Override
	public String toString() {
		return "Veicolo [codice=" + codice + ", targa=" + targa + ", marca=" + marca + ", modello="
				+ modello + ", numeroPosti=" + numeroPosti + "]";
	}
	
	
	

}
