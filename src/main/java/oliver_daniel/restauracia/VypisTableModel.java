package oliver_daniel.restauracia;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class VypisTableModel extends AbstractTableModel {

    private vypisDao vypis = ObjectFactory.INSTANCE.getVypis();

    private static final String[] NAZVY_STLPCOV = {"ID" ,"Popis", "Cena", "Datum"};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return vypis.dajVsetkyObjednavky().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }
 
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Objednavka o = vypis.dajVsetkyObjednavky().get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return o.getId();
            case 1:
                return o.getNazovJedla();
            case 2:
                return o.getCenaJedla();
            case 3:
                Date datum = o.getCasObjednavky();
                if (datum == null) {
                    return "Neplatny Cas";
                } else {
                    return datum;
                }
            default:
                return "???";
        }
    }

    public Objednavka dajKliknutuObjednavku(int rowIndex) {
        Objednavka o = vypis.dajVsetkyObjednavky().get(rowIndex);
        aktualizovat();
        return o;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    void aktualizovat() {
        fireTableDataChanged();
    }

}
