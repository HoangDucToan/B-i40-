package Controls.WorkWithFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Controls.Items.createItemList;
import Models.Items_ett;
import java.util.List;

/**
 * file_of_item
 */
public class file_of_item {

    static String pathItemFile = "./File/items.dat";

    public static void wFileItem() throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream outputStream = null;
        try {

            out = new FileOutputStream(pathItemFile);
            outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(createItemList.ListItem);
        } catch (Exception e) {
        } finally {
            if (out != null) {
                out.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void rFileItem() throws IOException {
        FileInputStream inn = null;
        ObjectInputStream inputStream = null;
        try {
            inn = new FileInputStream(pathItemFile);
            inputStream = new ObjectInputStream(inn);
            createItemList.ListItem = (List<Items_ett>) inputStream.readObject();
        } catch (Exception e) {
        } finally {
            if (inn != null) {
                inn.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}