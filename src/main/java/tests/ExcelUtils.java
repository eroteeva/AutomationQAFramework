package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getCredentialsTestData(File file) throws IOException {
        FileInputStream excelFile = new FileInputStream(file);
        Workbook credentialsDataWorkbook = new XSSFWorkbook(excelFile);

        Object[][] userCredentials = parseCredentialsData(credentialsDataWorkbook);

        return userCredentials;

    }

    private static Object[][] parseCredentialsData(Workbook credentialsDataWorkbook) {
        Sheet dataSheet = credentialsDataWorkbook.getSheet("Credentials");

        int rowsCount = dataSheet.getLastRowNum();

        Object[][] userCredentials = new Object[rowsCount][2];

        List<List<String>> dataList = new ArrayList();
        for (int i = 1; i <= rowsCount; i++) {

            Row row = dataSheet.getRow(i);
            String username = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();

            List<String> credential = new ArrayList<String>();
            credential.add(username);
            credential.add(password);

            dataList.add(credential);
        }

        for (int row = 0; row < dataList.size(); row++) {
            for (int column = 0; column < 2; column++) {
                userCredentials[row][column] = dataList.get(row).get(column);
            }


        }

        return userCredentials;
    }
}
