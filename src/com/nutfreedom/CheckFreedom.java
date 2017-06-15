package com.nutfreedom;

public class CheckFreedom {
    public CheckFreedom() {
    }

    public boolean isNotBlank(String val) {
        return !this.chkNullString(val).equals("");
    }

    public String setValueNotBlank(String val, String valDefault) {
        return this.isNotBlank(val) ? val : valDefault;
    }

    public boolean isBlank(String val) {
        return this.chkNullString(val).equals("");
    }

    public boolean isMoreThanZero(double val) {
        return val > 0.0D;
    }

    public boolean isMoreThanZero(int val) {
        return val > 0;
    }

    public double setValueNotZero(double val, double valDefault) {
        return this.isMoreThanZero(val) ? val : valDefault;
    }

    public double setValueNotZero(int val, int valDefault) {
        return this.isMoreThanZero(val) ? (double) val : (double) valDefault;
    }

    public String setValueNotZero(double val, String valDefault) {
        return this.isMoreThanZero(val) ? String.valueOf(val) : valDefault;
    }

    public String setValueNotZero(int val, String valDefault) {
        return this.isMoreThanZero(val) ? String.valueOf(val) : valDefault;
    }

    public boolean isEquals(String val, String check) {
        return val.equals(check);
    }

    public boolean isEquals(double val, double check) {
        return val == check;
    }

    public boolean isEquals(int val, int check) {
        return val == check;
    }

    public boolean isEqualsIgnoreCase(String val, String check) {
        return val.equals(check);
    }

    public boolean isEqualsIgnoreCase(double val, double check) {
        return val == check;
    }

    public boolean isEqualsIgnoreCase(int val, int check) {
        return val == check;
    }

    public boolean isNotEquals(String val, String check) {
        return !val.equals(check);
    }

    public boolean isNotEquals(double val, double check) {
        return val != check;
    }

    public boolean isNotEquals(int val, int check) {
        return val != check;
    }

    public boolean isHaveData(String val, String find) {
        return val.contains(find);
    }

    public boolean isNotData(String val, String find) {
        return !val.contains(find);
    }

    private String chkNullString(String str) {
        return str != null ? str : "";
    }
}
