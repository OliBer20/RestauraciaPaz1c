package oliverjakubdanie.restauracia;

import java.util.ArrayList;
import java.util.List;

public class DenneMenu {
    
    public DenneMenu(){
        
        
        
    }

    private List<JednaPolozkaMenu> zoznamDennehoMenu = new ArrayList<>();

    public List<JednaPolozkaMenu> getZoznamDennehoMenu() {
        return zoznamDennehoMenu;
    }

    public void setZoznamDennehoMenu(List<JednaPolozkaMenu> zoznamDennehoMenu) {
        this.zoznamDennehoMenu = zoznamDennehoMenu;
    }

}
