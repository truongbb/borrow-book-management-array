package logic_handle;

import entity.Book;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Reader;
import main.MainRun;

import java.util.Scanner;

public class BorrowBookService {

    public static void sortBorrow() {
        System.out.println("Nhập lựa chọn của bạn: ");
        System.out.println("1. Sắp xếp theo tên bạn đọc.");
        System.out.println("2. Sắp xếp theo số lượng cuốn sách được mượn (giảm dần).");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        if (choice == 1) { // sắp xếp theo tên bạn đọc
            for (int i = 0; i < MainRun.BORROWS.length - 1; i++) {
                if (MainRun.BORROWS[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < MainRun.BORROWS.length; j++) {
                    if (MainRun.BORROWS[j] == null) {
                        continue;
                    }
                    if (MainRun.BORROWS[i].getReader().getName().compareTo(MainRun.BORROWS[j].getReader().getName()) > 0) {
                        BookBorrow temp = MainRun.BORROWS[i];
                        MainRun.BORROWS[i] = MainRun.BORROWS[j];
                        MainRun.BORROWS[j] = temp;
                    }
                }
            }
            showBorrowBook();
        } else if (choice == 2) { // sắp xếp theo số lượng cuốn sách

        }
    }

    public static void searchBorrowByReader() {
        System.out.print("Nhập tên bạn đọc mà bạn muốn tìm kiếm: ");
        String keyword = new Scanner(System.in).nextLine();
        for (int i = 0; i < MainRun.BORROWS.length; i++) {
            if (MainRun.BORROWS[i] != null && MainRun.BORROWS[i].getReader().getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(MainRun.BORROWS[i]);
            }
        }
    }

    public static void showBorrowBook() {
        for (int i = 0; i < MainRun.BORROWS.length; i++) {
            if (MainRun.BORROWS[i] != null) {
                System.out.println(MainRun.BORROWS[i]);
            }
        }
    }

    public static void borrowBook() {

        if (BookService.isEmptyBook() || ReaderService.isEmptyReader()) {
            System.out.println("Cần thực hiện nhập sách và bạn đọc trước khi cho mượn sách");
            return;
        }

        System.out.print("Nhập vào số lượng bạn đọc muốn mượn sách: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            // thực hiện cho mượn sách cho bạn đọc thứ i

            // nhập bạn đọc muốn mượn sách
            Reader reader = inputReaderInfo(i);

            // nhập danh sách sách mà bạn đọc muốn mượn
            BookBorrowDetail[] bookBorrowDetails = inputBorrowBookDetail();

            BookBorrow bookBorrow = new BookBorrow(reader, bookBorrowDetails);// 1 lượt mượn sách
            saveBorrowBook(bookBorrow);
        }
    }

    public static void saveBorrowBook(BookBorrow bookBorrow) {
        for (int j = 0; j < MainRun.BORROWS.length; j++) {
            if (MainRun.BORROWS[j] == null) {
                MainRun.BORROWS[j] = bookBorrow;
                break;
            }
        }
    }

    public static BookBorrowDetail[] inputBorrowBookDetail() {
        System.out.print("Nhập số lượng đầu sách mà bạn đọc này muốn mượn: ");
        int bookQuantity = -1;
        do {
            bookQuantity = new Scanner(System.in).nextInt();
            if (bookQuantity > 0 && bookQuantity <= 5) {
                break;
            }
            System.out.print("Ông chỉ được mượn 5 đầu sách thôi, đọc có hết không, nhập lại đi: ");
        } while (true);

        // nhập từng cuốn sách và số lượng muốn mượn tương ứng
        BookBorrowDetail[] bookBorrowDetails = new BookBorrowDetail[bookQuantity];
        for (int j = 0; j < bookQuantity; j++) {
            System.out.println("Nhập mã đầu sách thứ " + (j + 1) + " mà bạn đọc này muốn mượn: ");
            Book book = null;
            do {
                int bookId = new Scanner(System.in).nextInt();
                for (int k = 0; k < MainRun.BOOKS.length; k++) {
                    if (MainRun.BOOKS[k] != null && MainRun.BOOKS[k].getId() == bookId) {
                        book = MainRun.BOOKS[k];
                        break;
                    }
                }
                if (book != null) {
                    break;
                }
                System.out.print("Không tìm thấy sách mang mã vừa nhập, vui lòng nhập lại: ");
            } while (true);


            System.out.print("Đầu sách này bạn muốn mượn bao nhiêu cuốn: ");
            int quantity = -1;
            do {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0 && quantity <= 3) {
                    break;
                }
                System.out.print("Ông chỉ được mượn 3 cuốn tối đa cho 1 đầu sách thôi, nhập lại đi: ");
            } while (true);

            BookBorrowDetail bookBorrowDetail = new BookBorrowDetail(book, quantity);
            for (int k = 0; k < bookBorrowDetails.length; k++) {
                if (bookBorrowDetails[k] == null) {
                    bookBorrowDetails[k] = bookBorrowDetail;
                    break;
                }
            }
        }
        return bookBorrowDetails;
    }

    public static Reader inputReaderInfo(int order) {
        System.out.print("Nhập vào mã bạn đọc thứ " + (order + 1) + " muốn mượn sách: ");
        Reader reader = null;
        do {
            int readerId = new Scanner(System.in).nextInt();
            for (int j = 0; j < MainRun.READERS.length; j++) {
                if (MainRun.READERS[j] != null && MainRun.READERS[j].getId() == readerId) {
                    reader = MainRun.READERS[j];
                    break;
                }
            }
            if (reader != null) {
                break;
            }
            System.out.print("Không tìm thấy bạn đọc mang mã vừa nhập, vui lòng nhập lại: ");
        } while (true);
        return reader;
    }

}
