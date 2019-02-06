package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    private String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        phoneNumber = phone;
    }
    public BuddyInfo(BuddyInfo bi) {
        this(bi.name, bi.address, bi.phoneNumber);
    }
    public BuddyInfo(String name)
    {
        this(name, "", "");
    }

    public BuddyInfo() {
        this("","","");
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString() {
        return getName() + "," + getAddress() + "," + getPhoneNumber();
    }

    @GeneratedValue
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
