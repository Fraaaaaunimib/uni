package Esercizi3;

public class Audit {
    
    public boolean benefitTroppoAlto(Dipendente e){
        try {
        Dirigente e1 = (Dirigente)e;
        if (e1.getBenefit() > 10000) return true;
        } catch (NullPointerException eN){
            System.out.println("null");;
        } catch (ClassCastException eC){
            System.out.println("Class cast");;
        } catch (Exception ea){
            System.out.println("Exception");;
        } finally {
        System.out.println("Message");
        }
        return false;
    }

    public boolean isSorted(Dipendente [] d) throws InvalidArrayException{
        try{
            for(int i=0; i<d.length-1; i++){
               if(d[i].calcolaRal() < d[i+1].calcolaRal()) return false;      
            }
            return true;
        }catch(NullPointerException e){
            throw new InvalidArrayException("Array non valido");
        }catch(IndexOutOfBoundsException e){ //se lunghezza=0, allora I[0] è già invalido
            return true;
        }
    }

    

    public Dipendente topRal(Dipendente[] d) throws InvalidArrayException{
            if(isSorted(d) && d.length >0) return d[0];
            else throw new InvalidArrayException();
    }
}

    