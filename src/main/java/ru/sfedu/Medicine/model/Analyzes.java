package ru.sfedu.Medicine.model;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;
import java.util.Objects;

public class Analyzes implements Serializable {
    public boolean simplenameclass;
    @CsvBindByName
    private String NewAssignment;

    public Analyzes() {
    }

    public String getNewAssignment() {
        return NewAssignment;
    }

    public void setNewAssignment(String newAssignment) {
        NewAssignment = newAssignment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analyzes analyzes = (Analyzes) o;
        return Objects.equals(NewAssignment, analyzes.NewAssignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NewAssignment);
    }

    @Override
    public String toString() {
        return "Analyzes{" +
                "NewAssignment='" + NewAssignment + '\'' +
                '}';
    }
}
