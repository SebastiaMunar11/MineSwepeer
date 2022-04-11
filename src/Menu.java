import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    private String dificultat;
    Scanner sc = new Scanner(System.in);
    Taulell taulell = new Taulell(getDificultat());

    public String getDificultat() {
        return dificultat;
    }

    public void setDificultat() {
        System.out.println("Selecciona la dificultat:");
        System.out.println("facil -> 8x8 10 mines");
        System.out.println("intermig -> 16x16 40 mines");
        System.out.println("dificil -> 16x32 99 mines");
        System.out.println();

        while (dificultat == null) {
            switch (sc.nextLine()) {
                case "dificil":
                    dificultat = "dificil";
                    break;

                case "intermig":
                    dificultat = "intermig";
                    break;

                case "facil":
                    dificultat = "facil";
                    break;

                default:
                    System.out.println("Difícultat no vàlida");
            }
        }
    }

    public void demanarAccio() {
        System.out.println("Trïa una acció:");
        System.out.println("1 -> Posar bandera");
        System.out.println("2 -> Destapar casella");

        String accio = "";

        int fila;
        int columna;

        while (accio != "1" && accio != "2") {
            accio = sc.nextLine();

            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Fila:");
                    fila = sc.nextInt();
                    System.out.println("Columna:");
                    columna = sc.nextInt();
                    taulell.posarBandera(fila, columna);
                    break;

                case "2":
                    System.out.println("Fila:");
                    fila = sc.nextInt();
                    System.out.println("Columna:");
                    columna = sc.nextInt();
                    taulell.destaparCasella(fila, columna);
                    break;

                default:
                    System.out.println("Acció no vàlida");
            }
        }
    }


    public void guanyar() {
        System.out.println("EHORABONA, HAS GUANYAT!!");
        System.exit(0);
    }

    public void perdre() {
        System.out.println("LLÀSTIMA, HAS PERDUT!!");
        taulell.displayMines();
        System.exit(0);
    }

    public void comprovarDerrota() {
        Casella[][] caselles = taulell.getCaselles();

        for (int i = 0; i < caselles.length; i++) {
            for (int j = 0; j < caselles[0].length; j++) {
                if (caselles[i][j].isMina() && caselles[i][j].isDestapada()) {
                    perdre();
                }
            }
        }
    }

    public void comprovarVictoria() {
        Casella[][] caselles = taulell.getCaselles();
        boolean isVictoria = true;

        for (int i = 0; i < caselles.length; i++) {
            for (int j = 0; j < caselles[0].length; j++) {
                if (!caselles[i][j].isMina() && !caselles[i][j].isDestapada()) {
                    isVictoria = false;
                }
            }
        }

        if (isVictoria) {
            guanyar();
        }
    }


}
