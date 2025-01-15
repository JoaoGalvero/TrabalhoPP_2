public class Intervalo {
    private int inicio;
    private int fim;
    private boolean inicioInclusivo;
    private boolean fimInclusivo;

    // Construtor
    public Intervalo(char inicioSimbolo, int inicio, int fim, char fimSimbolo) {
        if (inicioSimbolo == '[') { //VERIFICAÇÃO DO ( ou [ DO ÍNICIO
            this.inicioInclusivo = true;
        } else if (inicioSimbolo == '(') {
            this.inicioInclusivo = false;
        } else {
            System.out.println("Símbolo de início inválido. Use '[' ou '('");
        }

        if (fimSimbolo == ']') { //VERIFICAÇÃO DO ) ou ] DO FIM
            this.fimInclusivo = true;
        } else if (fimSimbolo == ')') {
            this.fimInclusivo = false;
        } else {
            System.out.println("Símbolo de fim inválido. Use ']' ou ')'");
        }

        if (inicio > fim) { //VERIFICAÇÃO SE INÍCIO MAIOR FIM
            System.out.println("O valor de início não pode ser maior que o valor de fim.");
        }
        else {
        this.inicio = inicio;
        this.fim = fim;
        }
    }

    // Getters
    public int getInicio() {
        return this.inicio;
    }

    public int getFim() {
        return this.fim;
    }

    public boolean isInicioInclusivo() {
        return this.inicioInclusivo;
    }

    public boolean isFimInclusivo() {
        return this.fimInclusivo;
    }

    // Setters
    public void setInicio(int inicio) {
        if (inicio > this.fim) {
            System.out.println("O valor de início não pode ser maior que o valor de fim.");
        } else {
            this.inicio = inicio;
        }
    }

    public void setFim(int fim) {
        if (fim < this.inicio) {
            System.out.println("O valor de fim não pode ser menor que o valor de início.");
        } else {
            this.fim = fim;
        }
    }

    public void setInicioInclusivo(char inicioSimbolo) {
        if (inicioSimbolo == '[') {
            this.inicioInclusivo = true;
        } else if (inicioSimbolo == '(') {
            this.inicioInclusivo = false;
        } else {
            System.out.println("Símbolo de início inválido. Use '[' ou '('");
        }
    }

    public void setFimInclusivo(char fimSimbolo) {
        if (fimSimbolo == ']') {
            this.fimInclusivo = true;
        } else if (fimSimbolo == ')') {
            this.fimInclusivo = false;
        } else {
            System.out.println("Símbolo de fim inválido. Use ']' ou ')'");
        }
    }

    //Métodos Personalizados
    public boolean contém(int valor){
        if(this.inicio < valor && valor < this.fim){
            return true;
        }
        else {
            if( ((this.inicioInclusivo == true) && (valor == this.inicio)) || ((this.fimInclusivo == true) && (valor == fim)) ){
                return true;
            }
            else{
            return false;
            }
        }
    }
}
