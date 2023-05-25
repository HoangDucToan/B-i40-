package Controls.Customers;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_customer;
import Models.Customer_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * editCusInList
 */
public class editCusInList {

    static Scanner in = new Scanner(System.in);

    public static void editInfo() throws IOException {
        while (true) {
            String IDCustomer, NameCustomer;
            String NumberCustomer;

            Integer index = -1;
            CommonMethod.clrscr();
            showInfoCusList.Display();
            if (createCustomerList.listCustomer.isEmpty()) {
                System.out.print("\n" + Constants.input_randomKey);
                in.nextLine();
                break;
            }
            System.out.println("======= Cap nhat thong tin khach hang =======\n");
            while (true) {// tìm id khách hàng
                System.out.print("Nhap ma khach hang: ");
                IDCustomer = in.nextLine();
                if (CheckMethodAll.checkID(IDCustomer, new Customer_ett()) != -1) {
                    index = CheckMethodAll.checkID(IDCustomer, new Customer_ett());
                    break;
                } else {
                    System.out.println(Constants.ex_not_find + "ID nay!");
                }
            }
            while (true) {// kiểm tra nhập có đúng hay không.
                System.out.print("Sua ten khach hang (A-Za-z): ");
                NameCustomer = in.nextLine();
                if (CheckMethodAll.checkSpecialCharacterAndNumber(NameCustomer) == 1)
                    break;

            }
            while (true) {
                System.out.print("Sua so dien thoai(0-9) : ");
                NumberCustomer = in.nextLine();
                Integer indexPhone = CheckMethodAll.checkPhoneNumBer(NumberCustomer);
                if (indexPhone == -1 || indexPhone == index) {
                    if (CheckMethodAll.checkSpecialCharacter(NumberCustomer) == 1)
                        if (CheckMethodAll.checkLetterInString(NumberCustomer) == false)
                            break;
                        else
                            System.out.println(Constants.ex_wrong_dataType + "chu so 0-9!");
                } else {
                    System.out.println("SDT" + Constants.already_exits_report);
                }

            }
            System.out.print("Ban co muon cap nhat?(y/n): ");
            if (CommonMethod.yesNo().equalsIgnoreCase("Y")) {
                createCustomerList.listCustomer.get(index).setName(NameCustomer);
                createCustomerList.listCustomer.get(index).setPhoneNumber(NumberCustomer);
                System.out.print("Cap nhat thanh cong!\n");
                file_of_customer.wFileCustomer();
            } else
                System.out.println("Cap nhat khong thanh cong!");
            System.out.print("Ban co muon tiep tuc cap nhat?(y/n) : ");
            if (CommonMethod.yesNo().equalsIgnoreCase("N")) {
                break;
            }
        }

    }

}