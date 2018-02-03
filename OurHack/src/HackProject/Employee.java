/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the  in the editor.
 */
package HackProject;

import java.io.File;
import java.io.*;

/**
 *
 * @author cameron
 */
public class Employee {

    //**************************FIELDS**************************//
    private String firstName;

    private String lastName;

    private File logFile;

    //**************************CONSTRUCTOR**************************//
    public Employee(String fn, String ln) {
        firstName = fn;
        lastName = ln;
        logFile = new File("logFile.txt");
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //**************************FIELDS**************************//
    public void writeheader() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(logFile));
            pw.printf("%-20s%n", firstName + "'s" + "Log File"); //write code here 
            pw.flush();
            pw.close(); //close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(logFile, true));
            pw.println(); //write code here 
            pw.flush();
            pw.close(); //close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString ()
    {
        return firstName + lastName;
    }
}
