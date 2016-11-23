package oliverjakubdanie.restauracia;

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
    public List<Objednavka> dajObjednavky() {
        List<Objednavka> Objednavky = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("Objednavky.txt"))) {
            while (scanner.hasNextLine()) {
                String riadok = scanner.nextLine();
                String[] polozky = riadok.split(";");
                
                Objednavka o = new Objednavka();
                o.setNazovJedla(polozky[0]);
                o.setCenaJedla(Double.parseDouble(polozky[1]));
                o.setCasObjednavky(null);
                
                Objednavky.add(o);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objednavky;
    }

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
    public void Odstran(Objednavka objednavka) {
        
    }

}
