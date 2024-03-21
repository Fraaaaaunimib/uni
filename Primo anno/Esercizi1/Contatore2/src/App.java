public class App {
    public static void main(String[] args) throws Exception {
        
    }
}

class Contatore{
    private int conta;

   public void azzera(){
        this.conta = 0;
    }

    public void aumenta(){
        if (this.conta > 0)
        this.conta++;
    }

    public void togli(){
        if (this.conta > 0)
        this.conta--;
    }

    public int getConta(){
        return this.conta;
    }
}
