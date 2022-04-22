package constant;

public enum BookSpecialization {
    KHTN("Khoa học tự nhiên"),
    VHNT("Văn học nghệ thuật"),
    DTVT("Điện tử viễn thông"),
    CNTT("Công nghệ thông tin");

    public String value;

    BookSpecialization(String value) {
        this.value = value;
    }

}
