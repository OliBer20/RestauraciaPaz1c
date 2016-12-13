package oliver_daniel.restauracia;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class jedloSCenou  {

    private String jedlo;
    private double cena;

    public double getCena() {
        return cena;
    }

    public String getJedlo() {
        return jedlo;
    }

    public void setJedlo(String jedlo) {
        this.jedlo = jedlo;
    }
    
    
    public void setCena(double cena) {
        this.cena = cena;
    }

}
