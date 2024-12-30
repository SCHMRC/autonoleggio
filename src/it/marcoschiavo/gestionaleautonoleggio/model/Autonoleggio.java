package it.marcoschiavo.gestionaleautonoleggio.model;

import java.io.*;
import java.util.Arrays;


public class Autonoleggio {
	private Veicolo[] veicoli;
	private int codice = 0;
	private final int N = 1000;
	
	public Autonoleggio() {
		this.veicoli = new Veicolo[N];
	}
	
	public void addCar(String targa, MARCA marca, MODELLO modello, int numeroPosti) {
		codice++;
		for(int i = 0; i < this.veicoli.length; i++) {
			if(this.veicoli[i] == null) {
				this.veicoli[i] = new Veicolo(codice,targa,marca,modello,numeroPosti);
				System.out.println("Veicolo aggiunto!");
				break;
			}
		}
	}
	
	public void removeCar(int codice) {
		for (int i = 0 ; i < veicoli.length ; i++) {
			if(veicoli[i].getCodice() == codice) {
				veicoli[i] = null;
				System.out.println("Veicolo con codice "+ codice + " rimosso");
				break;
			}
		}
	}
	
	public void removeCar(String targa) {
		for (int i = 0 ; i < veicoli.length ; i++) {
			if(targa.equalsIgnoreCase(veicoli[i].getTarga().toString())) {
				veicoli[i] = null;
				System.out.println("Veicolo con targa "+ targa + " rimosso");
				break;
			}
		}
	}
	
	public void searchCar(int codice) {
		for (int i = 0 ; i < veicoli.length ; i++) {
			if(veicoli[i].getCodice() == codice) {
				System.out.println(veicoli[i].toString());
				break;
			}
		}
	}
	
	public void searchCar(String targa) {
		for (int i = 0 ; i < veicoli.length ; i++) {
			if(targa.equalsIgnoreCase(veicoli[i].getTarga().toString())) {
				System.out.println(veicoli[i].toString());
				break;
			}
		}
	}
	
	public void searchCarPosti(int posti) {
		for (int i = 0 ; i < veicoli.length ; i++) {
			if(veicoli[i].getNumeroPosti() == posti) {
				System.out.println(veicoli[i].toString());
			}
		}
	}
	
	public void readFile(String path, String nomeFile) {
		try {
			if(verificaPercorso(path, nomeFile)) {
				BufferedReader br = new BufferedReader(new FileReader(path + "/" + nomeFile));
				String temp = "";
				while((temp = br.readLine()) != null) {
					System.out.println(temp);
				}
				br.close();
			}else {
				System.out.println("File o directory inesistente!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private boolean verificaPercorso(String path, String nomeFile) {
		File d = new File(path);
		File f = new File(path + "/" + nomeFile);
		boolean flag;
		return flag = (d.exists() && f.exists())? true : false;
		
	}
	
	public void saveFile(String path, String nomeFile) {
		try {
			controlPath(path, nomeFile);
			FileWriter fw = new FileWriter(path + "/" + nomeFile);
			BufferedWriter bw = new BufferedWriter(fw);
			String content = "";
			if(nomeFile.contains("html")) {
				content = "<ul>";
				for(Veicolo veicolo : this.veicoli) {
					if(veicolo != null)
						content += "<li>" + veicolo.toString() + "</li>";
				}
				content += "</ul>";
			}else if(nomeFile.contains("txt")){
				for(Veicolo veicolo : this.veicoli) {
					if(veicolo != null)
						content += veicolo.toString() + "\n";
				}
				
			}
			bw.write(content);
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	
	private void controlPath(String path, String nomeFile) throws Exception {
		File d = new File(path);
		if(!d.exists())
			d.mkdir();
		File f = new File(path + "/" + nomeFile );
		if(!f.exists())
			f.createNewFile();
	}
	
	public String toString() {
		return Arrays.toString(this.veicoli);
	}
	
	

}
