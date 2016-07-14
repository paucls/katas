package kata;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {

    List<String> phones = new ArrayList<>();

    public boolean isConsistent() {

        int size = phones.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (phones.get(i).indexOf(phones.get(j)) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public void add(String phoneNumber) {
        phones.add(phoneNumber);
    }

}
