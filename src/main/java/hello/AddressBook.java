package hello;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;


@Entity
public class AddressBook {
    @OneToMany(cascade=PERSIST)
    private List<BuddyInfo> buddies;


    public List<BuddyInfo> getBuddies() {
        return buddies;
    }
    public void setBuddies(List<BuddyInfo> buddies) { this.buddies = buddies ;}

    public AddressBook() {
        buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo name) {
        buddies.remove(name);
    }

    public int size() {
        return buddies.size();
    }

    public void clear() {
        buddies.clear();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buddies.size(); i++) {
            sb.append(buddies.get(i).toString() + '\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {


    }

    @Override
    public boolean equals(Object o) {
        AddressBook ab = (AddressBook) o;

        for (int i = 0; i < buddies.size(); i++) {
            try {
                BuddyInfo x = this.buddies.get(i);
                BuddyInfo y = ab.buddies.get(i);

                if (!x.equals(y)) return false;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

        }

        return true;
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
