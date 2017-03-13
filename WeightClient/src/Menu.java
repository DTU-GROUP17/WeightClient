
public class Menu {

	public void display() {
		System.out.println("---------- Hoved menu ----------");
		System.out.println("Vælg en handling:\n" + 
				"	1) Begynd afvejning \n" + // D
				"	2) Afslut simulering \n" // B
		);
	}
	
	public void resultat(double tara, double netto, double brutto) {
		System.out.println("---------- Resultat ----------");
		System.out.println("---------- " + tara + " kg + " + netto + " kg = " + brutto + " kg" + "----------");
		System.out.println("Vælg en handling:\n" + 
				"	1) Tilbage til Hoved menu \n" + // D
				"	2) Afslut simulering \n" // B
		);
	}
	
	public void exit() {
		System.out.println("Afslutter simulering..");
	}

	public void wrong() {
		System.out.println("Forkert indtastning");
	}

}
