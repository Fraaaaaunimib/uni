import java.util.Scanner;
public class Test1{

    public static void main (String[] args) {

        Studente studente = new Studente();
        studente.cognome = "Rossi";
        studente.nome = "Mario";

        studente.libretto = new Libretto();
        studente.libretto.esami = new Esame[5];
        for (int i = 0; i < studente.libretto.esami.length;i++){
            studente.libretto.esami[i] = new Esame();
            studente.libretto.esami[i].insegnamento = new Insegnamento();
        }
        boolean whileChoiceControl = true;
        boolean menu = true;
        Scanner sc = new Scanner(System.in);
        while (menu == true){
        //metodo per farti inserire tutti i dati
        System.out.print("Vuoi aggiungere un esame al tuo libretto? [si per aggiungerli, \"vedi\" per vederli ]");
            String librettoChoice = sc.next();
            librettoChoice = librettoChoice.toLowerCase();
boolean continue1 = true;
            switch (librettoChoice) {
                case "si":
                whileChoiceControl = true;
                while (continue1 == true){
                    for (int i = 0; i < studente.libretto.esami.length;i++){
                        if (studente.libretto.esami[i].insegnamento.cfu == 0 && whileChoiceControl == true){
                System.out.print("Quanti CFU ha l'insegnamento del tuo esame? ");
                studente.libretto.esami[i].insegnamento.cfu = sc.nextInt();

                System.out.println("Come si chiama l'insegnamento? ");
                studente.libretto.esami[i].insegnamento.denominazione = sc.next();

                System.out.print("Qual'è l'ID dell'insegnamento? ");
                studente.libretto.esami[i].insegnamento.id = sc.next();

                System.out.print("Ok, quando hai svolto l'esame? ");
                studente.libretto.esami[i].data = sc.next();

                System.out.print("Che voto hai preso? ");
                studente.libretto.esami[i].voto = sc.nextInt();

                System.out.println("Hai aggiunto l'insegnamento " + studente.libretto.esami[i].insegnamento.denominazione + " con CFU " + studente.libretto.esami[i].insegnamento.cfu + " relativo all'esame che hai fatto il " + studente.libretto.esami[i].data + " con un voto di " + studente.libretto.esami[i].voto);

                System.out.print("Vuoi aggiungere un nuovo esame? ");
                String whileChoice = sc.next();
                whileChoice = whileChoice.toLowerCase();
                switch (whileChoice){
                    case "si":
                    continue1 = true;
                    break;

                    case "no":
                    continue1 = false;
                    whileChoiceControl = false;
                    i = studente.libretto.esami.length + 1;
                    break;
                    
                    

                    default:
                    break;
                }
                }
                }
            }
                break;

                case "vedi":
                System.out.println(" ╔════════╦═════════════════════╦═══════╦══════════════╦════════════╗");
                System.out.println(" ║   ID   ║    Denominazione    ║  CFU  ║  Voto esame  ║ Data esame ║");
                    
                for (int i = 0; i < studente.libretto.esami.length; i++){
                    if (studente.libretto.esami[i].insegnamento.cfu != 0){
                    //System.out.println("Insegnamento " + studente.libretto.esami[i].insegnamento.denominazione + " con CFU " + studente.libretto.esami[i].insegnamento.cfu + " relativo all'esame che hai fatto il " + studente.libretto.esami[i].data + " con un voto di " + studente.libretto.esami[i].voto);

                    System.out.println(" ║  " + studente.libretto.esami[i].insegnamento.id + " ║    " + studente.libretto.esami[i].insegnamento.denominazione + "   ║  " + studente.libretto.esami[i].insegnamento.cfu + "    ║       " + studente.libretto.esami[i].voto + "     ║     " + studente.libretto.esami[i].data + "   ║");

                }
            }
                System.out.println(" ╚════════╩═════════════════════╩═══════╩══════════════╩════════════╝");
                break;
                
                
        }
    }
        sc.close();
                    }
                }
                
            