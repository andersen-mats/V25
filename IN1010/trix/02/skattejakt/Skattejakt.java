import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Skattejakt {

    boolean funnet = false;
    char[][] kart;
    int hoyde;
    int bredde;
    int skattHoyde;
    int skattBredde;
    
    private Skattejakt(char[][] kart, int hoyde, int bredde) {
        Random rand = new Random();
        this.kart = kart;
        this.hoyde = hoyde;
        this.bredde = bredde;
        this.skattHoyde = rand.nextInt(this.hoyde - 1);
        this.skattBredde = rand.nextInt(this.bredde - 1);
    }

    private void vinner() {
        for (int i = 0; i < this.hoyde; i++) {
            for (int j = 0; j < this.bredde; j++) {
                if (i == this.skattHoyde && j == this.skattBredde) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    public boolean sjekk(int rad, int kol) {
        System.out.println(this.skattHoyde + " " + this.skattBredde);
        if (rad == this.skattHoyde && kol == this.skattBredde) {
            this.vinner();
            return true;
        } else {
            return false;
        }
    }

                        
    static Skattejakt lesInn(File fil) throws Exception {

        Scanner leser = new Scanner(fil);
        int hoyde = 0;
        int bredde = 0;
        String temp = "";

        while (leser.hasNextLine()) {
            hoyde += 1;
            temp = leser.nextLine();
            bredde = temp.length();
        }

        leser.close();

        char[][] kart = new char[hoyde][bredde];

        for (int i = 0; i < hoyde; i++) {
            int j = 0;
            for (char c : temp.toCharArray()) {
                kart[i][j] = c;
                j++;
            }
        }

        Skattejakt skattejakt = new Skattejakt(kart, hoyde, bredde);

        return skattejakt;
    }

    public void skrivUt() {
        for (int x = 0; x < this.hoyde; x++) {
            for (int y = 0; y < this.hoyde; y++) {
                System.out.print(this.kart[x][y]);
            }
            System.out.println();
        }
    }
}
