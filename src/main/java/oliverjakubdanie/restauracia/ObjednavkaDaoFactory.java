package oliverjakubdanie.restauracia;

public enum ObjednavkaDaoFactory {
    INSTANCE;
    
    public ObjednavkyDao getObjednavkaDao() {
        return new SuborovyObjednavkaDao();
    }
}


