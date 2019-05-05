package com.kil;


import com.kil.components.MyComponent;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public static String currentTool;
    public static String currentLanguage;

    public static MyComponent currentCom;

    public static void setCurrentCom(MyComponent com) {
        if (currentCom == com) {
            currentCom = null;
            com.setStyle("");
            return;
        }

        if (currentCom != null)
            currentCom.setStyle("");
        currentCom = com;
        com.setStyle("-fx-background-color: #abcdef");
    }

    // очень много функций для получение кода указанного языка
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

    public static String getCorrectCod_endIf() {
        switch (currentLanguage) {
            case ("BASIC-256"):
                return "end if";
            case ("C"):
                return "}";
            case ("C++"):
                return "}";
            case ("Python"):
                return "";
        }
        return null;
    }

    public static List getCorrectCod_midIf() {
        List<String> result = new ArrayList<>();
        switch (currentLanguage) {
            case ("BASIC-256"):
                result.add("else");
                break;
            case ("C"):
                result.add("}");
                result.add("else {");
                break;
            case ("C++"):
                result.add("}");
                result.add("else {");
                break;
            case ("Python"):
                result.add("else:");
                break;
        }
        return result;
    }

    public static String getCorrectCod_startIf(String par) {
        par = par.replace("?", "");
        String result = "";

        switch (currentLanguage) {
            case ("BASIC-256"):
                result = "if " + par + " then";
                break;
            case ("C"):
                result = "if (" + par + ") {";
                break;
            case ("C++"):
                result = "if (" + par + ") {";
                break;
            case ("Python"):
                result = "if " + par + ":";
                break;
        }
        return result;
    }

    public static List getCorrectCod_action(String par) {
        par = par.replace(" ", "");
        String[] param = par.split("=");
        List<String> result = new ArrayList<>();
        String res = "";

        switch (currentLanguage) {
            case ("BASIC-256"):
                res += param[0] + " = " + param[1];
                break;

            case ("C"):
                res += param[0] + " = " + param[1] + ";";
                break;

            case ("C++"):
                res += param[0] + " = " + param[1] + ";";
                break;

            case ("Python"):
                res += param[0] + " = " + param[1] + ";";
                break;
        }
        result.add(res);
        return result;
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


    public static List getCorrectCod_func(String par) {
        List<String> result = new ArrayList<>();
        String res = "";
        switch (currentLanguage) {
            case ("BASIC-256"):
                res = par;
                break;

            case ("C"):
                res = par + ";";
                break;

            case ("C++"):
                res = par + ";";
                break;

            case ("Python"):
                res = par + ";";
                break;
        }
        result.add(res);
        return result;
    }
}
