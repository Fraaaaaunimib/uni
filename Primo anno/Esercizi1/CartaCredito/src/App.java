import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        //esercizio 1
        CartaCredito credito = new CartaCredito(445914059, 553, "Fratta", "Dogecoin", 900);
        Pagamento[] pagamenti = new Pagamento[2];

        Pagamento pagamento = new Pagamento("Nokia", "N95 8GB", 27);
        pagamenti[0] = pagamento;
        Pagamento pagamento2 = new Pagamento("Agenzia Entrate", "e", 1500);
        pagamenti[1] = pagamento2;
        System.out.println("Carta di credito n. " + credito.getNumero() + ", titolare: " + credito.getTitolare() + ", alla banca " + credito.getBanca() + " con €" + credito.getSoldi() );
        credito.modificaCredito(credito.payment(pagamento.getPayment()));
        credito.modificaCredito(credito.versamento(600));
        System.out.println("Ora hai " + credito.getSoldi() + "€");
        System.out.println(pagamento.toString());
        System.out.println(pagamento2.toString());

        //esercizio 2
        InteroValido interoValido = new InteroValido();
        interoValido.setSollecito("Aiuto");
        interoValido.setMaxVal(5);
        interoValido.setMinVal(1);
        //interoValido.getValore();

        //esercizio 3
        venditaArticolo vendita = new venditaArticolo(0, 0, 0, 10, 10, 30);
       vendita.registraVendita(3);
       vendita.registraVendita(8);
        System.out.println(vendita.toString());

        //esercizio 4
        BarcaAMotore barca = new BarcaAMotore(100, 50, 40);
       barca.serbatoio(70);
       System.out.println("Carburante: " + barca.getCarburante() + ", distanza: " + barca.getDistanza());
        barca.navigate(40, 30);
        System.out.println("Carburante: " + barca.getCarburante() + ", distanza: " + barca.getDistanza());
    barca.checkSerbatoio();

    //esercizio 5
    IndirizzoPersona[] indirizzoPersona = new IndirizzoPersona[2];

    IndirizzoPersona persona1 = new IndirizzoPersona("Franca", "Carla", "a@a.com", 12345);
    IndirizzoPersona persona2 = new IndirizzoPersona("Ale", "Hale", "b@b.com", 0323502033);

    indirizzoPersona[0] = persona1;
    indirizzoPersona[1] = persona2;
    System.out.println(indirizzoPersona[0]);
    System.out.println(indirizzoPersona[1]);
    
    //esercizio 6
    Punteggio punteggio1 = new Punteggio("Palm Treo Pro", "5", 4);
    System.out.println(punteggio1.toString());

    //esercizio 7
    ProgettoScienzaPunteggio scienza = new ProgettoScienzaPunteggio("e", "5", 4, "5", "Franca", 3, 4, 5, 6, 7);
    System.out.println(scienza.toString());
    }
}

class Pagamento{
    private String ente;
    private String descrizione;
    private int payment;

    public Pagamento(String ente, String descrizione, Integer payment){
        this.ente = ente;
        this.descrizione = descrizione;
        this.payment = payment;
    }

    public String getEnte() {
        return this.ente;
    }

    public void setEnte(String ente) {
        this.ente = ente;

    
    }

    @Override
    public String toString() {
        return "{" +
            " ente='" + getEnte() + "'" +
            ", descrizione='" + getDescrizione() + "'" +
            ", payment='" + getPayment() + "'" +
            "}";
    }
    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPayment() {
        return this.payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
    
}

class CartaCredito{

    private int numero;
    private int ccv;
    private String titolare;
    private String banca;
    private int soldi;
    private Pagamento[] pagamenti;
    

    public CartaCredito(int numero, int ccv, String titolare, String banca, int soldi){
        this.numero = numero;
        this.ccv = ccv;
        this.titolare = titolare;
        this.banca = banca;
        this.soldi = soldi;
    }

    public void modificaCredito(int money){
        this.soldi = money;
    }
    
    public String getBanca(){
        return this.banca;
    }

    public int getSoldi(){
        return this.soldi;
    }
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCcv() {
        return this.ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getTitolare() {
        return this.titolare;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    

    public void setBanca(String banca) {
        this.banca = banca;
    }

    public int payment(int money){
        if (money > this.soldi){
            return -1;
        }
        else{
            return soldi-money;
        }
    }

    public int versamento(int money){
        if (money < 0){
            return -1;
        } else {
            return soldi+money;
        }
    }
}

class InteroValido{
    private int minVal;
    private int maxVal;
    private String sollecito;

    public int getValore(){
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
int valore = 0;
        while (valid == false){
        System.out.print("Immetti un valore: ");
        valore = sc.nextInt();
        System.out.println(this.sollecito);

        if (valore < this.minVal || valore > this.maxVal){
            valid = false;
            System.out.println("Nuh-uh, non è valido. Riprova.");
        } else {
            valid = true;
        }

        }
        sc.close();
        return valore;
    }


    public int getMinVal() {
        return this.minVal;
    }

    public void setMinVal(int minVal) {
        this.minVal = minVal;
    }

    public int getMaxVal() {
        return this.maxVal;
    }

    public void setMaxVal(int maxVal) {
        this.maxVal = maxVal;
    }

    public String getSollecito() {
        return this.sollecito;
    }

    public void setSollecito(String sollecito) {
        this.sollecito = sollecito;
    }
    

}

class venditaArticolo{
     
    private int numeroVenduti;
    private int venditeTotali;
    private int scontatiTotali;
    private int costoArticolo;
    private int quantitaIngrosso;
    private int scontoIngrosso;

    public venditaArticolo(int numeroVenduti, int venditeTotali, int scontatiTotali, int costoArticolo, int quantitaIngrosso, int scontoIngrosso){
        this.numeroVenduti = numeroVenduti;
        this.venditeTotali = venditeTotali;
        this.scontatiTotali = scontatiTotali;
        this.costoArticolo = costoArticolo;
        this.quantitaIngrosso = quantitaIngrosso;
        this.scontoIngrosso = scontoIngrosso;
    }
    public void registraVendita(int n){
        this.numeroVenduti += n;
        if (this.numeroVenduti > this.quantitaIngrosso){
            this.costoArticolo = this.costoArticolo-(this.costoArticolo*this.scontoIngrosso)/100;
            this.scontatiTotali+= n;
            this.numeroVenduti = this.quantitaIngrosso;
        }
            //x:costoarticolo = sconto:100
            //x: (costoArticolo*sconto)/100
    }


    public int getNumeroVenduti() {
        return this.numeroVenduti;
    }

    public void setNumeroVenduti(int numeroVenduti) {
        this.numeroVenduti = numeroVenduti;
    }

    public int getVenditeTotali() {
        return this.venditeTotali;
    }

    public void setVenditeTotali(int venditeTotali) {
        this.venditeTotali = venditeTotali;
    }

    public int getScontatiTotali() {
        return this.scontatiTotali;
    }

    public void setScontatiTotali(int scontatiTotali) {
        this.scontatiTotali = scontatiTotali;
    }

    public int getCostoArticolo() {
        return this.costoArticolo;
    }

    public void setCostoArticolo(int costoArticolo) {
        this.costoArticolo = costoArticolo;
    }

    public int getQuantitaIngrosso() {
        return this.quantitaIngrosso;
    }

    public void setQuantitaIngrosso(int quantitaIngrosso) {
        this.quantitaIngrosso = quantitaIngrosso;
    }

    public int getScontoIngrosso() {
        return this.scontoIngrosso;
    }

    public void setScontoIngrosso(int scontoIngrosso) {
        this.scontoIngrosso = scontoIngrosso;
    }

    @Override
    public String toString() {
        return "{" +
            " numeroVenduti='" + getNumeroVenduti() + "'" +
            ", venditeTotali='" + getVenditeTotali() + "'" +
            ", scontatiTotali='" + getScontatiTotali() + "'" +
            ", costoArticolo='" + getCostoArticolo() + "'" +
            ", quantitaIngrosso='" + getQuantitaIngrosso() + "'" +
            ", scontoIngrosso='" + getScontoIngrosso() + "'" +
            "}";
    }


    public void mostraVendite(){
        System.out.println("Numero articoli venduti: " + this.numeroVenduti + ", vendite totali: " + this.venditeTotali + ", sconto totale: " + this.scontoIngrosso);

    }
}

class BarcaAMotore{
    private int serbatoioCapacita;
    private int serbatoio;
    private int maxVel;
    private int Vela;
    private int motoreEff;
    private int distanza;

    public void setVel(int vel){
        this.Vela = vel;
    }

    public void checkSerbatoio(){
        if (this.getCarburante() == -1){
            System.out.println("Oops, sei andato troppo in là...");
        } else {
            System.out.println(this.getCarburante());
        }
    }
    public BarcaAMotore(int serbatoioCapacita, int maxVel, int motoreEff){
        this.serbatoioCapacita = serbatoioCapacita;
        this.serbatoio = 0;
        this.maxVel = maxVel;
        this.Vela = 0;
        this.motoreEff = motoreEff;
        this.distanza = 0;
    }
    public void navigate(int tempo, int vela){
        // v = s/t --> s = v*t

        this.Vela = vela;
        this.distanza = this.Vela * tempo;
        this.serbatoio = this.serbatoio - (this.motoreEff * this.distanza * this.distanza * tempo);
        if (this.serbatoio < 0 || this.serbatoio > this.serbatoioCapacita)
        this.serbatoio = -1;
    }

    public void serbatoio(int benzina){
        this.serbatoio = benzina;
    }

    public int getCarburante(){
        return this.serbatoio;
    }

    public int getDistanza(){
        return this.distanza;
    }


}

class IndirizzoPersona{

    private String nome;
    private String cognome;
    private String email;
    private int telefono;

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", cognome='" + getCognome() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            "}";
    }

    public IndirizzoPersona(String nome, String cognome, String email, int telefono){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean equals(IndirizzoPersona altro){
        if (this.getNome() == altro.getNome() && this.getCognome() == altro.getCognome()){
            return true;
        }
        return false;
    }

}

class Punteggio{
    private String descrizione;
    private String maxPunto;
    private int punteggio;


    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getMaxPunto() {
        return this.maxPunto;
    }

    public void setMaxPunto(String maxPunto) {
        this.maxPunto = maxPunto;
    }

    public int getPunteggio() {
        return this.punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }


    @Override
    public String toString() {
        return "{" +
            " descrizione='" + getDescrizione() + "'" +
            ", maxPunto='" + getMaxPunto() + "'" +
            ", punteggio='" + getPunteggio() + "'" +
            "}";
    }

    public Punteggio(String descrizione, String maxPunto, int punteggio){
        this.descrizione = descrizione;
        this.maxPunto = maxPunto;
        this.punteggio = punteggio;
    }
}

class ProgettoScienzaPunteggio extends Punteggio{

    public ProgettoScienzaPunteggio(String descrizione, String maxPunto, int punteggio) {
        super(descrizione, maxPunto, punteggio);
        //TODO Auto-generated constructor stub
    }
    
    public ProgettoScienzaPunteggio(String descrizione, String maxPunto, int punteggio, String ident, String personaNome, int abilitaCreativa, int valoreScientifico, int completezza, int abilitaTecnica, int chiarezza){
      super(descrizione, maxPunto, punteggio);
      
      this.ident = ident;
      this.personaNome = personaNome;
      this.abilitaCreativa = abilitaCreativa;
      this.valoreScientifico = valoreScientifico;
      this.completezza = completezza;
      this.abilitaTecnica = abilitaTecnica;
      this.chiarezza = chiarezza;

    }
    private String ident;
    private String personaNome;
    private int abilitaCreativa;
    private int valoreScientifico;
    private int completezza;
    private int abilitaTecnica;
    private int chiarezza;


    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getPersonaNome() {
        return this.personaNome;
    }

    public void setPersonaNome(String personaNome) {
        this.personaNome = personaNome;
    }

    public int getAbilitaCreativa() {
        return this.abilitaCreativa;
    }

    public void setAbilitaCreativa(int abilitaCreativa) {
        this.abilitaCreativa = abilitaCreativa;
    }

    public int getValoreScientifico() {
        return this.valoreScientifico;
    }

    public void setValoreScientifico(int valoreScientifico) {
        this.valoreScientifico = valoreScientifico;
    }

    public int getCompletezza() {
        return this.completezza;
    }

    public void setCompletezza(int completezza) {
        this.completezza = completezza;
    }

    public int getAbilitaTecnica() {
        return this.abilitaTecnica;
    }

    public void setAbilitaTecnica(int abilitaTecnica) {
        this.abilitaTecnica = abilitaTecnica;
    }

    public int getChiarezza() {
        return this.chiarezza;
    }

    public void setChiarezza(int chiarezza) {
        this.chiarezza = chiarezza;
    }

    @Override
    public String toString() {
        return "{" +
            " ident='" + getIdent() + "'" +
            ", personaNome='" + getPersonaNome() + "'" +
            ", abilitaCreativa='" + getAbilitaCreativa() + "'" +
            ", valoreScientifico='" + getValoreScientifico() + "'" +
            ", completezza='" + getCompletezza() + "'" +
            ", abilitaTecnica='" + getAbilitaTecnica() + "'" +
            ", chiarezza='" + getChiarezza() + "'" +
            "}";
    }


}