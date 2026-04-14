public class App {
    public static void main(String[] args) {
        // Skapa ett nytt bilregister
        BilRegister register = new BilRegister();

        // Lägg till bilar i registret
        register.läggTillBil(new Bil("Volvo", "XC90", "ABC123", 2019));
        register.läggTillBil(new Bil("Saab", "9-5", "XYZ789", 2010));
        register.läggTillBil(new Bil("Tesla", "Model Y", "DEF456", 2023));

        // Visa alla bilar i registret
        System.out.println("Alla bilar i registret:");
        System.out.println(register.toString());

        // Ta bort en bil
        register.taBortBil("XYZ789");
        System.out.println("\nEfter att ha tagit bort en bil:");
        System.out.println(register.toString());

        // Testa hitta en bil via registreringsnummer
        Bil bil = register.hittaBil("DEF456");
        System.out.println("\nHittad bil: " + bil);

        // Testa att lägga till en bil med ett redan existerande registreringsnummer
        try {
            register.läggTillBil(new Bil("BMW", "M3", "ABC123", 1989));
        } catch (IllegalArgumentException e) {
            System.out.println("\nFel: " + e.getMessage());
        }
    }
}
