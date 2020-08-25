package edu.javacourse.studentorder.domain;

public class StudentOrder {
    private String hFirstName;
    private String hFLastName;
    private String wFirstName;
    private String wFLastName;

    public String gethFirstName() {
        return hFirstName;
    }

    public void sethFirstName(String hFirstName) {
        this.hFirstName = hFirstName;
    }

    public String gethFLastName() {
        return hFLastName;
    }

    public void sethFLastName(String hFLastName) {
        this.hFLastName = hFLastName;
    }

    public String getwFirstName() {
        return wFirstName;
    }

    public void setwFirstName(String wFirstName) {
        this.wFirstName = wFirstName;
    }

    public String getwFLastName() {
        return wFLastName;
    }

    public void setwFLastName(String wFLastName) {
        this.wFLastName = wFLastName;
    }
}
