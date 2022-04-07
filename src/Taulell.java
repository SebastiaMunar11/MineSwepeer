public class Taulell {

    private Casella[][] caselles;
    private int mines;

    public Taulell(String dificultat) {
        switch (dificultat) {
            case "dificil" -> {
                caselles = new Casella[16][32];
                mines = 99;
            }
            case "intermig" -> {
                caselles = new Casella[16][16];
                mines = 40;
            }
            case "facil" -> {
                caselles = new Casella[8][8];
                mines = 10;
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
        for (int i = 0; i < caselles[0].length; i++) {
            for (int j = 0; j < caselles.length; j++) {
                if (j == caselles.length - 1) {
                    System.out.print("+---+\n");
                } else {
                    System.out.print("+---");
                }
            }
            for (int j = 0; j < caselles.length; j++) {

                caselles[0][0].setBandera(true);
                caselles[1][0].setBandera(true);
                caselles[0][1].setBandera(true);

                if (caselles[i][j].isDestapada()) {
                    if (j == caselles.length - 1) {
                        System.out.print(" | " + caselles[i][j].getValor() + " |\n");
                    } else if (j == 0) {
                        System.out.print("| " + caselles[i][j].getValor());
                    } else {
                        System.out.print(" | " + caselles[i][j].getValor());
                    }
                } else if (caselles[i][j].isBandera()) {
                    if (j == caselles.length - 1) {
                        System.out.print(" |" + " B " + "|\n");
                    } else if (j == 0) {
                        System.out.print("|" + " B ");
                    } else {
                        System.out.print("|" + " B ");
                    }
                } else {
                    if (j == caselles.length - 1) {
                        System.out.print("|" + "[ ]" + "|\n");
                    } else if (j == 0) {
                        System.out.print("|" + "[ ]");
                    } else {
                        System.out.print("|" + "[ ]");
                    }
                }
            }

            if (i == caselles[0].length - 1) { //Darrera línea d'abaix
                for (int j = 0; j < caselles.length; j++) {
                    if (j == caselles.length - 1) {
                        System.out.print("+---+\n");
                    } else {
                        System.out.print("+---");
                    }
                }
            }
        }

        System.out.println("\n\n\n");
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
                if (i != 0 && j != caselles[0].length - 1  && caselles[i - 1][j + 1].isMina()) {
                    caselles[i][j].setValor(caselles[i][j].getValor() + 1);
                }
            }
        }
    }
}
