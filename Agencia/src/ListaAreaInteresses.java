public class ListaAreaInteresses {
    private CelulaAreaInteresse primeiro;
    private CelulaAreaInteresse ultimo;

    public ListaAreaInteresses() {
        primeiro = new CelulaAreaInteresse();
        ultimo = primeiro;
    }

    public void inserir(int codigoArea) {
        ultimo.proximo = new CelulaAreaInteresse(codigoArea);
        ultimo = ultimo.proximo;
    }

}
