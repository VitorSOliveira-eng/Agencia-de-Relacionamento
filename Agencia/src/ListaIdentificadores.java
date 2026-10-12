/**
 * TAD lista de identificadores de potenciais companheiros.
 * Lista simplesmente encadeada com sentinela e tail.
 */
public class ListaIdentificadores {
    private CelulaIdentificador primeiro; // sentinela
    private CelulaIdentificador ultimo;   // tail
    private int tamanho;

    public ListaIdentificadores() {
        primeiro = new CelulaIdentificador();
        ultimo = primeiro;
        tamanho = 0;
    }

    public void inserir(int id) {
        ultimo.proximo = new CelulaIdentificador(id);
        ultimo = ultimo.proximo;
        tamanho++;
    }

    public boolean contem(int id) {
        CelulaIdentificador atual = primeiro.proximo;
        while (atual != null) {
            if (atual.getId() == id) {
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

    public void limpar() {
        primeiro.proximo = null;
        ultimo = primeiro;
        tamanho = 0;
    }

    /** Primeira célula com dado (ou null se vazia), para percorrer a lista. */
    public CelulaIdentificador inicio() {
        return primeiro.proximo;
    }
}
