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
    public boolean intercepta(Intervalo b) {
        int inicioA = this.primeiroValorIntervalo();
        int fimA = this.ultimoValorIntervalo();

        int inicioB = b.primeiroValorIntervalo();
        int fimB = b.ultimoValorIntervalo();

        return !(fimA < inicioB || fimB < inicioA);
    }

    // (c)
    public int media(){
        int media = 0;
        for(int i = 0; i < totalValores(); i++){
            media += valoresIntervalo[i];
        }
        return (media/totalValores());
    }

    // (d)
    public Intervalo produto(Intervalo b) {
        int infa = this.primeiroValorIntervalo();
        int supa = this.ultimoValorIntervalo();
        int infb = b.primeiroValorIntervalo();
        int supb = b.ultimoValorIntervalo();

        int p1 = infa * infb;
        int p2 = infa * supb;
        int p3 = supa * infb;
        int p4 = supa * supb;

        int novoLimiteInferior = min(min(p1, p2), min(p3, p4));
        int novoLimiteSuperior = max(max(p1, p2), max(p3, p4));

        return new Intervalo('[', novoLimiteInferior, novoLimiteSuperior, ']');
    }

    // (e)
    public Intervalo uniao(Intervalo b) {
        Intervalo c = new Intervalo('(', 1, 2 ,')');
        if (this.intercepta(b)){
            int primeiroValor = this.primeiroValorIntervalo() <= b.primeiroValorIntervalo()? this.primeiroValorIntervalo() : b.primeiroValorIntervalo();
            int ultimoValor = this.ultimoValorIntervalo() >= b.ultimoValorIntervalo()? this.ultimoValorIntervalo() : b.ultimoValorIntervalo();
            boolean chaveInicio = primeiroValor == this.primeiroValorIntervalo()? this.chaveInicio : b.chaveInicio;
            boolean chaveFim = ultimoValor == this.ultimoValorIntervalo()? this.chaveFim : b.chaveFim;

            c.setInicio(primeiroValor);
            c.setFim(ultimoValor);
            c.setInicioInclusivo(chaveInicio);
            c.setFimInclusivo(chaveFim);
            c.setValoresIntervalo(primeiroValor, ultimoValor, totalValores());
            return c;
        }
        else{
            return c;
        }
    }
    
    

    //Métodos Personalizados (Criados para facilitar algum processo do meu programa)

    //Método que verifica as chaves
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

    //Método que retorna o primeiro inteiro incluído no intervalo
    private int primeiroValorIntervalo(){
        if(getChaveInicio()){
            return this.inicio;
        }
        else{
            return (this.inicio+1);
        }
    }

    //Método que retorna o último inteiro incluído no intervalo
    private int ultimoValorIntervalo(){
        if(getChaveFim()){
            return this.fim;
        }
        else{
            return (this.fim-1);
        }
    }

    //Método que retorna o total de inteiros incluídos no intervalo
    private int totalValores(){
        return (ultimoValorIntervalo() - primeiroValorIntervalo() + 1);
    }

    //Método que imprime os inteiros incluídos no intervalo
    public void imprimeIntervalo(){
        int total = totalValores();
        int i = 0;
        System.out.print("[");
        while(i < total){
            if(i != total-1){
                System.out.print(valoresIntervalo[i] + ", ");
                i++;
            }
            else{
            System.out.print(valoresIntervalo[i] + "]");
            i++;
            }
        }
    }

    // Método para encontrar o menor valor entre dois números
    private int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // Método para encontrar o maior valor entre dois números
    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
