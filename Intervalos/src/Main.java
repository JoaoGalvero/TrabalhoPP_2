public class Main {
    public static void main(String[] args) {
        // Testando o primeiro intervalo [5, 10]
        Intervalo intervalo1 = new Intervalo('[', 5, 10, ']');
        System.out.print("Intervalo 1: ");
        intervalo1.imprimeRep();  // Verificando a representação
        intervalo1.imprimeIntervalo();  // Imprimindo os valores do intervalo
        System.out.println("\nMédia do Intervalo 1: " + intervalo1.media());  // Testando média

        // Testando o segundo intervalo (8, 15)
        Intervalo intervalo2 = new Intervalo('(', 8, 15, ')');
        System.out.print("\nIntervalo 2: ");
        intervalo2.imprimeRep();  // Verificando a representação
        intervalo2.imprimeIntervalo();  // Imprimindo os valores do intervalo
        System.out.println("\nMédia do Intervalo 2: " + intervalo2.media());  // Testando média

        // Testando o método contém
        System.out.println("\nIntervalo 1 contém 5? " + intervalo1.contém(5));  // Esperado: true
        System.out.println("Intervalo 2 contém 15? " + intervalo2.contém(15));  // Esperado: false

        // Testando a interceptação entre Intervalo 1 e Intervalo 2
        System.out.println("\nOs Intervalos 1 e 2 se interceptam? " + intervalo1.intercepta(intervalo2) + "\n");  // Esperado: true

        // Testando a união entre Intervalo 1 e Intervalo 2
        Intervalo uniao = intervalo1.uniao(intervalo2);
        System.out.print("\nResultado da União de Intervalo 1 e Intervalo 2: ");
        uniao.imprimeIntervalo();
        System.out.println();

        // Testando o produto entre Intervalo 1 e Intervalo 2
        Intervalo produto = intervalo1.produto(intervalo2);
        System.out.print("\nResultado do Produto dos Intervalo 1 e Intervalo 2: ");
        produto.imprimeRep();
        produto.imprimeIntervalo();
        System.out.println();
    }
}
