package Controls.Customers;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_customer;
import Models.Customer_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * addCusToList
 */
public class addCusToList {
    static Scanner in = new Scanner(System.in);

    public static void addCustomer() throws IOException {

        Customer_ett newCus;
        file_of_customer.rFileCustomer();
        while (true) {// Y/y : thêm 1 khách hàng nữa
            CommonMethod.clrscr();

            newCus = new Customer_ett();

            System.out.println("============= Them moi khach hang =============\n");
            while (true) {// kiểm tra trùng mã.
                System.out.print("- Nhap ma khach hang: ");
                newCus.setID(in.nextLine());
                if (CheckMethodAll.checkID(newCus.getID(), newCus) == -1) {
                    if (CheckMethodAll.checkSpecialCharacter(newCus.getID()) == 1)
                        break;
                } else {
                    System.out.println("ID " + Constants.already_exits_report);
                }
            }
            while (true) {// Kiểm tra kí tự đặc biệt thoi
                System.out.print("- Nhap ten khach hang(a-z): ");
                newCus.setName(in.nextLine());
                if (CheckMethodAll.checkSpecialCharacterAndNumber(newCus.getName()) == 1)
                    break;
            }
            while (true) {// kiểm tra nhập có đúng là sđt không(chỉ nhận chữ số) và kiểm tra xem đã tồn
                          // tại số đt này hay chưa(làm gì có 2 số đt giống nhau được :v)
                System.out.print("- Nhap so dien thoai (0-9): ");
                newCus.setPhoneNumber(in.nextLine());
                if (CheckMethodAll.checkPhoneNumBer(newCus.getPhoneNumber()) == -1) {f
                    if (CheckMethodAll.checkSpecialCharacter(newCus.getPhoneNumber()) == 1)
                        if (CheckMethodAll.checkLetterInString(newCus.getPhoneNumber()) == false)
                            break;
                        else
                            System.out.println(Constants.ex_wrong_dataType + "chu so : 0-9");

                } else
                    System.out.println("SDT " + Constants.already_exits_report);
            }
            newCus.setRewardPoint(0);
            createCustomerList.listCustomer.add(newCus);
            file_of_customer.wFileCustomer();
            System.out.println("Them thanh cong!");
            System.out.print(Constants.input_y_n);
            String yn = CommonMethod.yesNo();
            if (yn.equals("n") || yn.equals("N")) {
                break;
            }
        }

    }

}