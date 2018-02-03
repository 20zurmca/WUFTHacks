package HackProject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cameron
 */
public class Account {

    private Customer owner;

    private int balance;

    private long acctNum;

    private String status;

    private boolean isJointAcct;

    public Account(Customer owner, long acctNum, int balance, boolean isJointAcct, String status) {
        this.owner = owner;
        this.acctNum = acctNum;
        this.balance = balance;
        this.isJointAcct = isJointAcct;
        this.status = status;

    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(long acctNum) {
        this.acctNum = acctNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsJointAcct() {
        return isJointAcct;
    }

    public void setIsJointAcct(boolean isJointAcct) {
        this.isJointAcct = isJointAcct;
    }

}
