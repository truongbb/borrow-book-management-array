package entity;

import java.util.Scanner;

public abstract class Person implements Inputable {

    protected int id;
    protected String name;
    protected String address;
    protected String gender;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void inputInfo() {
        System.out.print("Nhập tên bạn đọc: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ bạn đọc: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập giới tính bạn đọc: ");
        this.setGender(new Scanner(System.in).nextLine());
    }

}
