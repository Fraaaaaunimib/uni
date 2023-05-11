public class TextDocument implements PrintableDocument{
    private String testo[];
    private String titoloDocumento;
    private String autoreDocumento;

    public TextDocument(String[] testo, String titoloDocumento, String autoreDocumento){
        this.testo = testo;
        this.titoloDocumento = titoloDocumento;
        this.autoreDocumento = autoreDocumento;
    }

    @Override
    public String header(){
        return titoloDocumento;
    }

    @Override
    public String footer(){
        return autoreDocumento;
    }

    @Override
    public String[] body(){
        return testo;
    }
}