package kata;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {

    List<String> phones = new ArrayList<>();

    public boolean isConsistent() {
        if (phones.size() < 2) {
            return true;
        }

        return phones.get(0).indexOf(phones.get(1)) != 0;
    }

    public void add(String phoneNumber) {
        phones.add(phoneNumber);
    }

}
