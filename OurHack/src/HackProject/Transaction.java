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
public class Transaction {
    
   private Account account; //account in question
    
    private Customer user;
    
    private Employee employee;
    
    
    public Transaction(Account account, Customer user, Employee employee)
    {
        this.account = account;
        this.user = user;
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }
    
     @Override
    public String toString()
    {
      return user + " " + account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }    
}
