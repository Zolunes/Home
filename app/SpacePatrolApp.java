package app;

import java.util.Scanner;
import java.util.Set;

import model.SpaceShip;
import model.Superpower;

/**
 * @class SpacePatrolApp enthält alle Menüs des Spiels und leitet den Spieler über die Konsole durch das Spiel.
 * @param maxSpaceShips gibt die maximale Anzahl von SpaceShips an, die ein Spieler in seiner Flotte speichern kann.
 * @param ships ist die Flotte eines Spielers.
 * @param scanner ist ein Scanner, der im Programm zum Einlesen von User-Input verwendet wird.
 * @author Anna Ditscherlein
 * @author Dilara Yildrim
 */
public class SpacePatrolApp {

	private static final int maxSpaceShips = 5;
	private static SpaceShip[] ships = new SpaceShip[maxSpaceShips];
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args mainmethode ruft die Methode Standardmenü auf, welche das Standardmenü ausgibt. 
	 * @param choise Daraufhin liest die Mainmethode ein, welche Funktion der Spieler ausführen möchte und führt dies mit Weitergabe an die Methode handle() aus.
	 * 
	 * 
	 */
	public static void main(String[] args) {

		while (true) {
			showStandardMenu();
			int choice = readUserInput();
			handle(choice);
			System.out.println("====================");
		}
	}

	/**
	 * 
	 * @return
	 */
	private static int readUserInput() {
		System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein:\t");
		int choiceInternal = scanner.nextInt();

		return choiceInternal;
	}

	/**
	 * 
	 * @param choice
	 */
	private static void handle(int choice) {
		switch (choice) {
		case 1:
			createSpaceShip();
			break;
		case 2:
			showOneSpaceShip();
			break;
		case 3:
			showAllSpaceShips();
			break;
		case 4:
			removeSpaceShip();
			break;
		case 5:
			showPatrolMenu();
			break;
		case 6:
			System.exit(0);
			break;
		default: {
			System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
			showStandardMenu();
		}
			break;

		}
	}

	/**
	 * 
	 * Die Methode druckt auf der Konsole das Standardmenü aus.
	 * @param menuItems ist ein String-Array, der die einzelnen Optionen des Menüs enthält.
	 */
	private static void showStandardMenu() {

		String menuItems[] = { "", "(1)\t Raumschiff anlegen", "(2)\t Daten eines Raumschiffs anzeigen",
				"(3)\t Daten aller Raumschiffe anzeigen", "(4)\t Raumschiff aus der Flotte nehmen" , "(5)\t Patrouillen-Flug starten", 
				"(6)\t Beenden"};

		System.out.println("\nSPACE PATROL 1.0\n");
		for (int i = 1; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}
	

	}
	/**
	 * Die Methode druckt auf der Konsole das Standardmenü aus.
	 * @param menuItems ist ein String-Array, der die einzelnen Optionen des Menüs enthält.
	 */
	private static void showPatrolMenu() {
		

			String menuItems[] = { "", "(1)\t Patrouillieren", "(2)\t Regenerieren",
					"(3)\t Patrouille beenden"};

			System.out.println("\n------ Patrouille Menu ------\n");
			for (int i = 1; i < menuItems.length; i++) {
				System.out.println(menuItems[i]);
			}
			
		
	}

	private static void printSpaceShipData(SpaceShip spaceShip){
		System.out.println("ID: " + spaceShip.getId());
		System.out.println("Name: " + spaceShip.getName());
		System.out.println("Superkraft: " + spaceShip.getSuperkraft());

	}

	/**
	 * Die Methode soll auf der Konsole alle bisher angelegten SpaceShips ausgeben.
	 * @param spaceShip
	 * @param ships
	 * 
	 */
	private static void showAllSpaceShips(){
		for(SpaceShip spaceShip : ships){
			if(spaceShip != null){
				printSpaceShipData(spaceShip);
			}
		}
	}

/* 
	private static void showAllSpaceShips(){
		for(int j = 0; j<=ships.length; j++){
			if(ships[j]!=null){
			System.out.println(ships[j].getName());
			System.out.println(ships[j].getSuperkraft());
			}
		}
	}
*/

	/**
	 * Die Methode erstellt mei Standardmenü-Wahl 1 ein neues Objekt vom Typ Spaceship, welches auch ein neu erzeugtes Objekt vom Typ Superkraft enthält.
	 * @param spaceShip ist ein neu erzeugtes Objekt vom Typ SpaceShip
	 * @param superpower ist ein neu erzeugtes Objekt vom Typ Superpower
	 */

	private static void createSpaceShip() {
		//System.out.println("Bitte geben Sie einen Namen für Ihr Raumschiff ein.");
		//String name = scanner.next();
		SpaceShip spaceShip = new SpaceShip();
		//spaceShip.setName(name);
			//Superpower superpower = new Superpower();
		//superpowner.setName("Invisibility");
		//paceShip.setSuperkraft(superpowner);
		if(ships[0]==null){
			ships[0] = spaceShip;
		}else{
			if(ships[1]==null){
				ships[1] = spaceShip;
			}else{
				if(ships[2]==null){
					ships[2] = spaceShip;
				}else{
					if(ships[3]==null){
						ships[3] = spaceShip;
					}else{
						if(ships[4]==null){
							ships[4] = spaceShip;
						}
					}
				}
			}
		}
	}
	/*
	int i = 0;
		if(spaceShip!=null){
			ships[i] = spaceShip;
			i++;
		}
	*/	
	

	/**
	 * Die Methode zeigt ein bestimmtes SpaceShip und dessen Daten an.
	 * @param id
	 * @param spaceship
	 * @param scanner
	 */
	
	 private static void showOneSpaceShip(){
		System.out.println("Name des gewünschten Raumschiffs: ");
		String name = scanner.next();
		SpaceShip spaceship = getSpaceShipByName(name);
		if (spaceship != null){
			for(int i=0; i<ships.length; i++){
				if(ships[i]==spaceship){
				printSpaceShipData(spaceship);
			break;
				}
			}
		}else{
			System.out.println("Raumschiff mit dem Namen " + name + " wurde nicht gefunden.");
		}
	}


	/**
	 * Die Methode entfernt ein beliebiges SpaceShip aus der Flotte.
	 * @param id
	 * @param spaceship
	 */

	 private static void removeSpaceShip(){
		System.out.print("Name des Raumschiffs: ");
		String name = scanner.next();

		SpaceShip spaceship = getSpaceShipByName(name);
		if (spaceship == null){
				System.out.println("Raumschiff mit dem Namen " + name + " wurde nicht gefunden.");
		
		}else{
			for(int i=0; i<ships.length; i++){
				if(ships[i]==spaceship){
					ships[i]=null;
					break;
				}
			}
		}
	}


	private static SpaceShip getSpaceShipByName(String name){
		for(SpaceShip spaceShip : ships){
			if(spaceShip != null && spaceShip.getName()== name){
				return spaceShip;
				
			}
		}
		return null;
	}
}
