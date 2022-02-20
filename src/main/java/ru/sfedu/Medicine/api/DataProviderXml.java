package ru.sfedu.Medicine.api;


import com.opencsv.exceptions.CsvException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.Medicine.model.CommandType;
import ru.sfedu.Medicine.model.ListPatient;
import ru.sfedu.Medicine.model.RepositoryType;
import ru.sfedu.Medicine.model.WrapperXML;
import ru.sfedu.Medicine.utils.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static ru.sfedu.Medicine.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderXml {

    private static final String PATH = "./src/main/resources/xml/User.xml";
    //private static final String EXTENSION = ".xml";

    private static final Logger log = LogManager.getLogger(DataProviderXml.class);
    private static final Serializer serializer = new Persister();
    private final String mongoDbName= getConfigurationEntry(Constants.MONGO_DB_NAME);
    public DataProviderXml() throws Exception {}

    public boolean addParticipantRecord(ListPatient patient){
        try{
            List<ListPatient> ListPatient = new ArrayList<>();
            log.info("addParticipantRecord[1]:");
            ListPatient= readFile(ListPatient.class);
            ListPatient.add(patient);
            writeFile(ListPatient, ListPatient.class);
            return true;
        }
        catch (Exception e){
            log.error("addParticipantRecord Error");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
    public ListPatient SearchBy(String ns) throws IOException {
        List<ListPatient> ListPatient = new ArrayList<>();
        ListPatient patient = new ListPatient();
        ListPatient = readFile(ListPatient.class);
        int ns1 = Integer.parseInt(String.valueOf(ns));
        for (int i=0;i<=ListPatient.size();i++) {
            patient = ListPatient.get(i);
            if (patient.getId()== ns1) {
                return patient;
            }
        }
        return null;
    }
    public String deletePatient(ListPatient Patient) throws IOException, CsvException {
        List<ListPatient> beans = new ArrayList<>();
        ListPatient listPatient = new ListPatient();
        beans = readFile(ListPatient.class);
        for (int i = 0; i < beans.size(); i++) {
            listPatient = beans.get(i);
            if(listPatient.getName().equals(Patient.getName())) {
                MongoProvider.save(CommandType.DELETED, RepositoryType.XML, mongoDbName, beans.get(i));
                beans.remove(i);
            }
        }
        writeFile(beans, ListPatient.class);
        return "0";
    }

    public  void UpdateName(ListPatient Patient,String Name) throws IOException {
        List<ListPatient> beans = new ArrayList<>();
        ListPatient listPatient = new ListPatient();
        beans = readFile(ListPatient.class);
        for (int i = 0; i <= beans.size(); i++) {
            listPatient = beans.get(i);
            if (listPatient.getName().equals(Patient.getName())) {
                listPatient.setName(Name);
                MongoProvider.save(CommandType.UPDATED, RepositoryType.XML, mongoDbName, beans.get(i));
                beans.set(i, listPatient);
            }

        }
        writeFile(beans, ListPatient.class);
    }


    private <T> boolean writeFile(List<T> beans, Class<?> clazz)  {
        try {
            log.info("Start saveFile[1]:");
            File source = new File(PATH);
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
    }
    private <T> List<T> readFile(Class<?> clazz){
        List<T> loadedBeans = new ArrayList<>();
        try{
            log.info("Start readFile[1]:");
            File source = new File(PATH);
            if(source.length() != 0) {
                loadedBeans = serializer.read(WrapperXML.class, source).getList();
                log.info("Beans loaded[2]:");
            }
            else
                log.info("Empty beans loaded[2]: ");
        }
        catch(Exception e){
            log.error("readFile Error");
            log.error(e.getClass().getName() + ": " + e.getMessage());
        }
        return loadedBeans;
    }
}


