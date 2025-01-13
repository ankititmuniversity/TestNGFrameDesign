package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    String path = System.getProperty("user.dir") + "\\credential.xlsx";

    @DataProvider(name = "looping")
    public String[][] getData() throws IOException {

        int ttlRows = XcelUtility.getRowCount(path, "Sheet1");
        int ttlColumns = XcelUtility.getColumnCount(path, "Sheet1", 0);
        String[][] data = new String[ttlRows][ttlColumns];
        for (int i = 1; i <= ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                data[i - 1][j] = XcelUtility.getCellValue(path, "Sheet1", i, j);
            }
        }
        return data;

    }
}
