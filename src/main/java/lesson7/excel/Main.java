package lesson7.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class Main {

    private final static String filepath = "input.xls";

    public static void main(String[] args) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(filepath));
    }


}
