
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
