package ru.sfedu.Medicine.api;


import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.Medicine.model.User;
import ru.sfedu.Medicine.utils.ConfigurationUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DataProviderXml {

    private static final String PATH = "./src/main/resources/xml/User.xml";
    private static final String EXTENSION = ".xml";

    private static final Logger log = LogManager.getLogger(DataProviderXml.class);
    private static final Serializer serializer = new Persister();

    List<User> UserList = null;
    User UserBean = new User();


    public DataProviderXml() throws Exception {

    }

    public void SaveAllUser(String name, String id,String OMC) throws Exception {

    }

    public void NewPatient(User User) throws Exception {
        try{
            //log.info("addParticipantRecord[1]:");
            if (User == null)
                throw new Exception("Adding record error, record equals null");
            UserList = readFile(ConfigurationUtil.getConfigurationEntry(PATH)+ConfigurationUtil.getConfigurationEntry(EXTENSION));
            UserList.add(User);

            //log.info("Participant added[2]: ".concat(User.toString()));
            //writeFile(UserList, User.class);
            //return true;
        }
        catch (Exception e){
            log.error("addParticipantRecord Error");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            //return false;
        }
        }



    public void showAllInfoPatient() throws Exception {
        //log.info("showAllParticipants[1]:");
        UserList = readFile(ConfigurationUtil.getConfigurationEntry(PATH)+ConfigurationUtil.getConfigurationEntry(EXTENSION));
        for(int i = 0; i< UserList.size(); i++) {
            System.out.println(UserList.get(i));
        }
    }

   // private List<User> readFile(String s) {


    public String SearchBy(String ns) throws IOException {
        return null;
        }
    public void Patient (){
        File file = new File("./src/main/resources/xml/User.xml");
        List list = new ArrayList();
        Serializer serializer = new Persister();

    }

    private <T> List<T> readFile(String path)   {
        List<T> AllBeans = null;
        try {
            checkFile(AllBeans.getClass());
            AllBeans = new CsvToBeanBuilder(new FileReader(path)).withType(AllBeans.getClass()).build().parse();

        }
        catch(Exception e){
            log.error("loadBeanList Error");
            log.error(e.getClass().getName() + ": " + e.getMessage());
        }
        return AllBeans;


    }
    private void checkFile(Class<?> clazz) throws IOException {
        File file = new File(ConfigurationUtil.getConfigurationEntry(PATH)+ConfigurationUtil.getConfigurationEntry(EXTENSION));

    }

    private <T> List<T> readFile(String path, T bean) {
        List<T> UserList = null;
        try {
            //log.info("Start readFile[1]:");
            checkFile(bean.getClass());
            UserList = new CsvToBeanBuilder(new FileReader(path)).withType(bean.getClass()).build().parse();
            //log.info("чтение выполнено[2]:");
        }
        catch(Exception e){
            log.error("ошибка ");

        }
        return UserList;
    }
    /*private <T> boolean writeFile(List<T> beans, Class<?> clazz)  {
        try {

            FileWriter sw = new FileWriter(ConfigurationUtil.getConfigurationEntry(PATH)
                    +ConfigurationUtil.getConfigurationEntry(EXTENSION));
            CSVWriter writer = new CSVWriter(sw);
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
            beanToCsv.write(beans);
            writer.close();

            return true;
        }
        catch(Exception e) {
            //log.error("saveFile Error");
            log.error(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }*/
    }


