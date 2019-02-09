package com.katas;

import java.util.List;

class PhoneList {
    private List<String> phones;

    PhoneList(List<String> phones) {
        this.phones = phones;
    }

    boolean isConsistent() {
        for (var i = 0; i < phones.size(); i++) {
            for (var z = 0; z < phones.size(); z++) {
                if (i == z) continue;

                if (phones.get(i).contains(phones.get(z))) {
                    return false;
                }
            }
        }

        return true;
    }
}
