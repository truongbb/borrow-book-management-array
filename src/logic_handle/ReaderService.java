package logic_handle;

import entity.Reader;
import main.MainRun;

import java.util.Scanner;

public class ReaderService {

    public static void showReader() {
        for (int i = 0; i < MainRun.READERS.length; i++) {
            if (MainRun.READERS[i] == null) {
                continue;
            }
            System.out.println(MainRun.READERS[i]);
        }
    }

    public static void inputNewReader() {
        System.out.print("Xin mời nhập số lượng bạn đọc mới muốn thêm: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            Reader reader = new Reader();
            reader.inputInfo();
            saveReaderInfo(reader);
        }
    }

    public static void saveReaderInfo(Reader reader) {
        for (int j = 0; j < MainRun.READERS.length; j++) {
            if (MainRun.READERS[j] == null) {
                MainRun.READERS[j] = reader;
                return;
            }
        }
    }

    public static boolean isEmptyReader() {
        for (int i = 0; i < MainRun.READERS.length; i++) {
            if (MainRun.READERS[i] != null) {
                return false;
            }
        }
        return true;
    }

}
