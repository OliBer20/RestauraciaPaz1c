package oliver_daniel.restauracia;

import java.util.List;

interface NapojeDao {
    
    
    public void pridajNapoj(Napoj n);
    
    public List<Napoj> dajNapoje();
    
    public void vymazNapoj(Napoj n);
    
    public void vymazVsetkyNapoje();
    
    public double ziskajCenu(Napoj n);
    
}
