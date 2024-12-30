package it.marcoschiavo.gestionaleautonoleggio;
import it.marcoschiavo.gestionaleautonoleggio.view.Cli;

public class Start {

	public static void main(String[] args) throws Exception {
	    Cli cli = new Cli();
	    int x = 0;
		do {
		 	x = cli.getMenu();
		 	switch(x) {
		 		case 1:{
		 			cli.getMenuAddVeicolo();
		 			break;}
		 		case 2:{
		 			cli.getMenuRemoveVeicolo();
		 			break;}
		 		case 3:{
		 			cli.getMenuInfoVeicolo();
		 			break;}
		 		case 4:{
		 			cli.getMenuSave();
		 			break;}
		 		case 5:{
		 			cli.getMenuRead();
		 			break;}
		 		default:{
		 			x = 6;
		 			break;}
		 	}
			
		}while(x < 6);

	}

}
