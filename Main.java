public class Main {
    public static void main(String[] args) {
        int[][] A = {
                {0, 5, 6, 2, 0, 0, 0, 0, 0},
                {5, 0, 2, 2, 5, 0, 0, 0, 0},
                {6, 2, 0, 3, 5, 6, 0, 7, 0},
                {2, 2, 3, 0, 6, 4, 1, 0, 11},
                {0, 5, 5, 6, 0, 0, 0, 6, 11},
                {0, 0, 6, 4, 0, 0, 1, 4, 0},
                {0, 0, 0, 1, 0, 1, 0, 7, 11},
                {0, 0, 7, 0, 6, 4, 7, 0, 3},
                {0, 0, 0, 11, 11, 0, 11, 3, 0}
        };
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        var dijkstra = new Dijkstra(A, letras);
        dijkstra.printCaminhoMinimo(1, 6);
        System.out.printf("***** Caminho minimo de %s ate os outros pontos ***** %n", letras[1]);
                dijkstra.printTodosOsCaminhos(1, 6);
    }
}