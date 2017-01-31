package oliver_daniel.restauracia;

import oliver_daniel.restauracia.Objednavka;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ObjednavkaTableModel extends AbstractTableModel {

    private ObjednavkyDao dnesneObjednavky = ObjectFactory.INSTANCE.getObjednavkaDao();
    private static final String[] NAZVY_STLPCOV = {"Popis", "Cena", "Datum"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return dnesneObjednavky.dajDnesneObjednavky().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Objednavka o = dnesneObjednavky.dajDnesneObjednavky().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getNazov();
            case 1:
                return o.getCena();
            case 2:
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
        Objednavka o = dnesneObjednavky.dajDnesneObjednavky().get(rowIndex);
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

  public  void aktualizovat() {
        fireTableDataChanged();
    }

}
