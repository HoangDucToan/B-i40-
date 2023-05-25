package Views;

import Controls.Bills.ShowBill_InfoWithDateCrate;
import Controls.Bills.createBill;
import Controls.Bills.showBill_InfoWithIDStaff;
import Controls.Customers.*;
import Controls.Items.*;

import java.io.IOException;
import java.util.Scanner;

import Shareds.CommonMethod;

/**
 * Untils
 */
public class Menu {

    static Scanner in = new Scanner(System.in);

    public static Boolean isEmpty = createItemList.ListItem.isEmpty();
    public static Boolean isEmpty2 = createCustomerList.listCustomer.isEmpty();

    public static void MainMenu() throws IOException {
        String Choose;
        CommonMethod.clrscr();
        while (true) {
            System.out.println("==================================");
            System.out.println("--- Chao Mung Den Voi SHOP T & H ---");
            System.out.println("==================================");
            System.out.println("| 1. Quan ly danh sach mat hang  |");
            System.out.println("| 2. Quan Ly Khach Hang          |");
            System.out.println("| 3. Quan Ly Hoa Don             |");
            System.out.println("| 0. Thoat                       |");
            System.out.println("==================================");
            System.out.print("#Chon: ");
            while (true) {
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        itemManage();
                        break;
                    case "2":
                        customManage();
                        break;
                    case "3":
                        billManage();
                        break;
                    case "0":
                        in.close();
                        System.out.println("...\nCam on quy khach.");
                        System.exit(0);
                        break;
                    default:
                        System.out.print("Khong co chuc nang " + Choose + " Moi nhap lai : ");
                        break;
                }
            }
        }

    }

    public static void customManage() throws IOException {
        String Choose;

        while (true) {
            CommonMethod.clrscr();
            System.out.println("======================================");
            System.out.println("|--- Quan ly danh sach khach hang ---|");
            System.out.println("|====================================|");
            System.out.println("| 1. Xem danh sach cac khach hang    |");
            System.out.println("| 2. Cap nhat thong tin khach hang   |");
            System.out.println("| 3. Them moi 1 khach hang           |");
            System.out.println("| 0. Tro ve menu chinh               |");
            System.out.println("======================================");
            System.out.print(" #Chon: ");
            while (true) {
                Integer i = -1;
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        i += 1;
                        showInfoCusList.Display();
                        System.out.print("Nhap 1 nut bat ki...");
                        in.nextLine();
                        break;
                    case "2":
                        i += 1;
                        editCusInList.editInfo();
                        break;

                    case "3":
                        i += 1;
                        addCusToList.addCustomer();
                        break;
                    case "0":
                        MainMenu();
                    default:
                        System.out.print("Nhap sai! Moi nhap lai: ");
                        break;
                }
                if (i != -1)
                    break;
            }
        }
    }

    public static void itemManage() throws IOException {

        String Choose;
        while (true) {
            CommonMethod.clrscr();
            System.out.println("==================================");
            System.out.println("--- Quan ly danh sach mat hang ---");
            System.out.println("==================================");
            System.out.println("| 1. Xem danh sach cac mat hang  |");
            System.out.println("| 2. Cap nhat thong tin mat hang |");
            System.out.println("| 3. Them moi 1 mat hang         |");
            System.out.println("| 0. Tro ve menu chinh           |");
            System.out.println("==================================");
            System.out.print("#Chon: ");
            while (true) {
                Integer check = -1;
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        check += 1;
                        showInfoItemsInItemList.Display();
                        System.out.print("\nNhap 1 nut bat ki...");
                        in.nextLine();
                        break;
                    case "2":
                        check += 1;
                        editItemInList.editInfo();
                        break;
                    case "3":
                        check += 1;
                        addItemToList.addItem();
                        break;
                    case "0":
                        MainMenu();
                        break;
                    default:
                        System.out.print("Khong co chuc nang " + Choose + " Moi nhap lai : ");
                        break;
                }
                if (check != -1)
                    break;

            }
        }
    }

    public static void billManage() throws IOException {
        String Choose;

        while (true) {
            CommonMethod.clrscr();
            System.out.println("=====================================================================");
            System.out.println("|----------------- Quan ly Hoa Don ------------------DucHiep-DucToan|");
            System.out.println("|===================================================================|");
            System.out.println("| 1. Tao Hoa Don                                                    |");
            System.out.println("| 2. Hien thi hoa don theo ma nhan vien thanh toan                  |");
            System.out.println("| 3. Hien thi hoa don theo ngay tao                                 |");
            System.out.println("| 0. Tro ve menu chinh                                              |");
            System.out.println("=====================================================================");
            System.out.print(" #Chon: ");
            while (true) {
                Integer i = -1;
                Choose = in.nextLine();
                switch (Choose) {
                    case "1":
                        i += 1;
                        createBill.createBill();
                        break;
                    case "2":
                        showBill_InfoWithIDStaff.displayWithIdStaff();
                        i += 1;
                        break;

                    case "3":
                        ShowBill_InfoWithDateCrate.displayWithDateCreat();
                        i += 1;
                        break;
                    case "0":
                        MainMenu();
                    default:
                        System.out.print("Nhap sai! Moi nhap lai: ");
                        break;
                }
                if (i != -1)
                    break;
            }
        }
    }

}