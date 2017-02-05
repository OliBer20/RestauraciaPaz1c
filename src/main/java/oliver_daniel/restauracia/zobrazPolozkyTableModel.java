package oliver_daniel.restauracia;

import entity.Polozka;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class zobrazPolozkyTableModel extends AbstractTableModel {

    private Map<Polozka,Integer> polozkyVObjednavke = new HashMap<>();
    private static final String[] NAZVY_STLPCOV = {"Názov", "Cena", "Počet"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    public void setMap(Map<Polozka,Integer> pvo){
        polozkyVObjednavke = pvo;
    }
    
    @Override
    public int getRowCount() {
        return polozkyVObjednavke.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polozka[] polozky = new Polozka[polozkyVObjednavke.size()];
        polozkyVObjednavke.keySet().toArray(polozky);
        Polozka polozka = polozky[rowIndex];
        
        switch (columnIndex) {
            case 0:
                return polozka.getNazov();
            case 1:
                return polozka.getCena();
            case 2:
                return polozkyVObjednavke.get(polozka);
            default:
                return "???";
        }
    }

    public Polozka dajKliknutuPolozku(int rowIndex) {
        Polozka o = ((Polozka[])polozkyVObjednavke.keySet().toArray())[rowIndex];
        aktualizovat();
        return o;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public  void aktualizovat() {
        fireTableDataChanged();
    }

}
