/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the  in the editor.
 */
package HackProject;

import java.io.File;
import java.io.IOException;

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
    public void logout() {
    }

}
