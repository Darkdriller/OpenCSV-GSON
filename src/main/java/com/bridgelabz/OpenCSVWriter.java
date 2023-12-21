package com.bridgelabz;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dhruv
 * @project thirdpartylibrary
 */
public class OpenCSVWriter {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\Dhruv\\IdeaProjects\\thirdpartylibrary\\src\\main\\resources\\users.csv";

    public static void main(String[] args) throws IOException,
            CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));

        StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();
        List<CSVUser> users = new ArrayList<>();
        users.add(new CSVUser("Sundar Pichai", "Sundar@gmail.com", "+1-111111111", "USA"));
        users.add(new CSVUser("Satya Nadella", "Satya@gmail.com", "+2-111111111", "USA"));

        beanToCsv.write(users);
    }
}
