public class Vagone {

    //LISTE
    public int classe;
    public Vagone next;
    //il treno dopo

}

class testVagone{
    public static void main(String[] args) {
        Vagone v1 = new Vagone();
        v1.classe = 2;

        Vagone v2 = new Vagone();
        v2.classe = 2;

        Vagone v3 = new Vagone();
        v3.classe = 1;

        v1.next = v2; //attribuisci il vagone che è dopo
        v2.next = v3;

        Vagone v4 = new Vagone();
        v4.classe = 2;
        v2.next = v4; 
        v4.next = v3; //tolgo il reference da v2 a v3, e ci metto in mezzo v4

        //una sola catena
        //nella lista c'è un solo riferimento.
        Vagone testo = new Vagone();
        testo.classe = 2;
        testo.next = new Vagone();
        testo.next.classe = 2;  //creato un nuovo oggetto next senza avere un'altro riferimento
        testo.next.next = new Vagone();
        testo.next.next.classe = 2;

        Vagone tmp = testo.next.next;
        testo.next.next = new Vagone();
        testo.next.next.classe = 1;
        testo.next.next.next = tmp; //posso creare quanti vagoni next voglio

        tmp = testo;
        while (tmp != null){
            System.out.println("Classe: " + tmp.classe);
            tmp = tmp.next;
        }
        //assegnando a tmp il testo, vado all'inizio della lista, e gli faccio stampare tutte le classi

    }
}

