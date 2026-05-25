package com.pluralsight.data;

import com.pluralsight.business.Store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StoreFileManager {
    private String fileName;
    public StoreFileManager(String fileName){
        this.fileName = fileName;
    }

    public Store createStore(){
        Store s;
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))
        ) {

        }catch(IOException e){
            System.out.println("Trouble creating store.");
        }
    }
    private Store makeStoreFromEncodedString(String s){
        String[] storeInfo = s.split("\\|");
        return new Store(storeInfo[0], storeInfo[1], storeInfo[2]);
    }
}
