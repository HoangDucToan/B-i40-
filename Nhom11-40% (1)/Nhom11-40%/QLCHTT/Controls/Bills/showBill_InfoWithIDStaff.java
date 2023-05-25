package Controls.Bills;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_bill;
import Shareds.CommonMethod;

/**
 * showInfoWithIDStaff
 */
public class showBill_InfoWithIDStaff {
    static Scanner in = new Scanner(System.in);

    public static void displayWithIdStaff() throws IOException {
        CommonMethod.clrscr();
        file_of_bill.rFileBill();
        String id;
        if (createBillList.listBill.size() > 0) {
            System.out.println("======================= Hoa Don Theo Ma Nhan Vien =======================");
            while (true) {
                System.out.print("\nNhap ma nhan vien thanh toan: ");
                int index = -1;
                id = in.nextLine();
                for (int i = 0; i < createBillList.listBill.size(); i++) {
                    if (createBillList.listBill.get(i).getStaffID().equals(id)) {
                        index = i;
                    }
                }
                if (index != -1) {
                    CommonMethod.displayBillWithIdStaff(id);
                    System.out.print("Nhap 1 nut bat ki...");
                    in.nextLine();
                    break;
                } else {
                    System.out.println("Khong ton tai ma nhan vien : " + id + "!");
                    System.out.print("Nhap 1 nut bat ki...");
                    in.nextLine();
                    break;
                }
            }

        } else {
            System.out.print("Chua co hoa don nao het!\nNhap 1 nut bat ki...");
            in.nextLine();
        }
    }
}