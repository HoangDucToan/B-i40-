package Models;

/**
 * Items_ett
 */
public class Items_ett implements java.io.Serializable, Comparable<Items_ett> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String ItemID, nameItem, typeOfItem;
    private Integer amountOfItem, CostOfItem;

    public int compareTo(Items_ett item) {
        if (amountOfItem == item.getAmount()) {
            return 0;
        } else if (amountOfItem < item.getAmount()) {
            return 1;
        } else
            return -1;
    }

    // id
    public String getID() {
        return ItemID;
    }

    public void setID(String ID) {
        ItemID = ID;
    }

    // name
    public String getName() {
        return nameItem;
    }

    public void setName(String Name) {
        nameItem = Name;
    }

    // type
    public String getType() {
        return typeOfItem;
    }

    public void setType(String type) {
        typeOfItem = type;
    }

    // amount
    public Integer getAmount() {
        return amountOfItem;
    }

    public void setAmount(Integer Amount) {
        amountOfItem = Amount;
    }

    public Integer getCost() {
        return CostOfItem;
    }

    public void setCost(Integer Cost) {
        CostOfItem = Cost;
    }

}