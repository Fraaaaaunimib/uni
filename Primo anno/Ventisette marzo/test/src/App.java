                                        
public class App {
    public static void main(String[] args)  {
       System.out.println("hi"); 

       Punto p = new Punto(1,1);
       Cerchio c = new Cerchio(2, p);

       System.out.println(c);

       p.setX(100);
        System.out.println(c);

        Punto centroC = c.getCentro();
        centroC.setX(90);
        System.out.println(c);



    }
}

class Punto {
    private int x;
    private int y;

    public Punto(int x, int y){
        setX(x);
        setY(y);
    }

    public void setX(int x){
        if (x >= 0)
            this.x = x;
    }

    public void setY(int y){
        if (y >= 0)
            this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Punto(){
        this(0,0);
    }

    public Punto(Punto punto){
        this(punto.x, punto.y); //punto deve essere diverso da null
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}

class Cerchio{
private int raggio;
public Punto centro;

public Cerchio(Cerchio cerchio){
    this(cerchio.raggio, cerchio.centro);
}

public Cerchio(int raggio, Punto centro){
    
}


    public void setRaggio(int raggio){
        if (raggio > 0)
        this.raggio = raggio;

        else if (this.raggio == 0)
        this.raggio = 1;
        }

        public void setCentro(Punto centro){
            if (centro != null)
                this.centro = centro; 
            else if (this.centro == null)
                this.centro = new Punto();
        }

        public void setCentro(int x, int y){
            setCentro(new Punto(x,y));
        }

        public Punto getCentro(){
            return new Punto(centro);
        }

        public boolean equals(Cerchio cerchio){
            if (cerchio == null)
                return false;
            if (this == cerchio)
                return true;
            return false;
        }

        public String toString(){
            return "Cerchio di raggio: " + raggio + ", e centro: " + centro.toString();
        }

    }
