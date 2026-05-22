package com.pluralsight.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    private final String fileName;
    public FileManager(String fileName){
        this.fileName = fileName;
    }

    public ArrayList<String> getDataFromCsv(){
        ArrayList<String> data = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); // skips first line.

            String line;

            while((line = bufferedReader.readLine()) != null){
                if (!line.isBlank()) {
                    data.add(line); // adds raw data to ArrayList
                }
            }
            bufferedReader.close();
        }catch(IOException e){
            throw new RuntimeException("Trouble reading file.");
        }
        return data;
    }
}
