package ru.sfedu.Medicine.api;

import com.opencsv.exceptions.CsvException;
import org.junit.Test;
import ru.sfedu.Medicine.model.ListPatient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DataproviderCsvTest {


    @Test
    public void inserUsers() {
        try {
            List<ListPatient> Patient = new ArrayList<>();
            DataproviderCsv DateproviderCsv = new DataproviderCsv();

            ListPatient PatientOne =new ListPatient();
            PatientOne.setNumPas("6018033704");
            PatientOne.setId(1);
            PatientOne.setName("Oleg");
            PatientOne.setTest2("12");

            ListPatient PatientTwo =new ListPatient();
            PatientTwo.setNumPas("6018550268");
            PatientTwo.setId(2);
            PatientTwo.setName("Ali");
            PatientTwo.setTest2("228");

            ListPatient PatientTree =new ListPatient();
            PatientTree.setNumPas("6018644587");
            PatientTree.setId(3);
            PatientTree.setName("Anton");
            PatientTree.setTest2("332");

            ListPatient Patient4 =new ListPatient();
            Patient4.setNumPas("6018123456");
            Patient4.setId(4);
            Patient4.setName("Anna");
            Patient4.setTest2("114");


            Patient.add(PatientOne);
            Patient.add(PatientTwo);
            Patient.add(PatientTree);
            Patient.add(Patient4);
            DateproviderCsv.NewPatient(Patient);
            assertTrue(true);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        ;
    }
    @Test
    public void ReadPatient() throws IOException, CsvException {
        DataproviderCsv dateprv =new DataproviderCsv();
        dateprv.ReadAllInfoPatient();
    }

   @Test
    public void SearchById() throws IOException {
       String idCsv ="2";
        DataproviderCsv dateprV =new DataproviderCsv();
        ListPatient NumPatient1 = new ListPatient();
        NumPatient1 = dateprV.SearchBy(idCsv);
        //System.out.print();
       String id = "1";
       ListPatient NumPatient2 = new ListPatient();
        NumPatient2= dateprV.SearchBy(id);

    }

    @Test
    public void DElPatient() throws IOException, CsvException {
        String id = "2";
        DataproviderCsv dateprV =new DataproviderCsv();
        ListPatient NumPatient1 = new ListPatient();
        NumPatient1 = dateprV.SearchBy(id);
        dateprV.deletePatient(NumPatient1);

    }

    @Test
    public void UpdatePatient() throws IOException, CsvException {
        DataproviderCsv dataproviderCsv = new DataproviderCsv();
        ListPatient listPatient = new ListPatient();
        listPatient = dataproviderCsv.SearchBy("1");
        //System.out.print(listPatient.getName() +"\n"+listPatient.getId() +"\n"+listPatient.getTest2() +"\n" + listPatient.getNumPas() +"\n");

       dataproviderCsv.UpdateName(listPatient,"oleg2");


    }
    @Test
    public void TestRet() throws CsvException, IOException {
        DataproviderCsv dataprov =new DataproviderCsv();
        ListPatient patient = new ListPatient();
        String idCsv ="2";
        ListPatient NumPatient1 = new ListPatient();
        dataprov.ReturnFile();
    }


}

