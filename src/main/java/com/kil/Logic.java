package com.kil;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logic {

    public static String currentTool;
    public static String currentLanguage;


    public static String getCorrectCod_start() {
        switch (currentLanguage) {
            case ("BASIC-256"):
                return "main:";
            case ("C"):
                return "void main(void) {";
            case ("C++"):
                return "void main(void) {";
            case ("Python"):
                return "def main():";
        }
        return "ERROR IN FUNC: not found language";
    }

    public static String getCorrectCod_end() {
        switch (currentLanguage) {
            case ("BASIC-256"):
                return "end";
            case ("C"):
                return "}";
            case ("C++"):
                return "}";
            case ("Python"):
                return "";
        }
        return "ERROR IN FUNC: not found language";
    }

    public static List getCorrectCod_inPut(String par) {
        par = par.replace(" ", "");
        String[] param = par.split(",");
        List<String> result = new ArrayList<>();
        String res = "";

        switch (currentLanguage) {
            case ("BASIC-256"):
                for (String str : param) {
                    result.add("input " + str);
                }
                break;

            case ("C"):
                res += "scanf(";
                for (String str : param) {
                    res += "&" + str + ", ";
                }
                if (res.endsWith(", ")) {
                    res = res.substring(0, res.length() - 2);
                }
                res += ");";
                result.add(res);
                break;

            case ("C++"):
                res += "std::cin";
                for (String str : param) {
                    res += " >> " + str;
                }
                res += ";";
                result.add(res);
                break;

            case ("Python"):
                for (String str : param) {
                    result.add(str + " = input()");
                }
                break;
        }
        return result;
    }

    public static List getCorrectCod_outPut(String par) {
        par = par.replace(" ", "");
        String[] param = par.split(",");
        List<String> result = new ArrayList<>();
        String res = "";

        switch (currentLanguage) {
            case ("BASIC-256"):
                for (String str : param) {
                    result.add("print " + str);
                }
                break;

            case ("C"):
                for (String str : param) {
                    result.add("printf(''&d'', " + str + ");");
                }
                break;

            case ("C++"):
                res += "std::cout";
                for (String str : param) {
                    res += " << " + str;
                }
                res += ";";
                result.add(res);
                break;

            case ("Python"):
                res += "print(";
                for (String str : param) {
                    res += str + ", ";
                }
                if (res.endsWith(", ")) {
                    res = res.substring(0, res.length() - 2);
                }
                res += ")";
                result.add(res);
                break;
        }

        return result;
    }

}
