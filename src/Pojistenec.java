public class Pojistenec {
    public int id;
    public static int last_id = 1; //ID uživatelů začíná od 1
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telCislo;

    //Konstruktor
    public Pojistenec(int id,String jmeno, String prijmeni, int vek, int telCislo) {
        this.id = last_id++;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
    }
    //Gettery a metoda toString pro navrácení pojistence ve Stringu

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public int getTelCislo() {
        return telCislo;
    }

    //Výpis pojištěnce
    @Override
    public String toString() {
        return jmeno + "\t" + prijmeni + "\t" + vek + "\t" + telCislo;
    }
}
