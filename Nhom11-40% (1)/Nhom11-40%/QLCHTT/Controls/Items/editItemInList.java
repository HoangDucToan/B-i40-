package Controls.Items;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_item;
import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * editItemInList
 */
public class editItemInList {

    static Scanner in = new Scanner(System.in);

    public static void editInfo() throws IOException {
        String Choice;
        Items_ett Item;
        Integer indexItem = -1;

        while (true) {
            Item = new Items_ett();
            CommonMethod.clrscr();
            showInfoItemsInItemList.Display();
            if (createItemList.ListItem.isEmpty()) {// kiểm tra danh sách trống

                System.out.print("\n" + Constants.input_randomKey);
                in.nextLine();
                break;
            } else {
                System.out.println("\n====== Cap nhat thong tin mat hang =====");

                while (true) {// KIỂM TRA tồn tại id
                    System.out.print("Moi nhap id mat hang muon sua: ");
                    Item.setID(in.nextLine());
                    indexItem = CheckMethodAll.checkID(Item.getID(), Item);
                    if (indexItem != -1) {
                        break;
                    } else {
                        System.out.println(Constants.ex_not_find + "ID!");
                    }
                }

                while (true) { // kiểm tra tên sản phẩm
                    System.out.print("- Sua ten mat hang : ");
                    Item.setName(in.nextLine());
                    Integer indexName = CheckMethodAll.checkName(Item.getName());
                    if (indexName == -1 || indexName == indexItem) {
                        if (CheckMethodAll.checkSpecialCharacter(Item.getName()) == 1)
                            break;
                    } else {
                        System.out.print("Ten mat hang da ton tai!\n");
                    }

                }
                InputItemInfo.input(Item);
                System.out.print("Ban co muon cap nhat?(y/n): ");
                Choice = CommonMethod.yesNo();

                if (Choice.equalsIgnoreCase("Y")) {

                    createItemList.ListItem.set(indexItem, Item);

                    file_of_item.wFileItem();
                    System.out.println("Cap nhat thanh cong!");
                } else
                    System.out.println("Cap nhat khong thanh cong!");
                System.out.print("Ban co muon tiep tuc cap nhat?(y/n): ");
                Choice = CommonMethod.yesNo();
                if (Choice.equalsIgnoreCase("N")) { // kiểm tra case N n
                    break;
                }
            }

        }
    }

}