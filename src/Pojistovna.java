import java.util.Scanner;

public class Pojistovna {
    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        Scanner scanner = new Scanner(System.in);
        String volba = "";
        // hlavní cyklus
        evidence.vypisHlavicku();
        while (!volba.equals("4")) {
            evidence.vypisMenu(); //vypíše menu
            volba = scanner.nextLine();
            System.out.println();
            // reakce na volbu
            switch (volba) {
                case "1":
                    evidence.pridejPojistence();
                    break;
                case "2":
                    evidence.vypisPojistence();
                    break;
                case "3":
                    evidence.hledejPojistence();
                    break;
                case "4":
                    // skončí cyklus a tím program
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
        }
    }
}
