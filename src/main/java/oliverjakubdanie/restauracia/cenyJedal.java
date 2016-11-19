package oliverjakubdanie.restauracia;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class cenyJedal implements NewInterface {

    Map<String, Double> jedla;
    private String jedlo;
    private double cena;

    public cenyJedal() {
        jedla = new HashMap<>();
        naplnMapuJedlamiZTxt();

    }

    @Override
    public double getCena() {
        return cena;
    }

    @Override
    public String getJedlo() {
        return jedlo;
    }

    @Override
    public void naplnMapuJedlamiZTxt() {

        Scanner s = null;
        try {
            s = new Scanner(new File("ceny.txt"));
            while (s.hasNextLine()) {
                String riadok = s.nextLine();
                String[] polozky = riadok.split(";");
                jedla.put(polozky[0], Double.parseDouble(polozky[1]));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void aktualizujTxt(Map<String, Double> m) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("ceny.txt"));
            pw.write("");
            pw.close();

            for (Map.Entry<String, Double> mapa : m.entrySet()) {
                String nazov = mapa.getKey();
                double cena = mapa.getValue();
                zapisJedlo(nazov, cena);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public double ziskajCenu(String jedlo) {

        for (Map.Entry<String, Double> mapa : jedla.entrySet()) {
            String nazov = mapa.getKey();
            double cena = mapa.getValue();
            if (nazov.equals(jedlo)) {
                return cena;
            }
        }
        return -1;
    }

    @Override
    public void pridajJedlo(String jedlo, double cena) {
        jedla.put(jedlo, cena);
        zapisJedlo(jedlo, cena);
        aktualizujTxt(jedla);

    }

    @Override
    public void zapisJedlo(String jedlo, double cena) {

        try (FileWriter writer = new FileWriter(new File("ceny.txt"), true)) {
            writer.append(jedlo + ";" + cena + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void vymazJedlo(String jedlo, double cena) {
        jedla.remove(jedlo, cena);
    }

    @Override
    public void vymazVsetkyJedla() {
        Map<String, Double> novaMapa = new HashMap<>();
        jedla = novaMapa;
        aktualizujTxt(jedla);

    }

    @Override
    public void zmenCenu(String jedlo, double NovaCena) {
        jedla.remove(jedlo);
        jedla.put(jedlo, NovaCena);

    }

}
