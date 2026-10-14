/**
 * Lógica das 6 tarefas da agência, usando apenas as operações dos TADs.
 */
public class Aplicacao {

    private ListaCandidatos candidatos;
    private int grauMinimo;

    public Aplicacao(ListaCandidatos candidatos, int grauMinimoInicial) {
        this.candidatos = candidatos;
        this.grauMinimo = grauMinimoInicial;
        calcularPares();
    }

    public int getGrauMinimo() {
        return grauMinimo;
    }

    public int totalCandidatos() {
        return candidatos.tamanho();
    }

    private static String nomeArea(int codigo) {
        switch (codigo) {
            case 1: return "ESPORTES";
            case 2: return "ARTES";
            case 3: return "MÚSICA";
            case 4: return "CINEMA";
            case 5: return "TECNOLOGIA";
            case 6: return "ANIMAIS";
            case 7: return "GASTRONOMIA";
            case 8: return "CIÊNCIAS";
            default: return "DESCONHECIDA";
        }
    }

    // ---------------------------------------------------------------
    // Tarefa 1: inserir/atualizar o grau de interesse desejado
    // ---------------------------------------------------------------

    public void definirGrau(int novoGrau) {
        this.grauMinimo = novoGrau;
        calcularPares();
    }

    /** Recalcula a lista de potenciais companheiros de todos os candidatos. */
    private void calcularPares() {
        ListaCandidatos.Celula a = candidatos.inicio();
        while (a != null) {
            a.getCandidato().limparCompanheiros();
            a = a.getProximo();
        }
        a = candidatos.inicio();
        while (a != null) {
            Candidato u = a.getCandidato();
            ListaCandidatos.Celula b = candidatos.inicio();
            while (b != null) {
                Candidato v = b.getCandidato();
                if (Candidato.verificaPotencialCompanheiro(u, v, grauMinimo)) {
                    Candidato.inserePotencialCompanheiro(u, v);
                }
                b = b.getProximo();
            }
            a = a.getProximo();
        }
    }

    // ---------------------------------------------------------------
    // Tarefa 2: número e nomes dos potenciais companheiros de um candidato
    // ---------------------------------------------------------------

    public void imprimirCompanheiros(int id) {
        Candidato u = candidatos.buscarPorId(id);
        if (u == null) {
            System.out.println("Candidato com id " + id + " não encontrado.");
            return;
        }
        System.out.println("Candidato: " + u.getId() + " - " + u.getNome());
        System.out.println("Número de potenciais companheiros: " + Candidato.numeroCompanheiros(u));
        CelulaIdentificador c = Candidato.listaCompanheiros(u).inicio();
        while (c != null) {
            Candidato v = candidatos.buscarPorId(c.getId());
            System.out.println("  " + v.getId() + " - " + v.getNome());
            c = c.getProximo();
        }
    }

    // ---------------------------------------------------------------
    // Tarefa 3: K candidatos com maior número de potenciais companheiros
    // ---------------------------------------------------------------

    public void imprimirTopK(int k) {
        if (k <= 0) {
            System.out.println("K deve ser maior que zero.");
            return;
        }
        boolean[] usado = new boolean[candidatos.tamanho() + 2];
        int maxId = 0;
        for (int i = 0; i < k; i++) {
            Candidato melhor = null;
            ListaCandidatos.Celula a = candidatos.inicio();
            while (a != null) {
                Candidato c = a.getCandidato();
                if (c.getId() < usado.length && !usado[c.getId()]) {
                    if (melhor == null
                            || Candidato.numeroCompanheiros(c) > Candidato.numeroCompanheiros(melhor)) {
                        melhor = c;
                    }
                }
                a = a.getProximo();
            }
            if (melhor == null) {
                break; // acabaram os candidatos
            }
            usado[melhor.getId()] = true;
            System.out.println((i + 1) + "º: " + melhor.getId() + " - " + melhor.getNome()
                    + " (" + Candidato.numeroCompanheiros(melhor) + " companheiros)");
        }
    }

    // ---------------------------------------------------------------
    // Tarefa 4: candidatos sem nenhum companheiro
    // ---------------------------------------------------------------

    public void imprimirSemCompanheiros() {
        int total = 0;
        ListaCandidatos.Celula a = candidatos.inicio();
        while (a != null) {
            Candidato c = a.getCandidato();
            if (Candidato.numeroCompanheiros(c) == 0) {
                System.out.println(c.getId() + " - " + c.getNome());
                total++;
            }
            a = a.getProximo();
        }
        System.out.println("Total sem companheiros: " + total);
    }

    // ---------------------------------------------------------------
    // Tarefa 5: candidatos com interesse em uma área
    // ---------------------------------------------------------------

    public void imprimirPorArea(int codigoArea) {
        if (codigoArea < 1 || codigoArea > 8) {
            System.out.println("Área inválida (use 1 a 8).");
            return;
        }
        System.out.println("Candidatos com interesse em " + nomeArea(codigoArea) + ":");
        int total = 0;
        ListaCandidatos.Celula a = candidatos.inicio();
        while (a != null) {
            Candidato c = a.getCandidato();
            if (c.temInteresse(codigoArea)) {
                System.out.println(c.getId() + " - " + c.getNome());
                total++;
            }
            a = a.getProximo();
        }
        System.out.println("Total: " + total);
    }

    // ---------------------------------------------------------------
    // Tarefa 6: candidatos que residem em um estado
    // ---------------------------------------------------------------

    public void imprimirPorEstado(String sigla) {
        System.out.println("Candidatos que residem em " + sigla.toUpperCase() + ":");
        int total = 0;
        ListaCandidatos.Celula a = candidatos.inicio();
        while (a != null) {
            Candidato c = a.getCandidato();
            if (c.reside(sigla)) {
                System.out.println(c.getId() + " - " + c.getNome());
                total++;
            }
            a = a.getProximo();
        }
        System.out.println("Total: " + total);
    }
}
