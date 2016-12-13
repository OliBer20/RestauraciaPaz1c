package oliver_daniel.restauracia;

import java.util.List;

interface NapojeDao {
    
    public List<String> dajNapoje();    
    
    public void pridajNapoj(String napoj);
    
    public void vymazNapoj(String napoj);
    
    public void vymazVsetkyNapoje();
    
}
