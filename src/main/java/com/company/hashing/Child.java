package com.company.hashing;

import java.util.Date;
import java.util.Random;

public class Child {
    private int id;
    private String name;
    private Date dob;
    private Gender gender;
    private String immuzation;
    private int dose;
    private String mother_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImmuzation() {
        return immuzation;
    }

    public void setImmuzation(String immuzation) {
        this.immuzation = immuzation;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String createUpdate(){
        String sql;
        if (getId() == 0){
            sql = "insert into child(id,name,dob, gender,immunization,dose,mother) values(";
            sql += new Random().nextInt() + ",";
            sql += "'" + getName() + "',";
            sql += "'" + getDob() + "',";
            sql += "'" + (getGender() == null ? "NA" : getGender().name()) + "',";
            sql += "'" + getImmuzation() + "',";
            sql += "'" + getDose() + "',";
            sql += "'" + getMother_name() + "')";
        }else {
            sql = "update child set ";

            String setCol = "";

            if (getName() != null && !getName().trim().equals(""))
                setCol += "name='" + getName() + "',";

            if (!setCol.equals("") && getDob() != null)
                setCol += ",dob='" + getDob() + "',";

            if (!setCol.equals("") && getGender() != null)
                setCol += ",gender='" + getGender().name() + "',";

            if (!setCol.equals("") && getImmuzation() != null)
                setCol += ",immunization='" + getImmuzation() + "',";

            if (!setCol.equals(""))
                setCol += ",dose='" + getDose() + "',";

            if (getName() != null && !getMother_name().trim().equals(""))
                setCol += ",mother='" + getMother_name() + "',";

            sql += setCol;

            sql += " where id=" + getId();
        }
        System.out.println("Executing sql: " + sql);

        return sql;
    }
}
