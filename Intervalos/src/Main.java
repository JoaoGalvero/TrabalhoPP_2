public class Main {
    public static void main(String[] args) {
        Intervalo intervalo1 = new Intervalo('[', 2, 4, ']'); // Intervalo [2, 4]
        Intervalo intervalo2 = new Intervalo('[', 3, 5, ')'); // Intervalo [3, 5]
        
        Intervalo intervalo3 = intervalo1.uniao(intervalo2);
        intervalo3.imprimeIntervalo();
    }
}
