package ru.sfedu.Medicine.model;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.io.Serializable;
import java.util.Objects;

public class PassportInformation implements Serializable {

    @CsvBindByName
    private String Name;
    @CsvBindByName
    private String Surname;
    @CsvBindByName
    private String Patronymic;
    @CsvBindByName
    private int PhoneNum;
    @CsvBindByName
    private int NumOMC;
    @CsvBindByName
    private int NumPassport;
    @CsvBindByName @CsvDate
    private int DateOfBirth;
    @CsvBindByName
    private String Address;

    public PassportInformation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassportInformation that = (PassportInformation) o;
        return Name == that.Name && PhoneNum == that.PhoneNum && NumOMC == that.NumOMC && NumPassport == that.NumPassport && DateOfBirth == that.DateOfBirth && Objects.equals(Surname, that.Surname) && Objects.equals(Patronymic, that.Patronymic) && Objects.equals(Address, that.Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Surname, Patronymic, PhoneNum, NumOMC, NumPassport, DateOfBirth, Address);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public int getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        PhoneNum = phoneNum;
    }

    public int getNumOMC() {
        return NumOMC;
    }

    public void setNumOMC(int numOMC) {
        NumOMC = numOMC;
    }

    public int getNumPassport() {
        return NumPassport;
    }

    public void setNumPassport(int numPassport) {
        NumPassport = numPassport;
    }

    public int getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "PassportInformation{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", PhoneNum=" + PhoneNum +
                ", NumOMC=" + NumOMC +
                ", NumPassport=" + NumPassport +
                ", DateOfBirth=" + DateOfBirth +
                ", Address='" + Address + '\'' +
                '}';
    }
}
