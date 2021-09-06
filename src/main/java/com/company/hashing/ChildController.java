package com.company.hashing;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChildController extends DatabaseUtil implements ChildI{

    @Override
    public void addChild(Child child) {
        execUpdate(child.createUpdate());
    }

    @Override
    public void editChild(Child child) {
        if (child == null || child.getId() == 0)
            return;
        execUpdate(child.createUpdate());
    }

    @Override
    public List<Child> listChild() throws Exception {
        List<Child> children = new ArrayList<Child>();
        try {
            ResultSet results = execQuery("select * from child");
            while (results.next()){
                Child child = new Child();
                child.setId(results.getInt(1));
                child.setName(results.getString(2));
                child.setDob(results.getDate(3));
                child.setGender(Gender.valueOf(results.getString(4)));
                child.setDose(results.getInt(5));
                child.setMother_name(results.getString(6));
                children.add(child);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return children;
    }

    @Override
    public void deleteChild(int id) {
        execUpdate("delete from child where id=" + id);
    }
}
