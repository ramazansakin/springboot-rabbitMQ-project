package com.sakinramazan.java8.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Student.class)
public class Student {

    private String sName;
    private String sId;
    private String schoolName;

    public Student() {
    }

    public Student(String sName, String sId, String schoolName) {
        this.sName = sName;
        this.sId = sId;
        this.schoolName = schoolName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sName='" + sName + '\'' +
                ", sId='" + sId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
