package entity;

import constant.ReaderType;

import java.util.Scanner;

public class Reader extends Person implements Comparable<Reader> {

    private static int AUTO_ID = 10000;

    private ReaderType readerType;

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", readerType=" + readerType.value +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        this.id = Reader.AUTO_ID++;
        this.inputReaderType();
    }

    public void inputReaderType() {
        System.out.println("Nhập loại bạn đọc, vui lòng chọn 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Sinh viên.");
        System.out.println("2. Học viên cao học.");
        System.out.println("3. Giáo viên.");
        int readerTypeInt = 0;
        do {
            readerTypeInt = new Scanner(System.in).nextInt();
            if (readerTypeInt >= 1 && readerTypeInt <= 3) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (readerTypeInt) {
            case 1:
                this.setReaderType(ReaderType.SINH_VIEN);
                break;
            case 2:
                this.setReaderType(ReaderType.HOC_VIEN_CAO_HOC);
                break;
            case 3:
                this.setReaderType(ReaderType.GIAO_VIEN);
                break;
        }
    }

    /**
     * int result = a.compareTo(b)
     * <p>
     * - result < 0: a < b
     * - result = 0: a = b
     * - result > 0: a > b
     */
    @Override
    public int compareTo(Reader reader) {
        if (this.id > reader.getId()) {
            return 1;
        } else if (this.id < reader.getId()) {
            return -1;
        }
        return 0;
    }
}
