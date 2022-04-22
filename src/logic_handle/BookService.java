package logic_handle;

import entity.Book;
import main.MainRun;

import java.util.Scanner;

public class BookService {

    public static void inputNewBook() {
        System.out.print("Xin mời nhập số lượng sách mới muốn thêm: ");
        int bookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < bookNumber; i++) {
            Book book = new Book();
            book.inputInfo();
            saveBookInfo(book);
        }
    }

    public static void saveBookInfo(Book book) {
        for (int j = 0; j < MainRun.BOOKS.length; j++) {
            if (MainRun.BOOKS[j] == null) {
                MainRun.BOOKS[j] = book;
                return;
            }
        }
    }

    public static void showBook() {
        for (int i = 0; i < MainRun.BOOKS.length; i++) {
            if (MainRun.BOOKS[i] == null) {
                continue;
            }
            System.out.println(MainRun.BOOKS[i]);
        }
    }


    public static boolean isEmptyBook() {
        for (int i = 0; i < MainRun.BOOKS.length; i++) {
            if (MainRun.BOOKS[i] != null) {
                return false;
            }
        }
        return true;
    }


}
