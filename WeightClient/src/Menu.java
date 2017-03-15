/**
 * The Menu.java class contains the textual menu of the weight client.
 */


public class Menu {

	public void display() {
		System.out.println("--------------------------------");
		System.out.println("---------- Hoved menu ----------");
		System.out.println("--------------------------------");
		System.out.println("Vælg en handling:\n" + 
				"	1) Begynd afvejning \n" +
				"	2) Afslut simulering \n"
		);
	}
	
	public void resultat(double tara, double netto, double brutto, String operatoerId, String batchId) {
		System.out.println("-----------------------------------");
		System.out.println("---------- Resultat menu ----------");
		System.out.println("-----------------------------------");
		System.out.println("Operatør " + operatoerId + " har afvejet batchnummer " + batchId + "");
		System.out.println("Tara = " + tara + " kg");
		System.out.println("Netto = " + netto + " kg");
		System.out.println("Brutto = " + brutto + " kg");
		System.out.println("Vælg en handling:\n" + 
				"	1) Tilbage til Hoved menu \n" +
				"	2) Afslut simulering \n"
		);
	}
	
	public void exit() {
		System.out.println("Afslutter simulering..");
	}

	public void wrong() {
		System.out.println("Forkert indtastning");
	}

}
