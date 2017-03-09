
public class Menu {

	public void display() {
		System.out.println("---------- Weight Client ----------");
		System.out.println("Vælg en handling:\n" + 
				"	1) Indtast operatoernummer \n" + // P111
				"	2) Indtast batchnummer \n" + //
				"	3) Tarér vægten \n" + // D
				"	4) Slet vægtens display\n" + // DW
				"	5) Skriv max 30 tegn \n" + // P111
				"	6) Skriv i display afvent, indtastning \n" + // RM20 8
				"	7) Skift vægtens knap tilstand \n" + // K
				"	8) Sæt ny bruttovægt \n" + // B
				"	9) Afslut simulering \n" // B
		);
	}

	public void exit() {
		System.out.println("Afslutter simulering..");
		System.exit(1);
	}

	public void wrong() {
		System.out.println("Forkert indtastning");
	}

}
