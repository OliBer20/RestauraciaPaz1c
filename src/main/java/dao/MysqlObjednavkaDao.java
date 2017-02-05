package dao;

import dao.MysqlPolozkaDao;
import dao.ObjednavkyDao;
import entity.Polozka;
import entity.Objednavka;
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
            polozka.put(polozkaDao.dajPodlaId(pol.getId_polozky()), pol.getPocet());
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
        /*List<Objednavka> objednavky = jdbcTemplate.query(sql, new ObjednavkaRowMapper());
        for (Objednavka obj : objednavky) {
            naplnObsahObjednavky(obj);
        }*/
        return (jdbcTemplate.query(sql, new ObjednavkaRowMapper()));
    }

    @Override
    public List<Objednavka> dajObjednavkyNaMesiac(int rok, int mesiac) {
        String sql = "SELECT id_objednavky,popis,suma,datum FROM Objednavka where month(datum) = " + mesiac + " and year(datum) = " + rok + " order by id_objednavky desc";
        List<Objednavka> objednavky = jdbcTemplate.query(sql, new ObjednavkaRowMapper());
        for (Objednavka obj : objednavky) {
            naplnObsahObjednavky(obj);
        }
        return objednavky;
    }

    @Override
    public List<Objednavka> dajObjednavkyNaRok(int rok) {
        String sql = "SELECT id_objednavky,popis,suma,datum FROM Objednavka where year(datum) = " + rok + " order by id_objednavky desc";
        List<Objednavka> objednavky = jdbcTemplate.query(sql, new ObjednavkaRowMapper());
        for (Objednavka obj : objednavky) {
            naplnObsahObjednavky(obj);
        }
        return objednavky;
    }

    @Override
    public List<Objednavka> dajObjednavkyNaDatum(int rok, int mesiac, int den) {
        String sql = "SELECT id_objednavky,popis,suma,datum FROM Objednavka where dayofmonth(datum) = " + den + " and month(datum) = " + mesiac + " and year(datum) = " + rok + " order by id_objednavky desc";
        List<Objednavka> objednavky = jdbcTemplate.query(sql, new ObjednavkaRowMapper());
        for (Objednavka obj : objednavky) {
            naplnObsahObjednavky(obj);
        }
        return objednavky;
    }

    @Override
    public void pridajObjednavku(Objednavka objednavka) {
        jdbcTemplate.update("INSERT INTO Objednavka (popis, suma, datum) VALUES(?,?,?)",
                objednavka.getPopis(), objednavka.getSuma(), objednavka.getCasObjednavky());
        Objednavka novaObjednavka = jdbcTemplate.queryForObject("SELECT id_objednavky,popis,suma,datum "
                + "FROM Objednavka ORDER BY id_objednavky DESC LIMIT 1", new ObjednavkaRowMapper());
        objednavka.setId(novaObjednavka.getId());
        Map<Polozka, Integer> polozky = objednavka.getPolozky();
        for (Polozka polozka : polozky.keySet()) {
            jdbcTemplate.update("INSERT INTO ObsahObjednavky (id_objednavky,id_polozky,pocet) VALUES (?,?,?)",
                    objednavka.getId(), polozka.getId(), polozky.get(polozka));
        }
    }

    @Override
    public void vymazPredosluObjednavku() {
        jdbcTemplate.update("DELETE FROM Objednavka WHERE id_objednavky = max(id_objednavky)");

    }

    private class ObjednavkaRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka objednavka = new Objednavka();
            objednavka.setId(rs.getLong("id_objednavky"));
            objednavka.setPopis(rs.getString("popis"));
            objednavka.setSuma(rs.getDouble("suma"));
            objednavka.setCasObjednavky(rs.getDate("datum"));
            return objednavka;
        }

    }

    private class ObsahObjednavky {

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
