package main;

import entity.Book;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Reader;
import logic_handle.BookService;
import logic_handle.BorrowBookService;
import logic_handle.ReaderService;

import java.util.Comparator;
import java.util.Scanner;

public class MainRun {

    public static Reader[] READERS = new Reader[100];
    public static Book[] BOOKS = new Book[100];
    public static BookBorrow[] BORROWS = new BookBorrow[100];

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    BookService.inputNewBook();
                    break;
                case 2:
                    BookService.showBook();
                    break;
                case 3:
                    ReaderService.inputNewReader();
                    break;
                case 4:
                    ReaderService.showReader();
                    break;
                case 5:
                    BorrowBookService.borrowBook();
                    BorrowBookService.showBorrowBook();
                    break;
                case 6:
                    BorrowBookService.sortBorrow();
                    break;
                case 7:
                    BorrowBookService.searchBorrowByReader();
                    break;
                case 8:
//                    System.exit(0);
                    isExit = true;
            }
        } while (!isExit);
    }

    private static int functionChoice() {
        showMenu();
        System.out.print("Xin mời chọn chức năng: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    private static void showMenu() {
        System.out.println("\n\n\n----------PHẦN MỀM QUẢN LÝ MƯỢN SÁCH THƯ VIỆN------------");
        System.out.println("1. Nhập đầu sách mới.");
        System.out.println("2. In ra danh sách sách trong thư viện.");
        System.out.println("3. Nhập bạn đọc mới.");
        System.out.println("4. In ra danh sách bạn đọc trong thư viện.");
        System.out.println("5. Thực hiện cho mượn sách.");
        System.out.println("6. Sắp xếp danh sách mượn sách.");
        System.out.println("7. Tìm kiếm trong danh sách mượn sách theo tên bạn đọc.");
        System.out.println("8. Thoát chương trình.");
    }

}
