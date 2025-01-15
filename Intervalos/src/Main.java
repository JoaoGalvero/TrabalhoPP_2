public class Main {
    public static void main(String[] args){
        Intervalo a = new Intervalo('(', 4, 8, ')');
        Intervalo b = new Intervalo('[', 3, 7, ')');
        if(a.intercepta(b)){
            System.out.println("Intercepta");
        }
        else{
            System.out.println("Não intercepta");
        }
    }
}
