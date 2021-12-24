package ru.sfedu.Medicine.api;


import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.IOException;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;


public class DataProviderXml {

    public static Wrapper readFile(String subjectsFilePath) throws Exception {
        File file = new File("./src/main/resources/xml/User.xml");
        Serializer serializer = new Persister();
        Wrapper wrapper = serializer.read(Wrapper.class, file);
        return wrapper;
    }
    /*public static  void write(String filePath, T object) throws Exception {
        try {фывфывфы
            createFileIfNotExists(filePath);
        } catch (Exception e) {
master            //log.error("write[1]: error = {}", e.getMessage());
        }

        Serializer serializer = new Persister();
        File file = new File(filePath);
        Wrapper<User> wrapper = new Wrapper<>();
        try {
            boolean isFound = false;
            wrapper = serializer.read(Wrapper.class, file);
            List<OnlyId> list = wrapper.getList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(object.getId())) {
                    list.set(i, object);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                list.add(object);
            }
        } catch (XMLStreamException e) {
            List list = new ArrayList<>();
            list.add(object);
            wrapper.setList(list);
        } catch (Exception e) {
            log.error("write[2]: error = {}", e.getMessage());
        }

        serializer.write(wrapper, file);
    }*/

    public DataProviderXml() throws Exception {
    }
    public void SaveAllUser(String name, String id,String OMC) throws Exception {

    }

    public void NewPatient(/*String name, String id,String OMC*/) throws Exception {

        }



    public void ReadAllInfoPatient() throws Exception {

    }
    public String SearchBy(String ns) throws IOException {
        return null;
        }
    public void Patient (){
        File file = new File("./src/main/resources/xml/User.xml");
        List list = new ArrayList();
        Serializer serializer = new Persister();

    }
    }
