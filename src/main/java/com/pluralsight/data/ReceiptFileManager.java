package com.pluralsight.data;

import com.pluralsight.business.Order;
import com.pluralsight.models.OrderableItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReceiptFileManager {
    private String fileName;
    public ReceiptFileManager(){
        fileName = "data/receipts.csv";
    }
    public void saveReceipt(Order order){
        LocalDateTime.now();
        try(
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))
            ) {
                ArrayList<OrderableItem> orders = order.getOrder();
                bufferedWriter.write("Order Summary");
                for(OrderableItem item: orders){
                    bufferedWriter.write(String.format("%s ----- ",item.getName(), item.getPrice()));
                }

        } catch (IOException e) {
            throw new RuntimeException("Cannot save new dealership file.");
        }
    }
}
