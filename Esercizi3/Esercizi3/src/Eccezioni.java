package Esercizi3;

public class Eccezioni{

}

class DipendenteException extends Exception{
    public DipendenteException(String msg){
        super(msg);
    }

    public DipendenteException(){
        super();
    }
}

class AziendaException extends Exception{
    public AziendaException(String msg){
        super(msg);
    }

    public AziendaException(){
        super();
    }
}

class InvalidArrayException extends Exception{
    public InvalidArrayException(String msg){
        super(msg);
    }
    public InvalidArrayException(){
        super();
    }
}

