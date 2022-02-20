package ru.sfedu.Medicine.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
@Root
public class ListPatient  implements Serializable {
    @Element
    @CsvBindByPosition(position = 1)
    private int Id;
    @Element
    @CsvBindByPosition(position = 0)
    private String name;
    @Element
    @CsvBindByPosition(position = 2)
    private String test2;
    //@CsvBindByName(column = "test1")
    @Element
    @CsvBindByPosition(position = 3)
    private String NumPas;



    public String getNumPas() {
        return NumPas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public void setNumPas(String NumPas) {
        this.NumPas = NumPas;
    }


    public ListPatient() {

    }
/*
    public PassportInformation getPassInfo() {
        return PassInfo;
    }

    public void setPassInfo(PassportInformation passInfo) {
        PassInfo = passInfo;
    }

    public Complant getComText() {
        return ComText;
    }

    public void setComText(Complant comText) {
        ComText = comText;
    }

    public Analyzes getAnalyzesPatient() {
        return AnalyzesPatient;
    }

    public void setAnalyzesPatient(Analyzes analyzesPatient) {
        AnalyzesPatient = analyzesPatient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPatient that = (ListPatient) o;
        return Objects.equals(PassInfo, that.PassInfo) && Objects.equals(ComText, that.ComText) && Objects.equals(AnalyzesPatient, that.AnalyzesPatient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PassInfo, ComText, AnalyzesPatient);
    }

    @Override
    public String toString() {
        return "ListPatient{" +
                "PassInfo=" + PassInfo +
                ", ComText=" + ComText +
                ", AnalyzesPatient=" + AnalyzesPatient +
                '}';
    }
*/
}
