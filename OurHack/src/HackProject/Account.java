package HackProject;


import java.io.IOException;
import java.util.Scanner;
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
    private boolean success;
    public Account(){
        success = false;
    
    }
    public boolean getSuccess(){
        
        return success;
    }
    public void run(String key){
        String info = null;
        try{
            
        info = get_info(key);
            
        }catch(IOException e){
            System.out.println("Not getting account information");
        }
        
        if(info!= null){
            //System.out.println(info);
            general_info = info;
            parse();
        }
        
        
    }
    
    private void parse(){
        if(general_info!=null){
        String step_1 = general_info.replaceAll("[^a-zA-Z0-9.,:_\\s]+","");
        String[] step_2 = step_1.split(",");
        for(int i = 0; i < step_2.length; i++){
            String line = step_2[i];
            String[] element = line.split(":");
            if(element[0].equalsIgnoreCase("accountId")){
                account_ID = Integer.parseInt(element[1]);
                //System.out.println(account_ID);
            }
            if(element[0].equalsIgnoreCase("accountClosingDate")){
                account_closing_date = element[1];
                //System.out.println(account_closing_date);
            }
            if(element[0].equalsIgnoreCase("accountType")){
                accountType = element[1];
               
                //System.out.println(accountType);
            }
            if(element[0].equalsIgnoreCase("accountOpeningDate")){
                account_opening_date = element[1];
                //System.out.println(account_opening_date);
            }
            if(element[0].equalsIgnoreCase("active")){
                if(element[1].equalsIgnoreCase("Y")){
                active = true;
                }else{
                   active = false; 
                }
                //System.out.println(active);
            }
            if(element[0].equalsIgnoreCase("description")){
                description = element[1];
                //System.out.println(description);
            }
            
            if(element[0].equalsIgnoreCase("annualPercentageRate")){
                annualPercentageRate = Double.parseDouble(element[1]);
                //System.out.println(annualPercentageRate);
            }
            
            if(element[0].equalsIgnoreCase("interestRate")){
                interestRate = Double.parseDouble(element[1]);
                //System.out.println(interestRate);
            }
            
            if(element[0].equalsIgnoreCase("creditLimit")){
                creditLimit = Double.parseDouble(element[1]);
                //System.out.println(creditLimit);
            }
            
            if(element[0].equalsIgnoreCase("accountNumber")){
                accountNumber = Long.parseLong(element[1]);
                //System.out.println(accountNumber);
            }
            
            if(element[0].equalsIgnoreCase("alterDate")){
                alterDate = Long.parseLong(element[1]);
                //System.out.println(alterDate);
            }
            
            if(element[0].equalsIgnoreCase("balance")){
                balance = Double.parseDouble(element[1]);
                //System.out.println(balance);
            }
            
            if(element[0].equalsIgnoreCase("businessUnit")){
                
                businessUnitId = Integer.parseInt(element[element.length-1]);
                //System.out.println(businessUnitId);
            }
            
            if(element[0].equalsIgnoreCase("address")){
                
                address = element[element.length-1];
                String str = step_2[++i];
                String[] parts = str.split(":");
                while(parts.length == 1){
                    address = address + "_"+ parts[0];
                    str = step_2[++i];
                    parts = str.split(":");
                }
                i--;
                //System.out.println(address);
            }
            
            if(element[0].equalsIgnoreCase("bankName")){
                
                bankName = element[element.length-1];
                //System.out.println(bankName);
            }
            
            if(element[0].equalsIgnoreCase("bankRegNumber")){
                
                bankRegNumber = element[element.length-1];
                //System.out.println(bankRegNumber);
            }
            
            if(element[0].equalsIgnoreCase("country")){
                
                country = element[element.length-1];
                //System.out.println(country);
            }
            
            if(element[0].equalsIgnoreCase("registeredAddress")){
                
                registeredAddress = element[element.length-1];
                 String str = step_2[++i];
                String[] parts = str.split(":");
                while(parts.length == 1){
                    registeredAddress = registeredAddress + "_"+ parts[0];
                    str = step_2[++i];
                    parts = str.split(":");
                }
                i--;
                //System.out.println(registeredAddress);
            }
            
            if(element[0].equalsIgnoreCase("unitName")){
                
                unitName = element[element.length-1];
                //System.out.println(unitName);
            }
            
            if(element[0].equalsIgnoreCase("routingNumber")){
                
                routingNumber = element[element.length-1];
                //System.out.println(routingNumber);
            }
            
            if(element[0].equalsIgnoreCase("isJointAccount")){
                if(element[element.length-1].equalsIgnoreCase("Y")){
                    isJointAccount = true;
                    
                }else{
                    isJointAccount = false;
                }
                
                //System.out.println(isJointAccount);
            }
            
            if(element[0].equalsIgnoreCase("isOnlineAccessEnabled")){
                if(element[element.length-1].equalsIgnoreCase("Y")){
                    isOnlineAccessEnabled = true;
                    
                }else{
                    isOnlineAccessEnabled = false;
                }
                
                //System.out.println(isOnlineAccessEnabled);
            }
            
            if(element[0].equalsIgnoreCase("status")){
                
                status = element[element.length-1];
                //System.out.println(status);
            }
            
            if(element[0].equalsIgnoreCase("version")){
                
                version = element[element.length-1];
                //System.out.println(version);
            }
            
        }
        //System.out.println(step_2[28]);
                }
    }
    
    
    
    
    
    private String version;
    
    private boolean isOnlineAccessEnabled;
    
    private boolean isJointAccount;
    
    private String general_info;
    
    private String unitName;
    
    private String bankRegNumber;
    
    private String routingNumber;
    
    private String registeredAddress;
    
    private String country;
    
    private String API_key;
    
    private String bankName;
    
    private String accountType;
    
    //dont have
    private Customer owner;
    
    private int account_ID;
    
    private int bankId;
    
    private String account_closing_date;
    
    private String account_opening_date;
    
    private boolean active;
    
    private String description;
    
    private double interestRate;
    
    private double annualPercentageRate;
    
    private double creditLimit;
    
    private long alterDate;
    
    private String address;

    private double balance;
    
    private int businessUnitId;

    private long accountNumber;

    private String status;

    private boolean isJointAcct;
    
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
        //System.out.println(response.body().string());
        if (response.isSuccessful()) {
            success = true;
            return response.body().string();
        } else {
            //System.out.println("get_info error");
            success = false;
            return null;
        }
   }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAcctNum() {
        return accountNumber;
    }

    public void setAcctNum(long acctNum) {
        this.accountNumber = acctNum;
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
