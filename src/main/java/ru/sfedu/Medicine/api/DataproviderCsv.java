package ru.sfedu.Medicine.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Medicine.model.CommandType;
import ru.sfedu.Medicine.model.ListPatient;
import ru.sfedu.Medicine.model.RepositoryType;
import ru.sfedu.Medicine.utils.Constants;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static ru.sfedu.Medicine.utils.ConfigurationUtil.getConfigurationEntry;

public class DataproviderCsv {
    private static Logger log = LogManager.getLogger(DataproviderCsv.class);
    private static final String CSV_PATH = "./src/main/resources/csv/ListPatient.csv";
//    private static final String EXTENSION = "csv";
    private static String line = "";
    private static String IdCsv;
    private static String CSV = "CSV";
    private final String mongoDbName= getConfigurationEntry(Constants.MONGO_DB_NAME);




    public boolean deletePatient(ListPatient Patient) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        log.info("Start delitePatient[1]:");
        try {
            List<ListPatient> beans = readFile();
            ListPatient listPatient = new ListPatient();

            for (int i = 0; i < beans.size(); i++) {
                listPatient = beans.get(i);
                if (listPatient.getName().equals(Patient.getName())) {
                    MongoProvider.save(CommandType.DELETED, RepositoryType.CSV, mongoDbName, beans.get(i));
                    beans.remove(i);
                }
            }

            try {
                writeFile(beans);
                log.info("Finish delitePatient[2]:");

                return writeFile(beans);
            } catch (CsvDataTypeMismatchException e) {
                log.error("delite Error [3]:");
                log.error(e.getClass().getName() + ": " + e.getMessage());
                return false;
            } catch (CsvRequiredFieldEmptyException e) {
                log.error("delite Error[4]:");
                log.error(e.getClass().getName() + ": " + e.getMessage());
                return false;
            }
        }catch (IOException e){
            log.error("delite Error[5]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }


    public void NewPatient(List<ListPatient> ListPatient) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
       /* CSVWriter csvWriter = new CSVWriter(new FileWriter("./src/main/resources/csv/ListPatient.csv"));
        StatefulBeanToCsv<ListPatient> BeanToCsv = new StatefulBeanToCsvBuilder<ListPatient>(csvWriter).withApplyQuotesToAll(false).build();
        BeanToCsv.write(ListPatient);
        csvWriter.close();*/
        writeFile(ListPatient);

    }

    public void ReadAllInfoPatient() throws IOException, CsvException {
        try {
            log.info("Start ReadAllInfoPatient[6]:");
            CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
            log.info("Finish ReadAllInfoPatient[7]:");
        }catch (IOException e){
            log.error("ReadAll Error[8]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
        }catch (CsvException e){
            log.error("ReadAll Error[9]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    //работает и хорошо,нех тут ничего трогать, только копируй,а то я тебя знаю
    public ListPatient SearchBy(String ns) throws IOException {
        try {
            log.info("Start SearchBy[10]:");
            FileReader reader = new FileReader(CSV_PATH);
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
                    br.close();
                    log.info("Finish SearchBy[11]:");
                    return listPatient;
                }
            }
            br.close();
        } catch (Exception e) {
            log.error("SearchBy Error[12]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
        return null;
}

    public  void UpdateName(ListPatient Patient,String Name) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
       try {
           log.info("Start UpdateName[13]:");
           List<ListPatient> beans = readFile();
           ListPatient listPatient = new ListPatient();

           for (int i=0;i<beans.size();i++) {
               listPatient = beans.get(i);
               if(listPatient.getName().equals(Patient.getName())){
                   listPatient.setName(Name);
                   MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, mongoDbName, beans.get(i));
                   beans.set(i,listPatient);
               }
           }
           log.info("Finish UpdateName[15]:");
           writeFile(beans);
       }catch (IOException e){
           log.error("UpdateName Error[16]:");
           log.error(e.getClass().getName() + ": " + e.getMessage());
       }catch (CsvRequiredFieldEmptyException e){
           log.error("UpdateName Error[17]:");
           log.error(e.getClass().getName() + ": " + e.getMessage());
       }catch (CsvDataTypeMismatchException e){
           log.error("UpdateName Error[18]:");
           log.error(e.getClass().getName() + ": " + e.getMessage());
       }

    }

    public List<ListPatient> readFile () throws FileNotFoundException {
        try {
            log.info("Start readFile[19]:");
            List<ListPatient> bean = new CsvToBeanBuilder(new FileReader(CSV_PATH))
                    .withType(ListPatient.class).build().parse();
            log.info("Finish readFile[20]:");
            return bean;
        }
        catch (FileNotFoundException e)
        {
            log.error("readFile Error[21]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
           return null;
        }
    }

    private boolean writeFile(List <?> beans) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        try{
            log.info("Start writeFile[22]:");
            Writer writer = new FileWriter(CSV_PATH,false);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withApplyQuotesToAll(false).build();
            beanToCsv.write(beans);
            writer.close();
            log.info("Finish writeFile[23]:");
            return true;
        }catch (IOException e) {
            log.error("writeFile Error[24]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
        return false;
        }
        catch (CsvRequiredFieldEmptyException e) {
            log.error("writeFile Error [24]:");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        catch (CsvDataTypeMismatchException e) {
            log.error("writeFile Error[25]");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

    }

    /*private <T> boolean writeFile(List<T> beans, Class<?> clazz)  {
        try {
            log.info("Start saveFile[1]:");
            File source = new File(CSV_PATH);
            Writer writer = new FileWriter(source);
            if(beans.isEmpty()) {
                writer.write("");
                log.info("Saving beans is empty, file was deleted");
                return true;
            }
            WrapperXML<T> xml = new WrapperXML<>(beans);
            serializer.write(xml, writer);
            log.info("File Saved[2]:");
            return true;
        }
        catch(Exception e) {
            log.error("saveFile Error");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }*/

    }

