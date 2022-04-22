package entity;

import constant.BookSpecialization;

import java.util.Scanner;

public class Book implements Inputable {

    private static int AUTO_ID = 10000;

    private int id;
    private String name;
    private String author;
    private BookSpecialization specialization;
    private int publishedYear;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(BookSpecialization specialization) {
        this.specialization = specialization;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", specialization='" + specialization + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }

    @Override
    public void inputInfo() {
        this.id = Book.AUTO_ID++;
        System.out.print("Nhập tên sách: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập tác giả sách: ");
        this.author = new Scanner(System.in).nextLine();
        System.out.print("Nhập năm xuất bản của sách: ");
        this.publishedYear = new Scanner(System.in).nextInt();
        this.inputBookSpecialization();
    }

    private void inputBookSpecialization() {
        System.out.println("Nhập chuyên ngành của sách, chọn 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Điện tử viễn thông");
        System.out.println("3. Văn học nghệ thuật");
        System.out.println("4. Công nghệ thông tin");
        int bookSpecializationInt = 0;
        do {
            bookSpecializationInt = new Scanner(System.in).nextInt();
            if (bookSpecializationInt >= 1 && bookSpecializationInt <= 4) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (bookSpecializationInt) {
            case 1:
                this.setSpecialization(BookSpecialization.KHTN);
                break;
            case 2:
                this.setSpecialization(BookSpecialization.DTVT);
                break;
            case 3:
                this.setSpecialization(BookSpecialization.VHNT);
                break;
            case 4:
                this.setSpecialization(BookSpecialization.CNTT);
                break;
        }
    }

}
