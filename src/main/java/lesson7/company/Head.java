package lesson7.company;

import java.util.ArrayList;
import java.util.List;

public class Head {
    final int id;
    final String name;
    final List<Subsidiary> subsidiaryList;

    public Head(int id, String name) {
        this.id = id;
        this.name = name;
        subsidiaryList = new ArrayList<>();
    }
}
