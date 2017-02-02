package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlObjednavkaDao implements ObjednavkyDao {

    private JdbcTemplate jdbcTemplate;
    private MysqlPolozkaDao polozkaDao;
    
    public MysqlObjednavkaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        polozkaDao = new MysqlPolozkaDao(jdbcTemplate);
    }

    @Override
    public void naplnObsahObjednavky(Objednavka objednavka) {
        String sql = "SELECT id_objednavky,id_polozky,pocet "
                + "FROM ObsahObjednavky "
                + "WHERE id_objednavky=?";

        List<ObsahObjednavky> a = jdbcTemplate.query(sql, new PolozkaRowMapper(), objednavka.getId());
        Map<Polozka, Integer> polozka = new HashMap<>();
        for (ObsahObjednavky pol : a) {
            polozka.put(polozkaDao.dajPodlaId(pol.getId_polozky()),pol.getPocet());
        }
        objednavka.setPolozky(polozka);
    }

    @Override
    public List<Objednavka> dajVsetkyObjednavky() {
        String sql = "SELECT id_objednavky,popis,suma,datum "
                + "FROM Objednavka ORDER BY id_objednavky DESC";
        List<Objednavka> objednavky = jdbcTemplate.query(sql, new ObjednavkaRowMapper());
        for (Objednavka obj : objednavky) {
            naplnObsahObjednavky(obj);
        }
        return objednavky;
    }

    @Override
    public Objednavka dajObjednavku(Long id) {
        String sql = "SELECT id_objednavky,popis,suma,datum "
                + "FROM Objednavka WHERE id_objednavky=?";
        Objednavka objednavka = jdbcTemplate.queryForObject(sql, new ObjednavkaRowMapper(), id);
        naplnObsahObjednavky(objednavka);
        return objednavka;
    }

    @Override
    public void odstranObjednavku(Objednavka objednavka) {
        jdbcTemplate.update("DELETE FROM Objednavka WHERE id_objednavky = ?",
                objednavka.getId());
    }

    @Override
    public List<Objednavka> dajDnesneObjednavky() {
        String sql = "SELECT id_objednavky,popis,suma,datum FROM Objednavka WHERE DATE(datum) = DATE(NOW()) ORDER BY id_objednavky DESC";
        List<Objednavka> objednavky = jdbcTemplate.query(sql, new ObjednavkaRowMapper());
        for (Objednavka obj : objednavky) {
            naplnObsahObjednavky(obj);
        }
        return objednavky;
    }

    @Override
    public void pridajObjednavku(Objednavka objednavka) {
        jdbcTemplate.update("INSERT INTO Objadnavka (popis, suma, datum) VALUES(?,?,?)",
                objednavka.getPopis(), objednavka.getSuma(), objednavka.getCasObjednavky());
        Map<Polozka, Integer> polozky = objednavka.getPolozky();
        for (Polozka polozka : polozky.keySet()) {
            jdbcTemplate.update("INSERT INTO ObsahObjednavky (id_objednavky,id_polozky,pocet) VALUES (?,?,?)",
                    objednavka.getId(), polozka.getId(), polozky.get(polozka));
        }
    }

    private class ObjednavkaRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka objednavka = new Objednavka();
            objednavka.setId(rs.getLong("id"));
            objednavka.setPopis(rs.getString("nazov"));
            objednavka.setSuma(rs.getDouble("cena"));
            objednavka.setCasObjednavky(rs.getDate("datum"));
            return objednavka;
        }

    }
    
    private class ObsahObjednavky{
        Long id_polozky;
        Integer pocet;

        public Long getId_polozky() {
            return id_polozky;
        }

        public Integer getPocet() {
            return pocet;
        }

        public void setId_polozky(Long id_polozky) {
            this.id_polozky = id_polozky;
        }

        public void setPocet(Integer pocet) {
            this.pocet = pocet;
        }
        
    }

    private class PolozkaRowMapper implements RowMapper<ObsahObjednavky> {

        @Override
        public ObsahObjednavky mapRow(ResultSet rs, int i) throws SQLException {
            ObsahObjednavky n = new ObsahObjednavky();
            n.setId_polozky(rs.getLong("id_polozky"));
            n.setPocet(rs.getInt("pocet"));
            return n;
        }

    }
}