package com.nutfreedom;

public class SplitFreedom {

    private CheckFreedom cf = new CheckFreedom();

    public SplitFreedom() {

    }

    public String[] split(String val, String cut) {
        String[] arr = new String[0];
        try {
            if (cf.isNotBlank(val)) {
                arr = val.split(cut);
            }
        } catch (Exception e) {
            arr = new String[0];
            printError("split array => val => " + val + " => cut => " + cut);
        }
        return arr;
    }

    public String splitByIndex(String val, String cut, int index) {
        String value = "";
        try {
            if (cf.isNotBlank(val)) {
                value = split(val, cut)[index];
            }
        } catch (Exception e) {
            printError("splitByIndex => val => " + val + " => cut => " + cut + " index => " + index);
        }
        return value;
    }

    private void printError(String msg) {
        System.out.println("SplitFreedom error cannot " + msg);
    }
}
