/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author duytr
 */
public class Validation {

    private final static Scanner in = new Scanner(System.in);

    public static int getInt(String mess, String errorNumberFormat, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println("Please enter number in rage [" + min + ", " + max + "]");
            } else {
                return ret;
            }
        }
    }
    public static int getInt2(String mess, String errorNumberFormat, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex2(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println("Please enter number in rage [" + min + ", " + max + "]");
            } else {
                return ret;
            }
        }
    }
    
    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex)||output.isEmpty()) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static String getStringByRegex2(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex)||output.isEmpty()) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static boolean pressYNtoContinue(String mess) {
        //"Do you want to continue (Y/N): "
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

}
