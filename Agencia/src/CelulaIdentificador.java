public class CelulaIdentificador {
    private int id;
    CelulaIdentificador proximo;

    public CelulaIdentificador() {
        this.proximo = null;
    }

    public CelulaIdentificador(int id) {
        this.id = id;
        this.proximo = null;
    }

    public int getId() {
        return id;
    }

    public CelulaIdentificador getProximo() {
        return proximo;
    }
}
