package Models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Bill_ett
 */
public class Bill_ett implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String ID, StaffID;
    private Integer amountItem = 0, totalBil = 0;

    private LocalDate dateCreatBill;
    private LocalTime timeCreatBill;

    public LocalTime getTimeCreat() {
        return timeCreatBill;
    }

    public void setTimeCreat(LocalTime x) {
        timeCreatBill = x;
    }

    public LocalDate getDateCreat() {

        return dateCreatBill;
    }

    public void setDateCreat(LocalDate x) {
        dateCreatBill = x;
    }

    public Integer getAmountOfItem() {
        return amountItem;
    }

    public void setAmountOfItem(Integer x) {
        amountItem = x;
    }

    public Integer getToTalBill() {
        return totalBil;
    }

    public void setTotalBill(Integer x) {
        totalBil = x;
    }

    public void set_Bill_ID(String ID) {
        this.ID = ID;
    }

    public String get_Bill_ID() {
        return ID;
    }

    public void setStaffID(String ID) {
        StaffID = ID;
    }

    public String getStaffID() {
        return StaffID;
    }

}