package oliver_daniel.restauracia;

import java.util.List;

interface NapojeDao {
    
    public List<Napoj> dajNapoje();    
    
    public void pridajNapoj(Napoj napoj);
    
    public void vymazNapoj(Napoj napoj);
    
    public void vymazVsetkyNapoje();
    
}
