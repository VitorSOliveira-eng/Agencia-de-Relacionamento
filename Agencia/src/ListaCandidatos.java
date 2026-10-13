/**
 * TAD lista de candidatos (substitui ArrayList).
 * Lista simplesmente encadeada com sentinela e tail.
 */
public class ListaCandidatos {

    public static class Celula {
        private Candidato candidato;
        private Celula proximo;

        Celula() {
        }

        Celula(Candidato candidato) {
            this.candidato = candidato;
        }

        public Candidato getCandidato() {
            return candidato;
        }

        public Celula getProximo() {
            return proximo;
        }
    }

    private Celula primeiro; // sentinela
    private Celula ultimo;   // tail
    private int tamanho;

    public ListaCandidatos() {
        primeiro = new Celula();
        ultimo = primeiro;
        tamanho = 0;
    }

    public void inserir(Candidato c) {
        ultimo.proximo = new Celula(c);
        ultimo = ultimo.proximo;
        tamanho++;
    }

    public int tamanho() {
        return tamanho;
    }

    /** Primeira célula com dado (ou null se vazia), para percorrer a lista. */
    public Celula inicio() {
        return primeiro.proximo;
    }

    /** Retorna o candidato com o id informado, ou null se não existir. */
    public Candidato buscarPorId(int id) {
        Celula atual = primeiro.proximo;
        while (atual != null) {
            if (atual.candidato.getId() == id) {
                return atual.candidato;
            }
            atual = atual.proximo;
        }
        return null;
    }
}
