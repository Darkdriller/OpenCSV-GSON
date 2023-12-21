package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dhruv
 * @project thirdpartylibrary
 */
public class OpenCSVAndGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\Dhruv\\IdeaProjects\\thirdpartylibrary\\src\\main\\resources\\users.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "C:\\Users\\Dhruv\\IdeaProjects\\thirdpartylibrary\\src\\main\\resources\\users.json";


    public static void main(String[] args) {
        try{
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder <CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);
            for (CSVUser csvUser:csvUserList){
                System.out.println("Name: " +  csvUser.getName());
                System.out.println("Email: " +  csvUser.getEmail());
                System.out.println("Phone: " +  csvUser.getPhoneNo());
                System.out.println("Country: " +  csvUser.getCountry());
                System.out.println("========================");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
