import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Menu mainmenu = new Menu();

        mainmenu.setDificultat();

        Taulell taulell = new Taulell(mainmenu.getDificultat());

        taulell.displayMines();

        taulell.destaparCasella(sc.nextInt(), sc.nextInt());

        taulell.displayMines();

    }



}
