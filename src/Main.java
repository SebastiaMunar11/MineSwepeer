import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Menu mainmenu = new Menu();
        mainmenu.getTaulell().displayTaulell();
        mainmenu.demanarAccio();
        while(true){
            mainmenu.getTaulell().displayTaulell();
            mainmenu.demanarAccio();
            mainmenu.comprovarDerrota();
            mainmenu.comprovarVictoria();
        }



    }



}
