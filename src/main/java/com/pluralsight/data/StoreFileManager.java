package com.pluralsight.data;
import com.pluralsight.business.Store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StoreFileManager {
    private final String fileName;

    public StoreFileManager(String fileName){
        this.fileName = fileName;
    }

    public Store createStore(){
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))
        ) {
             return makeStoreFromEncodedString(bufferedReader.readLine());
        }catch(IOException e){
            throw new RuntimeException("Trouble creating store.");
        }
    }
    private Store makeStoreFromEncodedString(String s){
        String[] storeInfo = s.split("\\|");
        return new Store(storeInfo[0], storeInfo[1], storeInfo[2] );
    }
}
