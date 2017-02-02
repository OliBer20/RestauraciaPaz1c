package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlPolozkaDao implements PolozkaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlPolozkaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Polozka> dajPolozky() {

        String sql = "SELECT P.id_polozky id_polozky,P.nazov nazov,P.cena cena,K.id_kat id_kat,K.nazov nazov_kat"
                + " FROM Polozka P JOIN Kategoria K ON P.id_kat=K.id_kat ORDER BY id_polozky DESC";
        return jdbcTemplate.query(sql, new PolozkaRowMapper());

    }

    @Override
    public void pridajPolozku(Polozka polozka) {
        try {
            jdbcTemplate.update("INSERT INTO Polozka (nazov, cena,id_kat) VALUES(?,?,?)",
                    polozka.getNazov(), polozka.getCena(),polozka.getKategoria().getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Polozku:" + polozka.getNazov() + " sa nepodarilo vlozit");
        }

    }

    @Override
    public Polozka dajIDPodlaNazvu(String nazov) {
        try {
            return jdbcTemplate.queryForObject("SELECT P.id_polozky id_polozky,P.nazov nazov,"
                    + "P.cena cena,K.id_kat id_kat,K.nazov nazov_kat "
                    + "FROM Polozka P JOIN Kategoria K ON P.id_kat=K.id_kat WHERE P.nazov=?", new PolozkaRowMapper(), nazov);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Polozku:" + nazov + " sa nepodarilo najst");
            return null;
        }

    }
    
    @Override
    public Polozka dajPodlaId(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT P.id_polozky id_polozky,P.nazov nazov,"
                    + "P.cena cena,K.id_kat id_kat,K.nazov nazov_kat "
                    + "FROM Polozka P JOIN Kategoria K ON P.id_kat=K.id_kat WHERE P.id_polozky=?", new PolozkaRowMapper(), id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chyba v mysql polozka dao");
            return null;
        }

    }

    @Override
    public void vymazPolozku(Polozka polozka) {
        jdbcTemplate.update("DELETE FROM Polozka WHERE id_polozky= ?", polozka.getId());
    }

    private class PolozkaRowMapper implements RowMapper<Polozka> {

        @Override
        public Polozka mapRow(ResultSet rs, int i) throws SQLException {
            Polozka n = new Polozka();
            Kategoria kat = new Kategoria();
            kat.setId(rs.getLong("id_kat"));
            kat.setNazov(rs.getString("nazov_kat"));
            n.setId(rs.getLong("id_polozky"));
            n.setCena(rs.getDouble("cena"));
            n.setNazov(rs.getString("nazov"));
            n.setKategoria(kat);
            return n;
        }

    }
}