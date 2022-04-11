import java.util.InputMismatchException;

public class Taulell {

    private Casella[][] caselles;
    private int mines;
    private int banderes;

    public Taulell(String dificultat) {
        switch (dificultat) {
            case "dificil" -> {
                caselles = new Casella[16][32];
                mines = 99;
                banderes = 99;
            }
            case "intermig" -> {
                caselles = new Casella[16][16];
                mines = 40;
                banderes = 40;
            }
            case "facil" -> {
                caselles = new Casella[8][8];
                mines = 10;
                banderes = 10;
            }
        }
        omplirCaselles();
        omplirMines();
        assignarValorCaselles();
    }

    public Casella[][] getCaselles() {
        return caselles;
    }

    private void omplirCaselles() {
        for (int i = 0; i < caselles.length; i++) {
            for (int j = 0; j < caselles[0].length; j++) {
                caselles[i][j] = new Casella();
            }
        }
    }

    private void omplirMines() {
        while (mines != 0) {
            for (int i = 0; i < caselles.length; i++) {
                for (int j = 0; j < caselles[0].length; j++) {
                    if (Math.round(Math.random() * 10) == 5) {
                        caselles[i][j].setMina(true);
                        mines--;
                    }
                    if (mines == 0) {
                        break;
                    }
                }
                if (mines == 0) {
                    break;
                }
            }
        }
    }

    public void displayTaulell() {
        int fila = 0;
        int columna = 0;

        System.out.print("     ");
        for (columna = 0; columna < caselles[0].length; columna++) {
            if (columna < 10) {
                System.out.print("  " + columna + "  ");
            } else {
                System.out.print("  " + columna + " ");
            }
        }
        System.out.println("   banderes -> [ " + banderes + " ]");

        for (int i = 0; i < caselles.length; i++) {
            if (fila < 10) {
                System.out.print("  " + fila + "  ");
            } else {
                System.out.print("  " + fila + " ");
            }
            fila++;
            for (int j = 0; j < caselles[0].length; j++) {
                if (caselles[i][j].isDestapada()) {
                    System.out.print("[ " + caselles[i][j].getValor() + " ]");
                } else if (caselles[i][j].isBandera()) {
                    System.out.print("[ B ]");
                } else {
                    System.out.print("[   ]");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public void displayMines() {
        int fila = 0;
        int columna = 0;

        System.out.print("     ");
        for (columna = 0; columna < caselles[0].length; columna++) {
            if (columna < 10) {
                System.out.print("  " + columna + "  ");
            } else {
                System.out.print("  " + columna + " ");
            }
        }
        System.out.println("   banderes -> [ " + banderes + " ]");

        for (int i = 0; i < caselles.length; i++) {
            if (fila < 10) {
                System.out.print("  " + fila + "  ");
            } else {
                System.out.print("  " + fila + " ");
            }
            fila++;
            for (int j = 0; j < caselles[0].length; j++) {
                if (caselles[i][j].isMina()) {
                    System.out.print("[ " + "M" + " ]");
                } else if (caselles[i][j].isDestapada()) {
                    System.out.print("[ " + caselles[i][j].getValor() + " ]");
                } else if (caselles[i][j].isBandera()) {
                    System.out.print("[ B ]");
                } else {
                    System.out.print("[   ]");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    private void assignarValorCaselles() { //ordre: esquerra, adalt, dreta, abaix i diagonals començant per adalt a l'esquerra
        for (int i = 0; i < caselles.length; i++) {
            for (int j = 0; j < caselles[0].length; j++) {
                if (i != 0 && caselles[i - 1][j].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (j != 0 && caselles[i][j - 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (i != caselles.length - 1 && caselles[i + 1][j].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (j != caselles[0].length - 1 && caselles[i][j + 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (i != 0 && j != 0 && caselles[i - 1][j - 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (i != caselles.length - 1 && j != 0 && caselles[i + 1][j - 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (i != caselles.length - 1 && j != caselles[0].length - 1 && caselles[i + 1][j + 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
                if (i != 0 && j != caselles[0].length - 1 && caselles[i - 1][j + 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
            }
        }
    }

    public void posarBandera(int fila, int columna) {
        if (!caselles[fila][columna].isDestapada() && !caselles[fila][columna].isBandera()) {
            caselles[fila][columna].setBandera(true);
            banderes--;
        }
    }

    public void llevarBandera(int fila, int columna) {
        if (caselles[fila][columna].isBandera()) {
            caselles[fila][columna].setBandera(false);
            banderes++;
        }
    }

    public void destaparCasella(int fila, int columna) throws ArrayIndexOutOfBoundsException, InputMismatchException {
        caselles[fila][columna].setDestapada(true);

        if (caselles[fila][columna].getValor() == 0 && !caselles[fila][columna].isMina()) {//ordre: esquerra, adalt, dreta, abaix i diagonals començant per adalt a l'esquerra
            if (fila != 0 && !caselles[fila - 1][columna].isDestapada()) {
                destaparCasella(fila - 1, columna);
            }
            if (columna != 0 && !caselles[fila][columna - 1].isDestapada()) {
                destaparCasella(fila, columna - 1);
            }
            if (fila != caselles.length - 1 && !caselles[fila + 1][columna].isDestapada()) {
                destaparCasella(fila + 1, columna);
            }
            if (columna != caselles[0].length - 1 && !caselles[fila][columna + 1].isDestapada()) {
                destaparCasella(fila, columna + 1);
            }
            if (fila != 0 && columna != 0 && !caselles[fila - 1][columna - 1].isDestapada()) {
                destaparCasella(fila - 1, columna - 1);
            }
            if (fila != caselles.length - 1 && columna != 0 && !caselles[fila + 1][columna - 1].isDestapada()) {
                destaparCasella(fila + 1, columna - 1);
            }
            if (fila != 0 && columna != caselles[0].length - 1 && !caselles[fila - 1][columna + 1].isDestapada()) {
                destaparCasella(fila - 1, columna + 1);
            }
            if (fila != caselles.length - 1 && columna != caselles[0].length - 1 && !caselles[fila + 1][columna + 1].isDestapada()) {
                destaparCasella(fila + 1, columna + 1);
            }
        }

        if(caselles[fila][columna].isBandera()){
            caselles[fila][columna].setBandera(false);
            banderes++;
        }
    }
}
