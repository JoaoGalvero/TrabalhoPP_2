public class Intervalo {
    // Atributos
    private int inicio;
    private int fim;
    private boolean chaveInicio; //[ == true e ( == false
    private boolean chaveFim; //] == true e ) == false
    private int[] valoresIntervalo;
    private int totalValoresCache; // Cache para o total de valores

    // Construtor
    public Intervalo(char chave1, int inicio, int fim, char chave2) {
        this.setInicio(inicio);
        this.setFim(fim);
        this.setInicioInclusivo(verifica(chave1));
        this.setFimInclusivo(verifica(chave2));
        this.setTotalValoresCache((ultimoValorIntervalo() - primeiroValorIntervalo() + 1));
        this.setValoresIntervalo(primeiroValorIntervalo(), ultimoValorIntervalo(), getTotalValoresCache());
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

    public int[] getValoresIntervalo() {
        return this.valoresIntervalo;
    }

    public int getTotalValoresCache() {
        return totalValoresCache;
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
        if (total <= 0) {
            this.valoresIntervalo = null;
        } else {
            int[] array = new int[total];
            for (int i = 0; i < total; i++) {
                array[i] = primeiro + i;
            }
            this.valoresIntervalo = array;
        }
    }

    public void setTotalValoresCache(int totalValoresCache) {
        this.totalValoresCache = totalValoresCache;
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
    public double media() {
        double media = 0;
        for (int i = 0; i < totalValoresCache; i++) {
            media += valoresIntervalo[i];
        }
        return (media / totalValoresCache);
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

        int novoLimiteInferior = Math.min(Math.min(p1, p2), Math.min(p3, p4));
        int novoLimiteSuperior = Math.max(Math.max(p1, p2), Math.max(p3, p4));

        return new Intervalo('[', novoLimiteInferior, novoLimiteSuperior, ']');
    }

    // (e)
    public Intervalo uniao(Intervalo b) {
        if (this.intercepta(b)) {
            int primeiroValor = this.primeiroValorIntervalo() <= b.primeiroValorIntervalo() ? this.inicio : b.inicio;
            int ultimoValor = this.ultimoValorIntervalo() >= b.ultimoValorIntervalo() ? this.fim : b.fim;
            boolean chaveInicio = primeiroValor == this.inicio ? this.chaveInicio : b.chaveInicio;
            boolean chaveFim = ultimoValor == this.fim ? this.chaveFim : b.chaveFim;

            Intervalo c = new Intervalo((chaveInicio? '[' : '('), primeiroValor, ultimoValor , (chaveFim? ']' : ')'));

            System.out.print("União: ");
            c.imprimeRep();
            return c;
        } else {
            System.out.print("União (sem interseção): ");
            this.imprimeRep();
            System.out.print("+");
            b.imprimeRep();
            return new Intervalo('(', 0, 0 ,')');
        }
    }

    // Métodos Personalizados (Criados para facilitar algum processo do meu programa)

    // Método que verifica as chaves
    private boolean verifica(char chave) {
        if (chave == '[' || chave == ']') {
            return true;
        } else if (chave == '(' || chave == ')') {
            return false;
        } else {
            System.out.println("Não obedece os critérios das notações de intervalo. Por padrão, será usado (x, y)");
            return false;
        }
    }

    // Método que retorna o primeiro inteiro incluído no intervalo
    private int primeiroValorIntervalo() {
        if (getChaveInicio()) {
            return this.inicio;
        } else {
            return (this.inicio + 1);
        }
    }

    // Método que retorna o último inteiro incluído no intervalo
    private int ultimoValorIntervalo() {
        if (getChaveFim()) {
            return this.fim;
        } else {
            return (this.fim - 1);
        }
    }

    // Método que imprime os inteiros incluídos no intervalo
    public void imprimeIntervalo() {
        if (this.valoresIntervalo == null || this.getTotalValoresCache() == 0) {
            System.out.println("\nIntervalo vazio");
        } else {
            int total = this.getTotalValoresCache();
            int i = 0;
            System.out.print("\n[");
            while (i < total) {
                if (i != total - 1) {
                    System.out.print(valoresIntervalo[i] + ", ");
                    i++;
                } else {
                    System.out.print(valoresIntervalo[i] + "] ");
                    i++;
                }
            }
        }
    }

    // Método que imprime a representação do intervalo
    public void imprimeRep() {
        System.out.print(this.getChaveInicio() ? "[" : "(");
        System.out.print(this.getInicio());
        System.out.print(", ");
        System.out.print(this.getFim());
        System.out.print(this.getChaveFim() ? "]" : ")");
    }
}
