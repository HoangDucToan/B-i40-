package Controls.Bills;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import Controls.Customers.createCustomerList;
import Controls.Items.createItemList;
import Controls.Items.showInfoItemsInItemList;
import Models.Bill_ett;
import Models.Customer_ett;
import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;
import Views.Menu;
import Controls.WorkWithFile.*;

public class createBill {

    static Scanner in = new Scanner(System.in);

    public static void createBill() throws IOException {
        file_of_item.rFileItem();
        file_of_customer.rFileCustomer();
        file_of_bill.rFileBill();
        CommonMethod.clrscr();
        // kiểm tra danh sách mặt hàng
        if (!createItemList.ListItem.isEmpty()) {
            // indexKH là index của khách hàng trong list

            Integer intdexCustomer, itemCount = 0, index_ID_Item, amount_Item_On_Bill;
            Bill_ett newBill = new Bill_ett();

            //
            System.out.println("========== Tao Hoa Don ==========");
            while (true) {
                System.out.print("Nhap ma hoa don: ");
                newBill.set_Bill_ID(in.nextLine());
                String id = newBill.get_Bill_ID();
                if (CheckMethodAll.checkSpecialCharacter(newBill.get_Bill_ID()) == 1) {

                    if (CheckMethodAll.checkID(id, newBill) == -1)
                        break;
                    else {
                        System.out.println("Ma hoa don " + Constants.already_exits_report);
                    }
                }
            }
            //
            while (true) {
                System.out.print("Nhap ma khach hang: ");
                String id = in.nextLine();
                intdexCustomer = CheckMethodAll.checkID(id, new Customer_ett());
                if (CheckMethodAll.checkSpecialCharacter(id) == 1) {
                    break;
                }
            }
            //
            while (true) {
                System.out.print("Nhap ma nhan vien thanh toan: ");
                newBill.setStaffID(in.nextLine());
                if (CheckMethodAll.checkSpecialCharacter(newBill.getStaffID()) == 1)
                    break;
            }
            //
            while (true) { // lặp lại thêm mặt hàng
                while (true) { // kiểm tra id mat hang
                    showInfoItemsInItemList.Display();
                    System.out.print("\nNhap ma mat hang  " + (itemCount + 1) + " : ");
                    String id_Item = in.nextLine();
                    index_ID_Item = CheckMethodAll.checkID(id_Item, new Items_ett());
                    // kiểm tra mặt hàng có tồn tại hay không
                    if (index_ID_Item != -1) {
                        // thông báo hết hàng
                        if (createItemList.ListItem.get(index_ID_Item).getAmount() == 0) {
                            System.out.printf("Cua hang da het %s!\n",
                                    createItemList.ListItem.get(index_ID_Item).getName());
                            System.out.print("Ban co muon tiep tuc them mat hang?(Y/N) : ");
                            if (CommonMethod.yesNo().equalsIgnoreCase("N")) {
                                // không thêm hàng nữa thì in ra tiền ghi file.
                                if (itemCount == 0) {
                                    Menu.billManage();
                                } else {
                                    CommonMethod.inTien(newBill);
                                    newBill.setDateCreat(LocalDate.now());
                                    newBill.setTimeCreat(LocalTime.now());
                                    int pointReward;
                                    if (intdexCustomer != -1) {
                                        pointReward = newBill.getToTalBill() / 1000
                                                + createCustomerList.listCustomer.get(intdexCustomer).getRewardPoint();
                                        createCustomerList.listCustomer.get(intdexCustomer).setRewardPoint(pointReward);
                                        file_of_customer.wFileCustomer();
                                    }
                                    createBillList.listBill.add(newBill);
                                    file_of_bill.wFileBill();
                                    Menu.billManage();
                                }
                            }
                        } else {
                            itemCount++;
                            break;
                        }

                    } else {
                        System.out.println("Khong tim thay id!");
                        System.out.print("Ban co muon tiep tuc them mat hang?(Y/N) : ");
                        if (CommonMethod.yesNo().equalsIgnoreCase("N"))
                            Menu.billManage();
                    }

                }
                //
                while (true) {
                    System.out.print("Nhap so luong: ");
                    amount_Item_On_Bill = CheckMethodAll.checkIntegerInput();
                    if (amount_Item_On_Bill > createItemList.ListItem.get(index_ID_Item).getAmount()) {
                        CommonMethod.outputAmountReport(index_ID_Item);
                    } else {
                        if (amount_Item_On_Bill > 0) {
                            Integer amountTotal = createItemList.ListItem.get(index_ID_Item).getAmount()
                                    - amount_Item_On_Bill;

                            createItemList.ListItem.get(index_ID_Item).setAmount(amountTotal);
                            file_of_item.wFileItem();
                            break;
                        } else
                            System.out.println("So luong phai > 0");
                    }

                }
                // tính tổng tiền
                Integer totalMoneyIteam = amount_Item_On_Bill * createItemList.ListItem.get(index_ID_Item).getCost();
                // set tổng tiền bill
                newBill.setTotalBill(newBill.getToTalBill() + totalMoneyIteam);
                // set số lượng items có trong bill.
                newBill.setAmountOfItem(itemCount);
                System.out.print("Ban co muon them mat hang?(y/n) : ");
                String choice = CommonMethod.yesNo();

                if (choice.equalsIgnoreCase("N")) {
                    CommonMethod.inTien(newBill);
                    newBill.setDateCreat(LocalDate.now());
                    newBill.setTimeCreat(LocalTime.now());
                    int pointReward;
                    if (intdexCustomer != -1) {

                        pointReward = newBill.getToTalBill() / 1000
                                + createCustomerList.listCustomer.get(intdexCustomer).getRewardPoint();
                        createCustomerList.listCustomer.get(intdexCustomer).setRewardPoint(pointReward);
                        file_of_customer.wFileCustomer();
                    }
                    createBillList.listBill.add(newBill);
                    file_of_bill.wFileBill();
                    break;
                }

            }
        } else {
            System.out.print("Chua co mat hang nao het!" + "\n" + Constants.input_randomKey);
            in.nextLine();
        }
    }

}