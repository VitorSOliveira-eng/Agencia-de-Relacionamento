import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String arquivo = args.length > 0 ? args[0] : "candidatos.txt";

        ListaCandidatos candidatos;
        try {
            candidatos = LeitorCandidatos.ler(arquivo);
        } catch (IOException e) {
            System.out.println("Não foi possível ler '" + arquivo + "'. "
                    + "Execute antes: java GeradorCandidatos");
            return;
        }

        Aplicacao app = new Aplicacao(candidatos, 1);
        Scanner in = new Scanner(System.in);
        System.out.println(app.totalCandidatos() + " candidatos carregados.");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println();
            System.out.println("===== AGÊNCIA DE RELACIONAMENTO =====");
            System.out.println("1 - Definir grau de interesse (atual: " + app.getGrauMinimo() + ")");
            System.out.println("2 - Listar potenciais companheiros de um candidato");
            System.out.println("3 - K candidatos com mais potenciais companheiros");
            System.out.println("4 - Candidatos sem nenhum companheiro");
            System.out.println("5 - Candidatos com interesse em uma área");
            System.out.println("6 - Candidatos que residem em um estado");
            System.out.println("0 - Sair");
            opcao = lerInt(in, "Escolha: ");

            switch (opcao) {
                case 1:
                    app.definirGrau(lerInt(in, "Novo grau de interesse (ex: 6): "));
                    System.out.println("Grau atualizado e pares recalculados.");
                    break;
                case 2:
                    app.imprimirCompanheiros(lerInt(in, "Id do candidato: "));
                    break;
                case 3:
                    app.imprimirTopK(lerInt(in, "Valor de K: "));
                    break;
                case 4:
                    app.imprimirSemCompanheiros();
                    break;
                case 5:
                    System.out.println("1 ESPORTES, 2 ARTES, 3 MÚSICA, 4 CINEMA, "
                            + "5 TECNOLOGIA, 6 ANIMAIS, 7 GASTRONOMIA, 8 CIÊNCIAS");
                    app.imprimirPorArea(lerInt(in, "Código da área: "));
                    break;
                case 6:
                    System.out.print("Sigla do estado: ");
                    app.imprimirPorEstado(in.nextLine().trim());
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        in.close();
    }

    
    private static int lerInt(Scanner in, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (!in.hasNextLine()) {
                return 0; 
            }
            String linha = in.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
            }
        }
    }
}
