
package oliver_daniel.restauracia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuborovyMenuDao implements MenuDao{

    @Override
    public List<String> getMenu() {
         List<String> menu = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("zoznamJedal.txt"))) {
            while (scanner.hasNextLine()) {
                String riadok = scanner.nextLine();
                menu.add(riadok);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
        
        
    }

    @Override
    public void pridajJedlo(String nazov) {
        
    }

    @Override
    public void setMenu(List<String> menu) {
        
    }
    
    
    
}
