import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.Lock;

public class visibilityProblems {
    
}

class myRunnable implements Runnable{
    private IContatore contatore;
    private int numIncrementi;

    public myRunnable(IContatore cont, int incr){
        this.contatore = cont;
        this.numIncrementi = incr;
    }

    public void run(){
        for (int i = 0; i < numIncrementi; i++){
            contatore.incremento();
        }
    }

    private int value;
    public int compareAndSwap(int exp, int newValue){
        int oldValue = value;
        synchronized(this) {
            if (oldValue == exp) value= new;
            return oldValue;
        }
    }

    public boolean compareAndSet(int exp, int newValue){
        return (exp == compareAndSwap(exp, newValue));
    }
}

class IContatore {

    private volatile int c = 0;

    public void incremento(){c++;}
    public int value(){return c;}
}

class ContatoreNonSincronizzato{
    private volatile int c = 0;
    private void incremento() { c++; }
    public int value(){return c;}
}

class ContatoreSincronizzato {
    private int c = 0;
    public synchronized void incremento() { c++;}
    public synchronized int value() {return c;}
}

class ContatoreAtomico{
    private AtomicInteger c = new AtomicInteger(0);
    public void incremento() {c.incrementAndGet();}
    public int value() {return c.get();}
}

//nel caso diversi thread abbiano accesso a c++, ci sia collisione
/*
 * assembly:
 * 0: aload_0
 * 1: dup
 * 2: getfield #2 //Field c:I //legge campo c
 * 5: iconst_1 //aggiunge 1 a c
 * 6: iadd
 * 7: putfield #2 //Field c:I //scrive in memoria
 * 10: return
 * ognuna di queste operazioni è interrompibile - più thread possono eseguirle
 * 
 */

class ReentrantLockPseudoRandom {
    private final Lock lock = new ReentrantLock(false);
    private int seed;

    ReentrantLockPseudoRandom(int seed){
        this.seed = seed;
    }

    public int nextInt(int n){
        lock.lock();
        try {
            int s = seed;
            seed = calculateNext(s);
            int resto = s % n;
            return resto > 0 ? resto : resto + n;
        }
        finally { lock.unlock();}
    }

    private int calculateNext(int s){ return s+1;}

 }

 class AtomicPseudoRandom {
    private AtomicInteger seed;

    AtomicPseudoRandom(int seed){
        this.seed = new AtomicInteger(seed);
    }

    public int nextInt(int n){
        while (true){
            int s = seed.get();
            int nextSeed = calculateNext(s);
            if(seed.compareAndSet(s, nextSeed)){
                int resto = s % n;
                return resto > 0 ? resto : resto + n;
            }
        }
    }

    private int calculateNext(int s){
        return s+1;
    }

    class myRunnable2 implements Runnable {
        private IPseudoRandom pr;
        public int counter = 0;

        public void run(){
            while (!Thread.interrupted()){
                pr.nextInt(100);
                //cpuIntensiveOperation();
                ++counter;
            }
        }
    }
 }

