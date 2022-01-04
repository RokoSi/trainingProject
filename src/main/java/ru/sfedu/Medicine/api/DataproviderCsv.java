package ru.sfedu.Medicine.api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Medicine.model.ListPatient;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DataproviderCsv {
    private static Logger log = LogManager.getLogger(DataproviderCsv.class);
    private static final String CSV_PATH = "csv_path";
    private static final String EXTENSION = "csv";
    private static String line = "";
    private static String IdCsv;

    public String deletePatient(ListPatient Patient) throws IOException, CsvException {
        List<ListPatient> beans = new CsvToBeanBuilder(new FileReader("./src/main/resources/csv/ListPatient.csv"))
                .withType(ListPatient.class).build().parse();
        ListPatient listPatient = new ListPatient();
        for (int i=0;i<beans.size();i++) {
            listPatient = beans.get(i);
            if(listPatient.getName().equals(Patient.getName())) beans.remove(i);
        }
        Writer writer = new FileWriter("./src/main/resources/csv/ListPatient.csv",false);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withApplyQuotesToAll(false).build();
        beanToCsv.write(beans);
        writer.close();
        return null;
    }


    public void NewPatient(List<ListPatient> ListPatient) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter("./src/main/resources/csv/ListPatient.csv"));
        StatefulBeanToCsv<ListPatient> BeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(csvWriter).withApplyQuotesToAll(false).build();
        BeanToCsv.write(ListPatient);
        csvWriter.close();
    }

    public void ReadAllInfoPatient() throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader("./src/main/resources/csv/ListPatient.csv"));
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
    }

    //работает и хорошо,нех тут ничего трогать, только копируй,а то я тебя знаю
    public ListPatient SearchBy(String ns) throws IOException {
        try {
            FileReader reader = new FileReader("./src/main/resources/csv/ListPatient.csv");
            BufferedReader br = new BufferedReader(reader);
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ListPatient listPatient = new ListPatient();
                if (values[1].equals(ns)) {
                    IdCsv = values[1];
                    listPatient.setName(values[0]);
                    listPatient.setId(Integer.parseInt(values[1]));
                    listPatient.setTest2(values[2]);
                    listPatient.setNumPas(values[3]);
                    return listPatient;
                }
            }
        } catch (Exception e) {
            log.error("getRaceById Error ");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
        return null;
}

    public  void UpdateName(ListPatient Patient,String Name) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<ListPatient> beans = new CsvToBeanBuilder(new FileReader("./src/main/resources/csv/ListPatient.csv"))
                .withType(ListPatient.class).build().parse();
        ListPatient listPatient = new ListPatient();
        for (int i=0;i<beans.size();i++) {
            listPatient = beans.get(i);
            if(listPatient.getName().equals(Patient.getName())){
            listPatient.setName(Name);
                beans.set(i,listPatient);
            }
        }
        Writer writer = new FileWriter("./src/main/resources/csv/ListPatient.csv",false);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withApplyQuotesToAll(false).build();
        beanToCsv.write(beans);
        writer.close();
    }
    }

