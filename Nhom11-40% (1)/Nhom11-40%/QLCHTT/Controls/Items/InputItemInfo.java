package Controls.Items;

import java.util.Scanner;

import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.Constants;

/**
 * InputItemInfo
 */
public class InputItemInfo {
    static Scanner sc = new Scanner(System.in);

    public static void input(Items_ett Item) {
        while (true) {
            System.out.print(Constants.input_type_item);
            Item.setType(sc.nextLine());
            if (CheckMethodAll.checkSpecialCharacterAndNumber(Item.getType()) == 1)
                break;
        }

        while (true) {
            System.out.print(Constants.input_amount_item);
            Item.setAmount(CheckMethodAll.checkIntegerInput());
            if (Item.getAmount() > 0)
                break;
            else
                System.out.println(Constants.ex_amount);
        }

        while (true) {
            System.out.print("- Nhap gia: ");
            Item.setCost(CheckMethodAll.checkIntegerInput());
            if (Item.getCost() > 0)
                break;
            else
                System.out.println(Constants.ex_amount);
        }
    }
}