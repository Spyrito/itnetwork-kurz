import java.time.LocalDateTime;
import java.util.ArrayList;

public class Databaze {
    ArrayList <Pojistenec> pojistenci;

    //Konstruktor
    public Databaze() {
        pojistenci = new ArrayList<>();
    }

    // Přídání pojištěnce
    public void pridejPojistence(String jmeno, String prijmeni,int vek, int telCislo){
        pojistenci.add(new Pojistenec(jmeno,prijmeni,vek,telCislo));
    }

    //Metoda s návratovým arraylistem všech pojištěnců
    public ArrayList<Pojistenec> vratPojistence() {
        return pojistenci;
    }

    //Metoda s návratovým arraylistem všech pojištěnců který odpovídají vstupu jména a příjmení
    // A ošetření malých a velkých písmen u vstupu
    public ArrayList<Pojistenec> hledejPojistence(String jmeno, String prijmeni) {
        ArrayList<Pojistenec> nalezene = new ArrayList<>();
        for (Pojistenec pojistenec : pojistenci) {
            if (pojistenec.getJmeno().toLowerCase().equals(jmeno) && pojistenec.getPrijmeni().toLowerCase().equals(prijmeni)){
                nalezene.add(pojistenec);
            }
        }
        return nalezene;
    }
}
