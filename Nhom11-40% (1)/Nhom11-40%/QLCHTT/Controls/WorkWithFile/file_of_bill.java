package Controls.WorkWithFile;

/**
 * file_of_bill
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Controls.Bills.createBillList;
import Models.Bill_ett;

public class file_of_bill {

    static String pathBillFile = "./File/bills.dat";

    public static void wFileBill() throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream outputStream = null;
        try {
            out = new FileOutputStream(pathBillFile);
            outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(createBillList.listBill);
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

    public static void rFileBill() throws IOException {
        FileInputStream inn = null;
        ObjectInputStream inputStream = null;
        try {

            inn = new FileInputStream(pathBillFile);
            inputStream = new ObjectInputStream(inn);
            createBillList.listBill = (List<Bill_ett>) inputStream.readObject();
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