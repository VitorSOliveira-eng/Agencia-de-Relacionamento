
import java.util.List;

public class Candidato {

    // Identificador interno
    private int id;

    // Dados do candidato
    private String nome;
    private String estado;
    private char sexo;
    private char sexoCompanheiro;

    // Áreas de interesse
    
    public Candidato(int id) {
        this.id = id;
        this.areas = new ListaAreaInteresses();
        this.companheiros = new ListaIdentificadores();
    }

    public Candidato(int id, String nome, String estado, char sexo, char sexoCompanheiro) {
        this(id);
        atualizar(nome, estado, sexo, sexoCompanheiro);
    }

    public void atualizar(String nome, String estado, char sexo, char sexoCompanheiro) {
        this.nome = nome;
        this.estado = estado;
        this.sexo = Character.toUpperCase(sexo);
        this.sexoCompanheiro = Character.toUpperCase(sexoCompanheiro);
    }
    public void adicionarArea(int codigoArea) {
        if (codigoArea < 1 || codigoArea > 8) {
            return;
        }
        if (!areas.contem(codigoArea)) {
            areas.inserir(codigoArea);
        }
    }

  
    public static int pesoArea(int codigoArea) {
        switch (codigoArea) {
            case 1:
            case 3:
            case 4:
                return 1;
            case 2:
            case 6:
            case 7:
                return 2;
            default:
                return 3;
        }
    }

    public static int grauInteresseComum(Candidato u, Candidato v) {
        int grau = 0;
        CelulaAreaInteresse atual = u.areas.inicio();
        while (atual != null) {
            if (v.temInteresse(atual.codigoArea)) {
                grau += pesoArea(atual.codigoArea);
            }
            atual = atual.proximo;
        }
        return grau;
    }
    
    
    
    
    // IDs dos potenciais companheiros


   
    // Getters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public char getSexo() {
        return sexo;
    }

    public char getSexoCompanheiro() {
        return sexoCompanheiro;
    }



 

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Estado: " + estado +
               " | Sexo: " + sexo;
    }
}
