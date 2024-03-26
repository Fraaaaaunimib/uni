//test accesso condizionato con wait e notify
public class monitorTest {
    private final int MaxBuffSize;
    private char[] store;
    private int BufferStart, BufferEnd, BufferSize;

    public monitorTest(int size){
        MaxBuffSize = size;
        BufferEnd = -1;
        BufferStart = 0;
        BufferSize = 0;
        store = new char[MaxBuffSize];
    }

    //wait rilascia il lock sull'oggetto, sospende il thread fino alla ricezione di segnale di notifica
    //qua devi verificare che la coda non sia piena
    public synchronized void insert(char ch){
        try { while (BufferSize == MaxBuffSize) { wait(); } //aspettare fino a completamento condizione
            BufferEnd = (BufferEnd + 1) % MaxBuffSize;
            store[BufferEnd] = ch;
            BufferSize++;
            notifyAll(); //notificare tutti gli altri thread sospesi
            //entrambi i thread adesso sono in stato ready
        } catch (InterruptedException e){ //notifichiamo tutti i thread
            System.out.println("Thread interrupted.");
        }
    }

    public synchronized char delete() {
        //verifica che la coda non sia vuota, per non eliminare il vuoto
        try { while (BufferSize == 0) { wait(); }
        char ch = store[BufferStart];
        BufferStart = (BufferStart + 1) % MaxBuffSize;
        BufferSize--; //cancella gli elementi dal buffer
        notifyAll(); //notifica del cambiamento
        //Svegliare chi è in attesa del verificarsi di una certa soluzione
        return ch;
    } catch (InterruptedException e) {
        System.out.println("Thread interrupted.");
        return ' ';
    }
    }
}
