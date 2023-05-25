package Controls.Customers;

import java.io.IOException;
import java.util.Collections;

import Controls.WorkWithFile.file_of_customer;
import Models.Customer_ett;
import Shareds.CommonMethod;

/**
 * showInfoCusList
 */
public class showInfoCusList {

        public static void Display() throws IOException {
                file_of_customer.rFileCustomer();
                CommonMethod.clrscr();
                Collections.sort(createCustomerList.listCustomer);
                System.out.print(
                                "==========================================================================================");
                System.out.print(
                                "\n|                               Danh Sach Khach Hang                    DucHiep-DucToan|\n");

                System.out.println(
                                "==========================================================================================");
                System.out.printf("| %-25s | %-25s | %-15s | %-12s |\n", "Ma Khach hang", "Ten khach hang",
                                "So dien thoai", "Diem Thuong");
                System.out.println(
                                "==========================================================================================");
                if (createCustomerList.listCustomer.isEmpty())
                        System.out.println("Danh sach trong!");
                for (Customer_ett x : createCustomerList.listCustomer) {
                        System.out.printf("| %-25s | %-25s | %-15s | %-12s |\n", x.getID(), x.getName(),
                                        x.getPhoneNumber(), x.getRewardPoint());
                }
                System.out.println(
                                "==========================================================================================");
        }

}