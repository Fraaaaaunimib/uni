import java.util.*; import java.io.*;
import java.util.concurrent.locks.*;
//problema concorrenziale con deposito e prelievo
/*
 * primo thread preleva 10 con saldo iniziale 100
 * registro1: prende dalla memoria "100" e preleva --> 90
 * registro2: prende dalla memoria "100"
 * 
 * lo scheduler decide che è il momento adatto per sottrare la CPU al primo thread - salva il contenuto per il context switch
 * e fa partire l'altro thread - deposito di 20
 * la memoria centrale non è stata modificata, quindi otterrà **120** e non **110**, e poi salverà nella memoria centrale
 * il valore sbagliato
 * il thread 2 termina, e lo scheduler ritorna al thread 1, e scriverà nella memoria centrale 90
 * il saldo è sbagliato.
  */
  class ContoCorrente {
    private float saldo;
    
    public ContoCorrente(float saldoIniziale){
      saldo = saldoIniziale;
    }
    
    public void deposito(float cifra){
      float nuovoSaldo = saldo + cifra;
      try{
        // sleep inserito per rendere piu' probabile la race condition
        Thread.sleep(50); 
      }
      catch(InterruptedException e){
        System.out.println("Thread interrupted.");
      }
      saldo = nuovoSaldo;
    }
    
    public void prelievo(float cifra){
      if(saldo > cifra){
        float nuovoSaldo = saldo - cifra;
        try{
          // sleep inserito per rendere piu' probabile la race condition
          Thread.sleep(50);
        }
        catch(InterruptedException e){
          System.out.println("Thread interrupted.");
        }
        saldo = nuovoSaldo;
        return;
      }
      saldo = 0.0f;
      
    }
    
    public float saldo(){
      return saldo;
    }
    
  }
  
  class ThreadPreleva extends Thread {
    private ContoCorrente conto; // risorsa condivisa
    private float cifra;
    
    public ThreadPreleva(ContoCorrente conto, float cifra) {
      this.conto = conto;
      this.cifra = cifra;
    }
    
    public void run() {
      conto.prelievo(cifra);
      System.out.println("Effettuato un prelievo di " + cifra);
      System.out.println("Il saldo del conto e' " + conto.saldo());
    }
    
  }
  
  class ThreadDeposita extends Thread {
    private ContoCorrente conto; // risorsa condivisa
    private float cifra;
    
    public ThreadDeposita(ContoCorrente conto, float cifra) {
      this.conto = conto;
      this.cifra = cifra;
    }
    
    public void run() {
      conto.deposito(cifra);
      System.out.println("Effettuato un deposito di " + cifra);
      System.out.println("Il saldo del conto e' " + conto.saldo());
    }
  }
  
  public class concurrentTest {

    //race condition che succede con i thread 
     public static void main(String args[]) {
       // shared resource: conto
       ContoCorrente conto = new ContoCorrente(10000.0f);
       
       ThreadDeposita t1, t2, t3;
       t1 = new ThreadDeposita(conto, 100.0f);
       t2 = new ThreadDeposita(conto, 150.0f);
       t3 = new ThreadDeposita(conto, 50.0f);
       
       ThreadPreleva t4, t5, t6;
       t4 = new ThreadPreleva(conto, 200.0f);
       t5 = new ThreadPreleva(conto, 50.0f);
       t6 = new ThreadPreleva(conto, 100.0f);
       
       System.out.println("Il saldo iniziale del conto e' " + conto.saldo());
       
       t1.start();
       t2.start();
       t3.start();
       t4.start();
       t5.start();
       t6.start();
       
       // Aspettiamo che tutti i thread abbiano finito
       try {
           t1.join(); 
           t2.join(); 
           t3.join();
           t4.join();
           t5.join();
           t6.join();
         
         // with join the main thread waits untill all other threads terminate
         } catch (InterruptedException e) {}
       System.out.println("\nIl saldo finale del conto è: "+ conto.saldo());
       System.out.println("\nIl saldo finale del conto avrebbe dovuto essere: 9950.0");
     
       //lock test
       var res = new SharedRes();
       var l1 = new Thread(new SynchRunnable(res), "T1");

     
       // https://replit.com/@miciav/Semaphore#Main.java

      }
  }

class SharedRes 
{
  private Lock l = new ReentrantLock(); 
  private int counter = 0;

  public void increment(){
    l.lock();
try {
      System.out.println(Thread.currentThread().getName() + " acquired the lock.");
      // doing some action
      try {
        counter++;
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
    } finally {
      // Release the permit.
      System.out.println(Thread.currentThread().getName() + " releases the lock.");
      l.unlock();
    }
  }
  public int getCounter(){
    return counter;
  }
}

class SynchRunnable implements Runnable {
  private SharedRes s;

  public SynchRunnable(SharedRes s) {
    this.s = s;
  }

  public void run() {
    s.increment();
  }
}

class ContoCorrente2 {
  private float saldo;
  
  public ContoCorrente2(float saldoIniziale){
    saldo = saldoIniziale;
  }
  
  public synchronized void deposito(float cifra){
    saldo += cifra;
    System.out.println("Effettuato un deposito di " + cifra);
  }
  
  public synchronized void prelievo(float cifra){
    if(saldo > cifra){
      saldo -= cifra;
      System.out.println("Effettuato un prelievo di " + cifra);
      return;
    }
    float prelevati = saldo;
    saldo = 0.0f;
    System.out.println("Effettuato un prelievo di " + prelevati);
  }
  
  public synchronized float saldo(){
    return saldo;
  }
  
  public synchronized void stampaSaldo(){
    System.out.println("Il saldo del conto e' " + saldo);
  }
  
}

class ThreadPreleva2 extends Thread {
  private ContoCorrente2 conto;
  private float cifra;
  
  public ThreadPreleva2(ContoCorrente2 conto, float cifra) {
    this.conto = conto;
    this.cifra = cifra;
  }
  
  public void run() {
    conto.prelievo(cifra);
    //System.out.println("Effettuato un prelievo di " + cifra);
    conto.stampaSaldo();
  }
  
}

class ThreadDeposita2 extends Thread {
  private ContoCorrente2 conto;
  private float cifra;
  
  public ThreadDeposita2(ContoCorrente2 conto, float cifra) {
    this.conto = conto;
    this.cifra = cifra;
  }
  
  public void run() {
    conto.deposito(cifra);
    //System.out.println("Effettuato un deposito di " + cifra);
    conto.stampaSaldo();
  }
}

class sharedConto{
   public static void test2(String args[]) {
     ContoCorrente conto = new ContoCorrente(10000.0f);
     ThreadDeposita t1, t2, t3;
     t1 = new ThreadDeposita(conto, 100.0f);
     t2 = new ThreadDeposita(conto, 150.0f);
     t3 = new ThreadDeposita(conto, 50.0f);
     
     ThreadPreleva t4, t5, t6;
     t4 = new ThreadPreleva(conto, 200.0f);
     t5 = new ThreadPreleva(conto, 50.0f);
     t6 = new ThreadPreleva(conto, 100.0f);
     
     System.out.println("Il saldo iniziale del conto e' " + conto.saldo());
     
     t1.start();
     t2.start();
     t3.start();
     t4.start();
     t5.start();
     t6.start();
        // Aspettiamo che tutti i thread abbiano finito
     try {
         t1.join(); 
         t2.join(); 
         t3.join();
         t4.join();
         t5.join();
         t6.join();
       
       // with join the main thread waits untill all other threads terminate
       } catch (InterruptedException e) {}
      System.out.println("\nIl saldo finale del conto è: "+ conto.saldo());
     System.out.println("\nIl saldo finale del conto avrebbe dovuto essere: 9950.0");
  
   }

   //esempio blocchi synchronised
   public int read(){
    synchronized(this){ // 
      return 0;
    }
   }
}

//sync e variabili statiche
class StaticSharedVariable {
  private static int shared;
  public static int read() {
    //sto cercando di accedere a una variabile statica così legge dalla classe e non dall'oggetto
    synchronized(StaticSharedVariable.class) {
      return shared;
    }
  }

  public synchronized static void write(int i){
    shared = i;
  }
}