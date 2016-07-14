package kata;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {

    List<String> phones = new ArrayList<>();

    public boolean isConsistent() {

        int size = phones.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isPrefix(phones.get(i), phones.get(j)) ||
                        isPrefix(phones.get(j), phones.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPrefix(String phoneA, String phoneB) {
        return phoneA.indexOf(phoneB) == 0;
    }

    public void add(String phoneNumber) {
        phones.add(phoneNumber);
    }

}
