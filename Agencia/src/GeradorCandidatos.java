import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeradorCandidatos {

    private static final String[] ESTADOS = {"MG", "SP", "RJ", "ES", "BA"};
    private static final String[] NOMES_PADRAO = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda"};

    public static void main(String[] args) throws IOException {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 200;
        String arqNomes = args.length > 1 ? args[1] : "nomes.txt";
        String arqSaida = args.length > 2 ? args[2] : "candidatos.txt";

        String[] nomes = lerNomes(arqNomes);
        Random rnd = new Random();

        PrintWriter pw = new PrintWriter(arqSaida);
        pw.println(n);
        for (int i = 0; i < n; i++) {
            pw.println("****");
            pw.println(nomes[rnd.nextInt(nomes.length)] + " " + nomes[rnd.nextInt(nomes.length)]);
            pw.println(ESTADOS[rnd.nextInt(ESTADOS.length)]);
            pw.println(rnd.nextBoolean() ? 'F' : 'M');

            int r = rnd.nextInt(10); 
            pw.println(r < 2 ? 'I' : (r < 6 ? 'F' : 'M'));

            
            int[] areas = {1, 2, 3, 4, 5, 6, 7, 8};
            for (int k = areas.length - 1; k > 0; k--) {
                int j = rnd.nextInt(k + 1);
                int tmp = areas[k];
                areas[k] = areas[j];
                areas[j] = tmp;
            }
            int qtd = 1 + rnd.nextInt(6);
            pw.println(qtd);
            for (int k = 0; k < qtd; k++) {
                pw.println(areas[k]);
            }
        }
        pw.close();
        System.out.println(n + " candidatos gravados em " + arqSaida);
    }

    private static String[] lerNomes(String caminho) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            int total = 0;
            String linha;
            String[] buffer = new String[16];
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }
                if (total == buffer.length) { // cresce o vetor manualmente
                    String[] maior = new String[buffer.length * 2];
                    for (int i = 0; i < total; i++) {
                        maior[i] = buffer[i];
                    }
                    buffer = maior;
                }
                buffer[total++] = linha;
            }
            br.close();
            if (total == 0) {
                return NOMES_PADRAO;
            }
            String[] nomes = new String[total];
            for (int i = 0; i < total; i++) {
                nomes[i] = buffer[i];
            }
            return nomes;
        } catch (IOException e) {
            System.out.println("Dicionário '" + caminho + "' não encontrado; usando nomes padrão.");
            return NOMES_PADRAO;
        }
    }
}
