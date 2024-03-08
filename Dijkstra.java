public class Dijkstra {
    private int[][] matrizAdjacencia;
    private String[] vertices;

    public Dijkstra(int[][] matrizAdjacencia, String[] vertices) {
        this.matrizAdjacencia = matrizAdjacencia;
        this.vertices = vertices;
    }

    private Tuple<int[], Integer> caminhoMinimo(int pontoInicial, int pontoFinal) {
        var n = matrizAdjacencia.length;
        var caminhoEncontrado = false;
        int[] listaCustos = new int[n];
        int[] listaCaminho = new int[n];
        boolean[] listaResolvidos = new boolean[n];
        for (var i = 0; i < n; i++) {
            listaCustos[i] = Integer.MAX_VALUE;
            listaCaminho[i] = 0;
            listaResolvidos[i] = false;
        }
        listaCustos[pontoInicial] = 0;
        listaResolvidos[pontoInicial] = true;
        var aux_j = 0;
        int pontosResolvidos;
        while (!caminhoEncontrado) {
            var custo = Integer.MAX_VALUE;
            pontosResolvidos = 0;
            for (var i = 0; i < n; i++) {
                if (listaResolvidos[i]) {
                    pontosResolvidos++;
                    for (var j = 0; j < n; j++) {
                        if (matrizAdjacencia[i][j] > 0 && !listaResolvidos[j]) {
                            if (listaCustos[i] + matrizAdjacencia[i][j] < listaCustos[j]) {
                                listaCustos[j] = listaCustos[i] + matrizAdjacencia[i][j];
                            }
                            listaCaminho[j] = i;

                            if (listaCustos[j] < custo) {
                                custo = listaCustos[j];
                                aux_j = j;
                            }
                        }
                    }
                }
            }
            listaResolvidos[aux_j] = true;
            caminhoEncontrado = (pontosResolvidos == n - 1);
        }
        return new Tuple<>(listaCaminho, listaCustos[pontoFinal]);

    }

    public void printCaminhoMinimo(int pontoInicial, int pontoFinal) {
        if (pontoInicial == pontoFinal) {
            System.out.println("Vértices coincidentes       (Comp.: 0)");
        }
        System.out.printf("Ponto inicial.: %s%n", vertices[pontoInicial]);
        System.out.printf("Ponto final...: %s%n", vertices[pontoFinal]);
        System.out.println(buildStringPara(pontoInicial, pontoFinal));
    }

    public void printTodosOsCaminhos(int pontoInicial, int pontoFinal) {
        for (int i = 0; i < this.vertices.length; i++) {
            if (i != pontoInicial && i != pontoFinal) {
                System.out.println(buildStringPara(pontoInicial, i));
            }
        }
    }

    private String buildStringPara(int p1, int p2) {
        var resultado = caminhoMinimo(p1, p2);
        var bd = new StringBuilder();
        var i = p2;
        bd.append(vertices[i]);
        while (i != p1) {
            i = resultado.element1[i];
            bd.insert(0, vertices[i] + " > ");
        }
        int maxWidth = 25;
        String caminhoStr = bd.toString();
        String caminhoFormatado = String.format("%-" + maxWidth + "s", caminhoStr);
        return "Menor caminho: " + caminhoFormatado + "(Comp.: %d)".formatted(resultado.element2);
    }
}

