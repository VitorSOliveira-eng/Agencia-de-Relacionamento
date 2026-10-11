public class ListaAreaInteresses {
    private CelulaAreaInteresse primeiro;
    private CelulaAreaInteresse ultimo;

    public ListaAreaInteresses() {
        primeiro = new CelulaAreaInteresse();
        ultimo = primeiro;
        tamanho = 0;
    }

    public void inserir(int codigoArea) {
        ultimo.proximo = new CelulaAreaInteresse(codigoArea);
        ultimo = ultimo.proximo;
        tamanho++;
    }

    public boolean contem(int codigoArea) {
        CelulaAreaInteresse atual = primeiro.proximo;
        while (atual != null) {
            if (atual.codigoArea == codigoArea) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
    
    
    public int tamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public CelulaAreaInteresse inicio() {
        return primeiro.proximo;
    }
}
