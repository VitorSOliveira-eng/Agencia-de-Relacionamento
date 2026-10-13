import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lê o arquivo candidatos.txt no formato:
 *   N
 *   ****
 *   nome / sigla_estado / sexo / sexo_interesse / numero_areas / area_1 ... area_n
 *   ****
 *   ...
 * Os ids são atribuídos sequencialmente a partir de 1.
 */
public class LeitorCandidatos {

    public static ListaCandidatos ler(String caminho) throws IOException {
        ListaCandidatos lista = new ListaCandidatos();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        try {
            String linha = proximaLinha(br);
            if (linha == null) {
                return lista;
            }
            int n = Integer.parseInt(linha.split("\\s+")[0]);

            for (int i = 1; i <= n; i++) {
                String nome = proximaLinha(br);
                if (nome == null) {
                    break;
                }
                if (nome.equals("****")) { // separador
                    nome = proximaLinha(br);
                    if (nome == null) {
                        break;
                    }
                }
                String estado = proximaLinha(br);
                char sexo = proximaLinha(br).charAt(0);
                char sexoInteresse = proximaLinha(br).charAt(0);
                int numAreas = Integer.parseInt(proximaLinha(br));

                Candidato c = new Candidato(i, nome, estado, sexo, sexoInteresse);
                for (int j = 0; j < numAreas; j++) {
                    c.adicionarArea(Integer.parseInt(proximaLinha(br)));
                }
                lista.inserir(c);
            }
        } finally {
            br.close();
        }
        return lista;
    }

    /** Próxima linha não vazia (sem espaços nas pontas), ou null no fim do arquivo. */
    private static String proximaLinha(BufferedReader br) throws IOException {
        String linha = br.readLine();
        while (linha != null && linha.trim().isEmpty()) {
            linha = br.readLine();
        }
        return linha == null ? null : linha.trim();
    }
}
