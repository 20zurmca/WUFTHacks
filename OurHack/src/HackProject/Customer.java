/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackProject;

/**
 *
 * @author cameron
 */
public class Customer {
    
    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    public Customer(String first, String middle, String last)
    {
        firstName = first;
        middleName = middle;
        lastName = last;
    }
    
    @Override
    public String toString()
    {
        return lastName + ", " + firstName + " " + middleName.charAt(0);
    }
}
