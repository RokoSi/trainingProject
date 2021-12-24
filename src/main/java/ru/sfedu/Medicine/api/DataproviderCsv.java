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
    //CsvToBean <ListPatient> BeanPatient= new CsvToBean<>();

    public void ReturnFile () throws IOException, CsvException {
        /*CSVReader reader = new CSVReader(new FileReader("./src/main/resources/csv/ListPatient.csv"));
        FileWriter writer = new FileWriter("./src/main/resources/csv/newListPatient.csv");
        CSVWriter csvWriter = new CSVWriter(writer);
        ListPatient ListPatient = new ListPatient();
        StatefulBeanToCsv<ListPatient> BeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(csvWriter).withApplyQuotesToAll(false).build();


        String[] values = line.split(",");
        while ((values = reader.readNext()) != null) {
            ListPatient.setName(values[0]);
            ListPatient.setId(Integer.parseInt(values[1]));
            ListPatient.setTest2(values[2]);
            ListPatient.setNumPas(values[3]);
            BeanToCsv.write(ListPatient);
        }*/
        List<ListPatient> beans = new CsvToBeanBuilder(new FileReader("./src/main/resources/csv/newListPatient.csv"))
                .withType(ListPatient.class).build().parse();
        Writer writer = new FileWriter("./src/main/resources/csv/ListPatient.csv",false);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withApplyQuotesToAll(false).build();
        beanToCsv.write(beans);
        File File =new File("./src/main/resources/csv/newListPatient.csv");
        File.delete();
        writer.close();


        }
    public void NewPatient(List<ListPatient> ListPatient) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        FileWriter writer = new FileWriter("./src/main/resources/csv/ListPatient.csv");
        CSVWriter csvWriter = new CSVWriter(writer);
        StatefulBeanToCsv<ListPatient> BeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(csvWriter).withApplyQuotesToAll(false).build();
        BeanToCsv.write(ListPatient);
        csvWriter.close();
    }

    public void ReadAllInfoPatient() throws IOException, CsvException {

        CSVReader reader = new CSVReader(new FileReader("./src/main/resources/csv/ListPatient.csv"));
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
    }

    public String deletePatient(ListPatient Patient) throws IOException, CsvException {
        FileWriter OldFile = new FileWriter("./src/main/resources/csv/ListPatient.csv",false);
       CSVWriter OldWriter = new CSVWriter(OldFile);
        StatefulBeanToCsv<ListPatient> oldBeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(OldWriter).withApplyQuotesToAll(false).build();

        FileWriter newFile = new FileWriter("./src/main/resources/csv/newListPatient.csv",true);
        CSVWriter newWriter = new CSVWriter(newFile);
        StatefulBeanToCsv<ListPatient> newBeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(newWriter).withApplyQuotesToAll(false).build();
        FileReader reader = new FileReader("./src/main/resources/csv/ListPatient.csv");
        BufferedReader br = new BufferedReader(reader);
        String id= String.valueOf(Patient.getId());
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
         if (values[1].equals(id)) {
            }
        else {
            ListPatient PR = new ListPatient();
             PR.setName(values[0]);
             PR.setId(Integer.parseInt(values[1]));
             PR.setTest2(values[2]);
             PR.setNumPas(values[3]);
             newBeanToCsv.write(PR);

         }
        }
        newWriter.close();
        DataproviderCsv dp = new DataproviderCsv();
        dp.ReturnFile();
            return "Patient";
        }


   public ListPatient UpdateName(ListPatient Patient,String Name) throws IOException, CsvException {
       FileWriter OldFile = new FileWriter("./src/main/resources/csv/ListPatient.csv",true);
       CSVWriter OldWriter = new CSVWriter(OldFile);
       StatefulBeanToCsv<ListPatient> oldBeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(OldWriter).withApplyQuotesToAll(false).build();

       FileWriter newFile = new FileWriter("./src/main/resources/csv/newListPatient.csv",true);
       CSVWriter newWriter = new CSVWriter(newFile);
       StatefulBeanToCsv<ListPatient> newBeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(newWriter).withApplyQuotesToAll(false).build();
       FileReader reader = new FileReader("./src/main/resources/csv/ListPatient.csv");
       BufferedReader br = new BufferedReader(reader);
       String id= String.valueOf(Patient.getId());

       while ((line = br.readLine()) != null) {
           String[] values = line.split(",");
           if (values[0].equals(Patient.getName())) {
               Patient.setName(Name);
               values[0]= Patient.getName();
               ListPatient PR = new ListPatient();
               PR.setName(values[0]);
               PR.setId(Integer.parseInt(values[1]));
               PR.setTest2(values[2]);
               PR.setNumPas(values[3]);
               newBeanToCsv.write(PR);
           }
           else {
               ListPatient PR = new ListPatient();
               PR.setName(values[0]);
               PR.setId(Integer.parseInt(values[1]));
               PR.setTest2(values[2]);
               PR.setNumPas(values[3]);
               newBeanToCsv.write(PR);
           }
       }
       newWriter.close();
       DataproviderCsv dp = new DataproviderCsv();
       dp.ReturnFile();
    return Patient;
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

    }

