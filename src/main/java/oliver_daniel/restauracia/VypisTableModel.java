package oliver_daniel.restauracia;

import javax.swing.table.AbstractTableModel;

public class VypisTableModel extends AbstractTableModel {

    
    private static final String[] NAZVY_STLPCOV = {"ID", "Popis", "Cena", "Datum"};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return null;
    }

    /*public Objednavka dajKliknutuObjednavku(int rowIndex) {
        Objednavka o = vypis.dajVsetkyObjednavkyVoVypisoch().get(rowIndex);
        aktualizovat();
        return o;
    /*/

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        fireTableDataChanged();
    }

}
