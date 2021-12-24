package ru.sfedu.Medicine.model;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;
import java.util.Objects;

public class Complant  implements Serializable {
    public Complant() {
    }
    @CsvBindByName
    private Treatment TreatmentPatient;
    @CsvBindByName
    private Recipe TreatmentRecipe;

    public Treatment getTreatmentPatient() {
        return TreatmentPatient;
    }

    public void setTreatmentPatient(Treatment treatmentPatient) {
        TreatmentPatient = treatmentPatient;
    }

    public Recipe getTreatmentRecipe() {
        return TreatmentRecipe;
    }

    public void setTreatmentRecipe(Recipe treatmentRecipe) {
        TreatmentRecipe = treatmentRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complant complant = (Complant) o;
        return Objects.equals(TreatmentPatient, complant.TreatmentPatient) && Objects.equals(TreatmentRecipe, complant.TreatmentRecipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TreatmentPatient, TreatmentRecipe);
    }

    @Override
    public String toString() {
        return "Complant{" +
                "TreatmentPatient=" + TreatmentPatient +
                ", TreatmentRecipe=" + TreatmentRecipe +
                '}';
    }
}
