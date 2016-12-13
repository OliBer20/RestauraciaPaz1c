package oliver_daniel.restauracia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuborovyObjednavkaDao implements ObjednavkyDao {


    @Override
    public void pridaj(Objednavka objednavka) {
        try (FileWriter writer = new FileWriter(new File("Objednavky.txt"), true)) {
            // TODO zapisovat aktualny datum
            writer.append(objednavka.getNazovJedla() + ";" + objednavka.getCenaJedla() + ";11. 10. 2016;" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public List<Objednavka> dajObjednavky() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void odstranVsetko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void Odstran(Objednavka objednavka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymazPredosluObjednavku() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
