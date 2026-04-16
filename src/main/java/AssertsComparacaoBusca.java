public class AssertsComparacaoBusca {

    private static final ComparacaoBusca comp = new ComparacaoBusca();
    private static final int[] v = new int[] {1, 4, 5, 6, 7, 8, 23, 45, 67, 89};

    public static void main(String[] args) {
        ensureAssertionsEnabled();
        testLimitesIterativa();
        testLimitesIterativaNaoEncontrou();
        testLimitesRecursiva();
        testLimitesRecursivaNaoEncontrou();
        System.out.println("AssertsComparacaoBusca executado.");
    }

    private static void ensureAssertionsEnabled() {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (!assertionsEnabled) {
            throw new IllegalStateException("Execute com -ea para habilitar assertions.");
        }
    }

    public static void testLimitesIterativa() {
        assert comp.buscaBinariaIterativa(v, 1) == 0 : "Iterativa deve encontrar 1 no índice 0";
        assert comp.buscaBinariaIterativa(v, 89) == v.length - 1 : "Iterativa deve encontrar 89 no último índice";
    }

    public static void testLimitesIterativaNaoEncontrou() {
        assert comp.buscaBinariaIterativa(v, -9000) == -1 : "Iterativa deve retornar -1 para valor menor que o mínimo";
        assert comp.buscaBinariaIterativa(v, 90000) == -1 : "Iterativa deve retornar -1 para valor maior que o máximo";
    }

    public static void testLimitesRecursiva() {
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, 1) == 0 : "Recursiva deve encontrar 1 no índice 0";
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, 89) == v.length - 1 : "Recursiva deve encontrar 89 no último índice";
    }

    public static void testLimitesRecursivaNaoEncontrou() {
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, -9000) == -1 : "Recursiva deve retornar -1 para valor menor que o mínimo";
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, 90000) == -1 : "Recursiva deve retornar -1 para valor maior que o máximo";
    }
}
