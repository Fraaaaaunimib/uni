package es2;

public interface IDevice{
    void start();
    void stop();

    boolean ready = false;

}

interface Password{
    boolean isEmpty();
}

interface ICamera extends IDevice{
    boolean takePhoto();
}

interface ITelephone extends IDevice{
    boolean call(long number);
}

abstract class Device implements IDevice{
    private boolean ready;

    @Override
    public void start(){
        ready = true;
    }

    @Override
    public void stop(){
        ready = false;
    }

    public boolean isReady(){
        return ready;
    }


}

class Photo{

}

class Smartphone extends Device implements ICamera, ITelephone{

    private Photo[] gallery;
    private double credit;


    public Smartphone(int maxPhotos){
        if (maxPhotos>0) gallery = new Photo[maxPhotos];
        credit = 0;
    }

    public void addCredit(double credito){
        if (credito > 0) this.credit += credit;
    }

    
@Override
    public boolean call(long number){
        if (!isReady()) return false;
        if (credit >0) return true;
        else return false;

}

public boolean isReady(){
    return this.ready;
}

@Override
public boolean takePhoto(){
    if (!isReady()) return false;
    for (int i = 0; i < gallery.length; i++){
        if (gallery[i] == null){
            gallery[i] = new Photo();
            return true;
        }
    }
    return false;
}
}

abstract class Regola{
    public boolean convalida(Account a){
        if (a == null) return false;
        if (a.getPassword() == null || a.getPassword().isEmpty()){
            return false;
        }
        return applica(a);
    }

    protected abstract boolean applica(Account a);
}

class Account{
    private String username;
    private String password;


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
class LunghezzaPassword extends Regola{
    private int lunghezzaMinima;
    public LunghezzaPassword(int lunghezzaMinima){
        this.lunghezzaMinima = lunghezzaMinima;
    }

    @Override
    protected boolean applica(Account a){
    return (a.getPassword().length() >= lunghezzaMinima);
    
}

}

class Uguaglianza extends Regola{
    @Override
    protected boolean applica(Account a){
        return a.getPassword().equalsIgnoreCase(a.getUsername());
    }
}