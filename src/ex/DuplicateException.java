package ex;

import java.util.ArrayList;
import registros.padron.ItemReg;

/**
 *
 * @author fermani
 */
public class DuplicateException extends Exception {

    private ArrayList<ItemReg> items;

    public DuplicateException(String message) {
        super(message);
    }
    

    public void addItem(ItemReg item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public ArrayList<ItemReg> getItems() {
        return items;
    }
}
