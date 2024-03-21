public class Printer{
    public void stampa(PrintableDocument doc){
        String output = "";

        String[] pagine = doc.body();
        for (int i = 0; i < pagine.length; i++){
            output += "Page " + (i+1) + "\n" + doc.header() + "\n" + pagine[i];
        }
        System.out.println(output);
    }
}