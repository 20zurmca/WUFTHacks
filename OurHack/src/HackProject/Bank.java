/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackProject;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author cameron
 */
public class Bank {
    
    private ArrayList<Account> accounts = new ArrayList<>();
    
    
    public Bank () {
       // loadData(fileName);
    }
    
    
    private void loadData(String fileName)
    {
        BufferedReader reader = null;
        try{
            String line = null;
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){  //have the buffered reader read in the lines
                String [] words = line.split(" "); //split the line into individual words and store in array
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
 
    }
}
