package Shareds;

/**
 * Person
 */
public class Person implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name, ID, phoneNumber;

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String id) {
        ID = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}