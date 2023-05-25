package Controls.Items;

import java.io.IOException;
import java.util.Collections;

import Controls.WorkWithFile.file_of_item;
import Models.Items_ett;
import Shareds.CommonMethod;

/**
 * showInfoItemsInList
 */
public class showInfoItemsInItemList {

        public static void Display() throws IOException {
                file_of_item.rFileItem();
                CommonMethod.clrscr();
                Collections.sort(createItemList.ListItem);

                System.out.println(
                                "===============================================================================================");
                System.out.println(
                                "|                                      Danh Sach Mat Hang                      DucHiep-DucToan|");

                System.out.println(
                                "===============================================================================================");
                System.out.printf("|%-25s|%-25s|%-15s|%-10s|%-14s|\n", "Ma mat hang", "Ten mat hang", "Kieu dong goi",
                                "So luong", "Gia");
                System.out.println(
                                "===============================================================================================");

                if (createItemList.ListItem.isEmpty())
                        System.out.println("Danh sach Trong!");
                for (Items_ett x : createItemList.ListItem) {
                        System.out.printf("|%-25s|%-25s|%-15s|%-10d|%-11svnd|\n", x.getID(), x.getName(), x.getType(),
                                        x.getAmount(), x.getCost());
                }
                System.out.print(
                                "===============================================================================================");
        }
}