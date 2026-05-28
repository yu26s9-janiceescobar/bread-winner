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
    private final Path parentFolder;
    private final Path receiptPath;
    public ReceiptFileManager(){
        try {
            parentFolder = Path.of("data");
            receiptPath = parentFolder.resolve("receipts");
            Files.createDirectories(receiptPath);
        } catch (IOException e) {
            throw new RuntimeException("Trouble creating folder.", e);
        }
    }

    /**
     * Takes finalized order, formats it and saves it to folder as a txt file with date and time stamp.
     * @param contents String the formatted details of finalized order.
     */
    public void saveReceipt(String contents){
        try{
            Path receiptFile = receiptPath.resolve(
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"))
                            + ".txt");
            Files.writeString(receiptFile, contents);
        } catch (IOException e) {
            throw new RuntimeException("Trouble writing new receipt.", e);
        }
    }
}
