package com.company.hashing;

import java.util.List;

public interface ChildI {
    void addChild(Child child);

    void editChild(Child child);

    List<Child> listChild() throws Exception;

    void deleteChild(int id);

}
