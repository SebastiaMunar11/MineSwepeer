import java.util.Scanner;

public class Menu {

    private String dificultat;
    Scanner sc = new Scanner(System.in);

    public String getDificultat() {
        return dificultat;
    }

    public void setDificultat() {
        System.out.println("Selecciona la dificultat:");
        System.out.println("facil -> 8x8 10 mines");
        System.out.println("intermig -> 16x16 40 mines");
        System.out.println("dificil -> 16x32 99 mines");
        System.out.println();

        while(dificultat== null) {
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

    public void guanyar() {
        System.out.println("EHORABONA, HAS GUANYAT!!");
        System.exit(0);
    }

    public void perdre(Taulell taulell) {
        System.out.println("LLÀSTIMA, HAS PERDUT!!");
        taulell.displayMines();
        System.exit(0);
    }

    public void




}
