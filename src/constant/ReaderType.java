package constant;

public enum ReaderType {

    SINH_VIEN("Sinh viên"),
    HOC_VIEN_CAO_HOC("Học viên cao học"),
    GIAO_VIEN("Giáo viên");

    public String value;

    ReaderType(String value) {
        this.value = value;
    }
}
