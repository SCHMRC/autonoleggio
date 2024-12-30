package it.marcoschiavo.gestionaleautonoleggio.view;

import java.io.*;

import it.marcoschiavo.gestionaleautonoleggio.model.Autonoleggio;
import it.marcoschiavo.gestionaleautonoleggio.model.MARCA;
import it.marcoschiavo.gestionaleautonoleggio.model.MODELLO;

public class Cli {
	private InputStreamReader stream;
	private BufferedReader tastiera;
	private Autonoleggio garage;
	
	public Cli() {
		stream = new InputStreamReader(System.in);
		tastiera = new BufferedReader(stream);
		garage = new Autonoleggio();
	}
	
	public int getMenu() throws NumberFormatException, IOException {
		System.out.println("Menu Gestionale Autonoleggio");
		System.out.println("1. Aggiungi Veicolo");
		System.out.println("2. Rimuovi Veicolo");
		System.out.println("3. Ricerca info Veicolo");
		System.out.println("4. Salva su file");
		System.out.println("5. Leggi file");
		System.out.println("6. Exit");
		return Integer.parseInt(this.tastiera.readLine());
	}
	
	public void getMenuRead() throws Exception{
		System.out.println("Inserisci il percorso del file: ");
		String path = tastiera.readLine();
		System.out.println("Inserisci il nome del file con estensione html o txt: ");
		String nomefile = tastiera.readLine();
		this.garage.readFile(path, nomefile);
	}
	
	public void getMenuSave() throws Exception {
		System.out.println("Inserisci il percorso del file: ");
		String path = tastiera.readLine();
		System.out.println("Inserisci il nome del file con estensione html o txt: ");
		String nomefile = tastiera.readLine();
		this.garage.saveFile(path, nomefile);
	}
	
	public void getMenuInfoVeicolo() throws Exception {
		System.out.println("Inserisci la targa o il codice:");
		String x = this.tastiera.readLine();
		if(x.matches("[a-zA-Z]")) {
			this.garage.searchCar(x);
		}else{
			this.garage.searchCar(Integer.parseInt(x));
		};
		
	}
	
	public void getMenuRemoveVeicolo() throws IOException {
		System.out.println("Inserisci la targa o il codice: ");
		String x = this.tastiera.readLine();
		if(x.matches("[a-zA-Z]")) {
			this.garage.removeCar(x);
		}else{
			this.garage.removeCar(Integer.parseInt(x));
		};
	}
	
	public void getMenuAddVeicolo() throws Exception {
		System.out.println("Inserisci Targa");
		String targa = tastiera.readLine();
		System.out.println("Scegli la Marca");
		MARCA marca;
		do {marca = getMenuMarca();}while(marca == null);
		System.out.println("Inserisci Modello");
		MODELLO modello;
		do {modello = getMenuModello();}while(modello == null);
		System.out.println("Inserisci Posti");
		int posti = Integer.parseInt(tastiera.readLine());
		this.garage.addCar(targa, marca, modello, posti);
	}
	
	private MARCA getMenuMarca() throws Exception{
		System.out.println("1. " + MARCA.CITROEN);
		System.out.println("2. " + MARCA.FERRARI);
		System.out.println("3. " + MARCA.FIAT);
		System.out.println("4. " + MARCA.FORD);
		System.out.println("5. " + MARCA.PEUGEOT);
		int marca = Integer.parseInt(tastiera.readLine());
		switch(marca) {
		case 1: return MARCA.CITROEN;
		case 2: return MARCA.FERRARI;
		case 3: return MARCA.FIAT;
		case 4: return MARCA.FORD;
		case 5: return MARCA.PEUGEOT;
		default: return null;
		}
	}
	
	private MODELLO getMenuModello() throws Exception {
		System.out.println("1. " + MODELLO.FUORISTRADA);
		System.out.println("2. " + MODELLO.SATIONVEGON);
		System.out.println("3. " + MODELLO.SPORTIVA);
		System.out.println("4. " + MODELLO.UTILITARIA);
		int modello = Integer.parseInt(tastiera.readLine());
		switch(modello) {
		case 1: return MODELLO.FUORISTRADA;
		case 2: return MODELLO.SATIONVEGON;
		case 3: return MODELLO.SPORTIVA;
		case 4: return MODELLO.UTILITARIA;
		default: return null;
		}
	}
	

}
