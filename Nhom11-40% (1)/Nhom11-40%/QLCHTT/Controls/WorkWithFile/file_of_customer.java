package Controls.WorkWithFile;

/**
 * file_of_customer
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Controls.Customers.createCustomerList;
import Models.Customer_ett;
import java.util.List;

public class file_of_customer {
    static String pathCustomerFile = "./File/customers.dat";

    public static void rFileCustomer() throws IOException {

        FileInputStream inn = null;
        ObjectInputStream inputStream = null;

        try {
            inn = new FileInputStream(pathCustomerFile);
            inputStream = new ObjectInputStream(inn);

            createCustomerList.listCustomer = (List<Customer_ett>) inputStream.readObject();
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

    public static void wFileCustomer() throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream outputStream = null;
        try {
            out = new FileOutputStream(pathCustomerFile);
            outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(createCustomerList.listCustomer);
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
}