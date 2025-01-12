import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Evidence {
    private Databaze databaze;
    private Scanner scanner = new Scanner(System.in);

    //Konstruktor
    public Evidence(){
        databaze = new Databaze();
    }

    //Přidání nového pojištěnce
    public void pridejPojistence() {
        System.out.println("Zadejte nového pojištěnce ve tvaru: Jméno-Příjmení-Věk-TelefonníČíslo");
        //Cyklus pro případné chybné zadání hodnot
        while (true) {
            try {
                String text = scanner.nextLine();

                // Získání jednotlivých částí
                String[] pojistenec = text.split("-");

                // Kontrola, zda vstup obsahuje přesně čtyři části
                if (pojistenec.length != 4) {
                    throw new IllegalArgumentException("Vstup neobsahuje správný počet položek.");
                }

                //Rozdělení pole do jednotlivých proměnných pro lepší práci s daty
                String jmeno = pojistenec[0];
                String prijmeni = pojistenec[1];
                int vek = Integer.parseInt(pojistenec[2]);
                int telCislo = Integer.parseInt(pojistenec[3]);

                // Kontrola, že věk je kladný
                if (vek <= 0) {
                    throw new IllegalArgumentException("Věk musí být kladná hodnota větší než 0.");
                }

                // Přidání pojištěnce, pokud je vstup platný
                databaze.pridejPojistence(Pojistenec.last_id, jmeno, prijmeni, vek, telCislo);
                System.out.println("Pojištěnec byl úspěšně přidán.");
                System.out.println("Pokračujte klávesou enter...");
                scanner.nextLine(); // Čekání na stisk libovolné klávesy
                break;

            } catch (NumberFormatException e) {
                System.out.println("Chyba: Věk a telefonní číslo musí být čísla. Zkuste to prosím znovu.");
            } catch (IllegalArgumentException e) {
                System.out.println("Nesprávný formát zadání. " + e.getMessage() + " Zkuste to prosím znovu.");
            } catch (Exception e) {
                System.out.println("Došlo k neočekávané chybě. Zkuste to prosím znovu.");
            }
        }
    }


    //Vypsání všech pojištěnců v databázi
    public void vypisPojistence() {
        ArrayList<Pojistenec> pojistenci = databaze.vypisPojistence();
        for (Pojistenec pojistenec : pojistenci) {
            System.out.println(pojistenec);
        }
    }

    //Metoda pro vyhledání konkrétního jména a příjmení v databázi
    public void hledejPojistence() {
        String jmeno = "";
        String prijmeni = "";

        // Kontrola vstupu jména
        while (jmeno.trim().isEmpty()) {
            System.out.println("Zadej jméno: ");
            jmeno = scanner.nextLine();
            if (jmeno.trim().isEmpty()) {
                System.out.println("Jméno nemůže být prázdné, zkuste to znovu.");
            }
        }

        // Kontrola vstupu příjmení
        while (prijmeni.trim().isEmpty()) {
            System.out.println("Zadej příjmení: ");
            prijmeni = scanner.nextLine();
            if (prijmeni.trim().isEmpty()) {
                System.out.println("Příjmení nemůže být prázdné, zkuste to znovu.");
            }
        }

        // Hledání pojištěnců
        ArrayList<Pojistenec> pojistenci = databaze.hledejPojistence(jmeno, prijmeni);

        // Kontrola, zda byly nalezeny nějaké výsledky
        if (pojistenci.isEmpty()) {
            System.out.println("Nebyl nalezen žádný pojištěnec se zadanými údaji.");
        } else {
            for (Pojistenec pojistenec : pojistenci) {
                System.out.println(pojistenec);
            }
        }

        // Zpráva pro pokračování
        System.out.println("Pokračujte klávesou enter...");
        scanner.nextLine(); // Čekání na stisk libovolné klávesy
    }

    public void vypisHlavicku() {
        System.out.println("--------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("--------------------------");
        System.out.println();
    }
    public void vypisMenu(){
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojistěného");
        System.out.println("4 - Konec");
    }
}
