package ru.sfedu.Medicine.api;

import org.junit.Test;
import ru.sfedu.Medicine.model.ListPatient;


public class DataProviderXmlTest {
    @Test
    public void write () throws Exception {
        ListPatient ListPatient = new ListPatient();
        ListPatient ListPatient2 = new ListPatient();
        ListPatient ListPatient3 = new ListPatient();
        ListPatient.setId(1);
        ListPatient.setName("Oleg");
        ListPatient.setTest2("2");
        ListPatient.setNumPas("12312151");

        ListPatient2.setId(2);
        ListPatient2.setName("Ali");
        ListPatient2.setTest2("228");
        ListPatient2.setNumPas("6018550268");

        ListPatient3.setId(3);
        ListPatient3.setName("Anton");
        ListPatient3.setTest2("332");
        ListPatient3.setNumPas("6018644587");

        DataProviderXml dataproviderXml = new DataProviderXml();
        dataproviderXml.addParticipantRecord(ListPatient);
        dataproviderXml.addParticipantRecord(ListPatient2);
        dataproviderXml.addParticipantRecord(ListPatient3);
    }
    @Test
    public void SearchBy () throws Exception {
    DataProviderXml dataProviderXml = new DataProviderXml();
    String id ="2";
    ListPatient ListPatient = new ListPatient();
        ListPatient =dataProviderXml.SearchBy(id);
        System.out.print(ListPatient.getName() +"\n"+ListPatient.getId() +"\n"+ListPatient.getTest2() +"\n" + ListPatient.getNumPas() +"\n");
        //System.out.print(ListPatient);
    }
    @Test
    public void UpdateName () throws Exception {
        DataProviderXml dataProviderXml = new DataProviderXml();
        ListPatient listPatient = new ListPatient();
        listPatient = dataProviderXml.SearchBy("1");

        //System.out.print(listPatient.getName() +"\n"+listPatient.getId() +"\n"+listPatient.getTest2() +"\n" + listPatient.getNumPas() +"\n");
        DataproviderCsv dr =new DataproviderCsv();
        dataProviderXml.UpdateName(listPatient,"oleg2");

    }
    @Test
    public void DElPatient() throws Exception {

        DataProviderXml dx =new DataProviderXml();
        ListPatient listPatient = new ListPatient();
        listPatient = dx.SearchBy("2");
        System.out.print(listPatient.getName() +"\n"+listPatient.getId() +"\n"+listPatient.getTest2() +"\n" + listPatient.getNumPas() +"\n");

        dx.deletePatient(listPatient);

    }

}