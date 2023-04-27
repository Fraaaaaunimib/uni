public class RobotRock {
    public static void main(String[] args) {
        Androide androide = new Androide();
        System.out.println(androide.toString());

        androide.cambiaTag();
        System.out.println(androide.toString());
    }
}

class Androide{
    private static int tag = 1;
    private static String nome;

    public Androide(){
        this.nome = "Bob";
        this.cambiaTag();
    }

    public void cambiaTag(){
        int primo = 0;
        if (tag <= 1){
            tag = 2;
        }
        int prime = tag;
        boolean found = false;
        while (!found){
            prime++;
            if (isPrime(prime)){
                found = true;
                tag = prime;
            }
        }
    }

    public static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    
    public String toString() {
        return "tag: " + this.tag + " , nome: " + this.nome;
    }

}