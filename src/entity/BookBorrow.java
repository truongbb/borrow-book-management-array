package entity;

import java.util.Arrays;

// 1 lượt mượn sách
public class BookBorrow {

    /**
     * 1 bạn đọc - nhiều sách (mỗi sách thì lại có 1 số lượng mượn khác nhau)
     * <p>
     * Bạn đọc A:
     * - Giải tích ==> 2 cuốn
     * - Anh hùng xạ điêu ==> 1 cuốn
     * - Conan ==> 1 cuốn
     */

    private Reader reader;
    private BookBorrowDetail[] bookBorrowDetails;

    public BookBorrow() {
    }

    public BookBorrow(Reader reader, BookBorrowDetail[] bookBorrowDetails) {
        this.reader = reader;
        this.bookBorrowDetails = bookBorrowDetails;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public BookBorrowDetail[] getBookBorrowDetails() {
        return bookBorrowDetails;
    }

    public void setBookBorrowDetails(BookBorrowDetail[] bookBorrowDetails) {
        this.bookBorrowDetails = bookBorrowDetails;
    }

    @Override
    public String toString() {
        return "BookBorrow{" +
                "reader=" + reader +
                ", bookBorrowDetails=" + Arrays.toString(bookBorrowDetails) +
                '}';
    }
}
