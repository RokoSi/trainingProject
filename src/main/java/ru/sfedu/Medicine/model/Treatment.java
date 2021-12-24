package ru.sfedu.Medicine.model;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;
import java.util.Objects;

public class Treatment implements Serializable {

    @CsvBindByName
    private String Medicament;

    public Treatment() {
    }

    public String getMedicament() {
        return Medicament;
    }

    public void setMedicament(String medicament) {
        Medicament = medicament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return Medicament == treatment.Medicament;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Medicament);
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "Medicament='" + Medicament + '\'' +
                '}';
    }
}
