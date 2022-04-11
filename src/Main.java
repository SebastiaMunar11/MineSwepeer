public class Main {

    public static void main(String[] args) {

        Menu mainmenu = new Menu();

        mainmenu.guanyar();

        mainmenu.setDificultat();

        Taulell taulell = new Taulell(mainmenu.getDificultat());
        taulell.displayTaulell();
    }



}
