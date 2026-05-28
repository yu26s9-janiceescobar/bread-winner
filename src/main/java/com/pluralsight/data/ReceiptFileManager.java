package com.pluralsight.data;
import com.pluralsight.business.Order;
import com.pluralsight.ui.ReceiptFormatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)
public class ReceiptFileManager {

    private final String FOLDER_NAME;
    public ReceiptFileManager(){
        FOLDER_NAME = "receipts";
        try {
            Files.createDirectories(Path.of(FOLDER_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Trouble creating folder.", e);
        }
    }

    /**
     * Takes finalized order, formats it and saves it to folder as a txt file with date and time stamp.
     * @param order the checked out order.
     */
    public void saveReceipt(Order order){
        String fileName = FOLDER_NAME + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try(PrintWriter printWriter = new PrintWriter(fileName)){
            printWriter.print(ReceiptFormatter.format(order));
        } catch (IOException e) {
            throw new RuntimeException("Trouble writing new receipt.", e);
        }
    }
}
