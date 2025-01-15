public class Intervalo {
    // Atributos
    private int inicio;
    private int fim;
    private boolean chaveInicio; //[ == true e ( == false
    private boolean chaveFim; //] == true e ) == false
    private int[] valoresIntervalo;

    // Construtor
    public Intervalo(char chave1, int inicio, int fim, char chave2) {
        this.setInicio(inicio);
        this.setFim(fim);
        this.setInicioInclusivo(verifica(chave1));
        this.setFimInclusivo(verifica(chave2));
        this.setValoresIntervalo(primeiroValorIntervalo(), ultimoValorIntervalo(), totalValores());
    }

    // Getters
    public int getInicio() {
        return this.inicio;
    }

    public int getFim() {
        return this.fim;
    }

    public boolean getChaveInicio() {
        return this.chaveInicio;
    }

    public boolean getChaveFim() {
        return this.chaveFim;
    }

    public int[] getvaloresIntervalo(){
        return this.valoresIntervalo;
    }

    // Setters
    public void setInicio(int inicio) {
            this.inicio = inicio;
    }

    public void setFim(int fim) {
            this.fim = fim;
    }

    public void setInicioInclusivo(boolean ver) {
        this.chaveInicio = ver;
    }

    public void setFimInclusivo(boolean ver) {
        this.chaveFim = ver;
    }

    public void setValoresIntervalo(int primeiro, int ultimo, int total) {
        int[] v = new int[total];
        for (int i = 0; i < total; i++) {
            v[i] = primeiro + i;
        }
        this.valoresIntervalo = v;
    }
    

    // Métodos Personalizados (Pedidos na implementação do trabalho)

    // (a)
    public boolean contém(int valor) {
        return ((this.inicio < valor && valor < this.fim) || 
               (this.chaveInicio && valor == this.inicio) || 
               (this.chaveFim && valor == this.fim));
    }
    
   // (b)
    public boolean intercepta(Intervalo outro) {
        int inicioAtual = this.primeiroValorIntervalo();
        int fimAtual = this.ultimoValorIntervalo();

        int inicioOutro = outro.primeiroValorIntervalo();
        int fimOutro = outro.ultimoValorIntervalo();

        return !(fimAtual < inicioOutro || fimOutro < inicioAtual);
    }

    //Métodos Personalizados (Criados para facilitar algum processo do meu programa)

    //Função que verifica as chaves
    private boolean verifica(char chave){
        if (chave == '[' || chave == ']'){
            return true;
        }
        else if (chave == '(' || chave == ')'){
            return false;
        }
        else{
            System.out.println("Não obedece os critérios das notações de intervalo. Por padrão, será usado (x, y)");
            return false;
        }
    }

    //Função que retorna o primeiro inteiro incluído no intervalo
    private int primeiroValorIntervalo(){
        if(getChaveInicio()){
            return this.inicio;
        }
        else{
            return (this.inicio+1);
        }
    }

    //Função que retorna o último inteiro incluído no intervalo
    private int ultimoValorIntervalo(){
        if(getChaveFim()){
            return this.fim;
        }
        else{
            return (this.fim-1);
        }
    }

    //Função que retorna o total de inteiros incluídos no intervalo
    private int totalValores(){
        return (ultimoValorIntervalo() - primeiroValorIntervalo() + 1);
    }

    //Função que imprime os inteiros incluídos no intervalo
    public void imprimeIntervalo(){
        int[] v = getvaloresIntervalo();
        int total = totalValores();
        int i = 0;
        System.out.print("[");
        while(i < total){
            if(i != total-1){
                System.out.print(v[i] + ", ");
                i++;
            }
            else{
            System.out.print(v[i]);
            i++;
            }
        }
        System.out.print("]");
    }
}
