

package HackProject;


import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    
    private String API_key;
    
   public String get_info(String key) throws IOException{
       API_key = key;
       OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-wufthacks.xlabs.one:8243/td/account/V1.0.0/account/all?page=1&size=1")
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("X-Api-Key", key)
                .addHeader("Authorization", "Bearer c229f874-c45a-3e4e-8366-1cf2eee0055c")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "dedf4b7e-c2fe-3d73-deca-bf3cb6b5dd19")
                .build();

        Response response = client.newCall(request).execute();
        
        if (response.isSuccessful()) {
            return response.body().string();
        } else {

            return null;
        }
   }


    private Customer owner;

    
    private int balance;
    
    private long acctNum;
    
    private String status;
    
    private boolean isJointAcct;
    
    
    public Account(Customer owner, long acctNum, int balance, boolean isJointAcct, String status)
    {
        
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
