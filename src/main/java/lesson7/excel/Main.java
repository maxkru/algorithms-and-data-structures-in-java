package lesson7.excel;

import lesson7.company.HeadPool;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main {

    private final static String filepath = "CompanyIndicators.xlsx";
    private final static int SHEET_NUMBER = 0;

    private final static int HEAD_COLUMN_NUMBER = 0;
    private final static int SUBSIDIARY_COLUMN_NUMBER = 1;
    private final static int FORECAST_COLUMN_NUMBER = 2;
    private final static int ACTUAL_COLUMN_NUMBER = 3;


    public static void main(String[] args) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(filepath));
        Sheet sheet = workbook.getSheetAt(SHEET_NUMBER);

        HeadPool heads = new HeadPool();


        Iterator<Row> rowIterator = sheet.rowIterator();
        // первая строка - имена столбцов
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            // столбцы листа: Head name | Subsidiary name | forecast | actual

            Cell headCell = row.getCell(HEAD_COLUMN_NUMBER);
            String headName = headCell.getStringCellValue();
            // Head name - допустимы смёрженные ячейки
            if (headName.isEmpty()) {
                for (CellRangeAddress cellRangeAddress : sheet.getMergedRegions()) {
                    if (cellRangeAddress.isInRange(headCell)) {
                        headName = sheet.getRow(cellRangeAddress.getFirstRow()).getCell(HEAD_COLUMN_NUMBER).getStringCellValue();
                    }
                }
            }
            String subsidiaryName = row.getCell(SUBSIDIARY_COLUMN_NUMBER).getStringCellValue();
            double forecast = row.getCell(FORECAST_COLUMN_NUMBER).getNumericCellValue();
            double actual = row.getCell(ACTUAL_COLUMN_NUMBER).getNumericCellValue();
            heads.addSubsidiaryToHead(headName, subsidiaryName, forecast, actual);
        }

        heads.printPlanCompletionPercent();
    }


}
