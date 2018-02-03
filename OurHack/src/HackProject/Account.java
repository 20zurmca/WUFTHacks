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
        
    
    
    private String owner;
    private String type;
    private int balance;
    private long acctNum;
    private boolean onlineAccessEnabled;
    private boolean isJointAcct;
    
    public String getOwner(){
        return owner;
    }
    public String getType(){
        return type;
    }
    public int getBalance(){
        return balance;
    }
    public long getAcctNum(){
        return acctNum;
    }
    
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public void setBalance(int balance){
        this.balance = balance;
    }
    
    public void setAcctNum(long acctNum){
        this.acctNum = acctNum;
    }

    /**
     * @return the onlineAccessEnabled
     */
    public boolean isOnlineAccessEnabled() {
        return onlineAccessEnabled;
    }

    /**
     * @param onlineAccessEnabled the onlineAccessEnabled to set
     */
    public void setOnlineAccessEnabled(boolean onlineAccessEnabled) {
        this.onlineAccessEnabled = onlineAccessEnabled;
    }

    /**
     * @return the isJointAcct
     */
    public boolean isIsJointAcct() {
        return isJointAcct;
    }

    /**
     * @param isJointAcct the isJointAcct to set
     */
    public void setIsJointAcct(boolean isJointAcct) {
        this.isJointAcct = isJointAcct;
    }
    
    
    
}
