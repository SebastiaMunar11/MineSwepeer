public class Main {

    public static void main(String[] args) {

        Menu mainmenu = new Menu();

        mainmenu.setDificultat();

        Taulell taulell = new Taulell(mainmenu.getDificultat());
        taulell.displayTaulell();

        mainmenu.perdre(taulell);
    }



}
