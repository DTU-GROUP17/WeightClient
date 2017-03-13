
public class Menu {

	public void display() {
		System.out.println("---------- Weight Client ----------");
		System.out.println("Vælg en handling:\n" + 
				"	1) Begynd afvejning \n" + // D
				"	2) Afslut simulering \n" // B
//				"	3) Tarér vægten \n" + // P111
//				"	4) Slet vægtens display\n" + // DW
//				"	5) Skriv max 30 tegn \n" + // P111
//				"	6) Skriv i display afvent, indtastning \n" + // RM20 8
//				"	7) Skift vægtens knap tilstand \n" + // K
//				"	8) Sæt ny bruttovægt \n" + // B

		);
	}
	
	public void afvejning() {
		System.out.println("---------- Afvejning ----------");
		System.out.println("Vælg en handling:\n" + 
				"	1) Begynd afvejning \n" + // D
				"	2) Indtast batchnummer \n" + //
				"	3) Tarér vægten \n" + // P111
				"	4) Slet vægtens display\n" + // DW
				"	5) Skriv max 30 tegn \n" + // P111
				"	6) Skriv i display afvent, indtastning \n" + // RM20 8
				"	7) Skift vægtens knap tilstand \n" + // K
				"	8) Sæt ny bruttovægt \n" + // B
				"	9) Afslut simulering \n" // B
		);
	}
	
	public void operatorId() {
		System.out.println("Indtast operatoernummer");
	}
	public void batchId() {
		System.out.println("Indtast batchnummer");
	}

	public void exit() {
		System.out.println("Afslutter simulering..");
	}

	public void wrong() {
		System.out.println("Forkert indtastning");
	}

}
