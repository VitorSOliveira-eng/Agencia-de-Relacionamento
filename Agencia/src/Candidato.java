
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