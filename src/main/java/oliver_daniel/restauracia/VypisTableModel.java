package oliver_daniel.restauracia;

import dao.ObjednavkyDao;
import entity.Objednavka;
import entity.Polozka;
import factory.ObjectFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class VypisTableModel extends AbstractTableModel {

    private List<Objednavka> Objednavky = new ArrayList<>();
    private ObjednavkyDao vypis = ObjectFactory.INSTANCE.getObjednavkaDao();
    private static final String[] NAZVY_STLPCOV = {"ID", "Popis", "Suma", "Datum"};
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    public void setMap(List<Objednavka> obj) {
        Objednavky = obj;
    }

    @Override
    public int getRowCount() {
        return Objednavky.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Objednavka[] obj = new Objednavka[Objednavky.size()];
        Objednavky.toArray(obj);
        Objednavka objednavka = obj[rowIndex];

        Objednavka o = vypis.dajVsetkyObjednavky().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return objednavka.getId();
            case 1:
                return objednavka.getPopis();
            case 2:
                return objednavka.getSuma();
            case 3:
                Date datum = objednavka.getCasObjednavky();
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
        Objednavka o =  Objednavky.get(rowIndex);
        aktualizovat();
        return o;
    }



    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        fireTableDataChanged();
    }

}
