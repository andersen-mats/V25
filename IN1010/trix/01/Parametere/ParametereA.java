public class ParametereA {
    public static void main(String[] args) {
        String a = "en tekst!";

        metodeEn(a);

        System.out.println(a);

    }

    public static void metodeEn(String a) {
        a = a + 12;
    }
}

// String er immutable i Java; funksjonen returnerer ingenting,
// saa "en tekst!" vil printes.
