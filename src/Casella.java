public class Casella {

    private boolean bandera;
    private boolean mina;
    private boolean destapada;
    private int valor = 0;

    public Casella() {
    }

    public boolean isBandera() {
        return bandera;
    }

    public boolean isMina() {
        return mina;
    }

    public boolean isDestapada() {
        return destapada;
    }

    public int getValor() {
        return valor;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public void setDestapada(boolean destapada) {
        this.destapada = destapada;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
