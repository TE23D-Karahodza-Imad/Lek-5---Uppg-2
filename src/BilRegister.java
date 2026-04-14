import java.util.ArrayList;

// Klassen BilRegister hanterar en samling av bilar
public class BilRegister {

    // En ArrayList som håller alla bilar i registret
    private ArrayList<Bil> bilar;

    // Konstruktor - skapar ett tomt register
    public BilRegister() {
        this.bilar = new ArrayList<>();
    }

    // Metod: lägger till en bil i registret
    // Kastar undantag om registreringsnumret redan finns
    public void läggTillBil(Bil bil) {
        if (hittaBil(bil.getRegistreringsnummer()) != null) {
            throw new IllegalArgumentException(
                "Registreringsnummer " + bil.getRegistreringsnummer() + " finns redan i registret!");
        }
        bilar.add(bil);
    }

    // Metod: tar bort en bil från registret via registreringsnummer
    public void taBortBil(String registreringsnummer) {
        Bil hittad = hittaBil(registreringsnummer);
        if (hittad == null) {
            System.out.println("Ingen bil med regnummer " + registreringsnummer + " hittades.");
        } else {
            bilar.remove(hittad);
            System.out.println("Bil med regnummer " + registreringsnummer + " borttagen.");
        }
    }

    // Metod: söker efter en bil via registreringsnummer, returnerar null om ej hittad
    public Bil hittaBil(String registreringsnummer) {
        for (Bil bil : bilar) {
            if (bil.getRegistreringsnummer().equalsIgnoreCase(registreringsnummer)) {
                return bil;
            }
        }
        return null;
    }

    // Metod: returnerar antal bilar i registret
    public int getAntal() {
        return bilar.size();
    }

    // Metod: skriver ut alla bilar i registret
    @Override
    public String toString() {
        if (bilar.isEmpty()) {
            return "Registret är tomt.";
        }
        StringBuilder sb = new StringBuilder();
        for (Bil bil : bilar) {
            sb.append(bil.toString()).append("\n");
        }
        return sb.toString();
    }
}
