package oliverjakubdanie.restauracia;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class cenyJedal {

    Map<String, Double> jedla;
    private String jedlo;
    private double cena;

    public cenyJedal() {
        jedla = new HashMap<>();

        Scanner s = null;
        try {
            s = new Scanner(new File("ceny.txt"));
            s.useDelimiter(";");
            while (s.hasNextLine()) {
                String riadok = s.nextLine();
                String[] polozky = riadok.split(";");
                jedla.put(polozky[0], Double.parseDouble(polozky[1]));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        aktualizujTxt(jedla);
    }

    public void aktualizujTxt(Map<String, Double> m) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("ceny.txt"));
            pw.write("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Double> mapa : m.entrySet()) {
            String nazov = mapa.getKey();
            double cena = mapa.getValue();
            zapisJedlo(nazov, cena);

        }

    }

    public double getCena() {
        return cena;
    }

    public String getJedlo() {
        return jedlo;
    }

    public void pridajJedlo(String jedlo, double cena) {
        jedla.put(jedlo, cena);
        zapisJedlo(jedlo, cena);

    }

    public void zapisJedlo(String jedlo, double cena) {

        try (FileWriter writer = new FileWriter(new File("ceny.txt"), true)) {
            writer.append(jedlo + ";" + cena + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void vymazJedlo(String jedlo, double cena) {
        jedla.remove(jedlo, cena);
    }

    public void vymazVsetkyJedla() {
        Map<String, Double> novaMapa = new HashMap<>();
        jedla = novaMapa;
        aktualizujTxt(jedla);

    }

    public void zmenCenu(String jedlo, double NovaCena) {
        jedla.remove(jedlo);
        jedla.put(jedlo, NovaCena);

    }

    public double ziskajCenu(String jedlo) {
        for (String j : jedla.keySet()) {
            if (j.equals(jedlo)) {
                return jedla.get(j).doubleValue();
            }
        }
        return -1;
    }

}
