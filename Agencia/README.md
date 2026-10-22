GERAR DADOS DE TESTE 
  java GeradorCandidatos [N] [arquivoNomes] [arquivoSaida]
  Padrões: N = 200, arquivoNomes = nomes.txt, arquivoSaida = candidatos.txt

EXECUTAR
  java Main [arquivoCandidatos]
  Padrão: candidatos.txt

MENU
  1 - Definir/atualizar o grau de interesse mínimo (recalcula os pares)
  2 - Número e nomes dos potenciais companheiros de um candidato (por id)
  3 - K candidatos com maior número de potenciais companheiros
  4 - Candidatos sem nenhum potencial companheiro
  5 - Candidatos com interesse em uma área (1 a 8)
  6 - Candidatos que residem em um estado (sigla)
  0 - Sair

REGRAS DE PARES
  - Mesmo estado.
  - Opção sexual atendida nos dois sentidos (F, M ou I = indiferente).
  - Grau de interesse comum >= grau definido pelo usuário (grau inicial = 1).
  - Pesos das áreas: 1 (ESPORTES, MÚSICA, CINEMA); 2 (ARTES, ANIMAIS, GASTRONOMIA);
    3 (TECNOLOGIA, CIÊNCIAS).

ESTRUTURAS
  Todas as listas são simplesmente encadeadas com sentinela e tail (sem ArrayList/LinkedList):
  ListaAreaInteresses, ListaIdentificadores, ListaCandidatos.

ARQUIVOS
  Candidato, CelulaAreaInteresse, ListaAreaInteresses, CelulaIdentificador,
  ListaIdentificadores, ListaCandidatos, LeitorCandidatos, Aplicacao, Main,
  GeradorCandidatos, nomes.txt

  PROJETO
https://github.com/VitorSOliveira-eng/Agencia-de-Relacionamento
Vitor Silva de Oliveira & Mateus Carvalho Costa
