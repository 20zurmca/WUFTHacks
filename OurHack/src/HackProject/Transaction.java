/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackProject;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author cameron
 */
public class Transaction {

    private boolean success;

    private String general_transaction;

    private Customer A, B;

    public Transaction() {
        success = false;
        general_transaction = null;
        A = new Customer();
        B = new Customer();
    }

    public boolean getSuccess() {

        return success;
    }

    public void run(String key) {
        String trans = null;
        try {

            trans = getTrans(key);

        } catch (IOException e) {
            System.out.println("Not getting transaction information");
        }

        if (trans != null) {
            //System.out.println(info);
            general_transaction = trans;
            parse();
        }
    }

    public void parse() {
        if (general_transaction != null) {
            String step_1 = general_transaction.replaceAll("[^a-zA-Z0-9.,:_\\s]+", "");
            String[] end = step_1.split("counterPartyAccount");
            String[] step_2 = end[0].split(",");
            String[] step_3 = end[1].split(",");
            setCustomer(A, step_2);
            setCustomer(B, step_3);
        }
    }

    public void setCustomer(Customer customer, String[] step_2) {
        for (int i = 0; i < step_2.length; i++) {
                String line = step_2[i];
                String[] element = line.split(":");
                if (element[0].equalsIgnoreCase("content")) {
                    transactionId = element[element.length - 1];
                    //System.out.println(transactionId);
                }
                if (element[0].equalsIgnoreCase("account")) {
                    A.setAccountID(element[element.length - 1]);
                    //System.out.println(A.getAccountID());
                }

                if (element[0].equalsIgnoreCase("accountClosingDate")) {
                    A.setAccountClosingDate(element[element.length - 1]);
                    //System.out.println(A.getAccountClosingDate());
                }

                if (element[0].equalsIgnoreCase("accountOpeningDate")) {
                    A.setAccountOpeningDate(element[element.length - 1]);
                    //System.out.println(A.getAccountOpeningDate());
                }

                if (element[0].equalsIgnoreCase("accountType")) {
                    A.setAccountTypeId(element[element.length - 1]);
                    //System.out.println(A.getAccountTypeId());
                }

                if (element[0].equalsIgnoreCase("active")) {
                    A.setActive(element[element.length - 1]);
                    //System.out.println(A.getActive());
                }

                if (element[0].equalsIgnoreCase("description")) {
                    A.setDescription(element[element.length - 1]);
                    //System.out.println(A.getDescription());
                }

                if (element[0].equalsIgnoreCase("interestRate")) {
                    A.setInterestRate(element[element.length - 1]);
                    //System.out.println(A.getInterestRate());
                }

                if (element[0].equalsIgnoreCase("annualPercentageRate")) {
                    A.setAnnualPercentageRate(element[element.length - 1]);
                    //System.out.println(A.getAnnualPercentageRate());
                }

                if (element[0].equalsIgnoreCase("creditLimit")) {
                    A.setCreditLimit(element[element.length - 1]);
                    //System.out.println(A.getCreditLimit());
                }

                if (element[0].equalsIgnoreCase("accountNumber")) {
                    A.setAccountNumber(element[element.length - 1]);
                    //System.out.println(A.getAccountNumber());
                }

                if (element[0].equalsIgnoreCase("alterDate")) {
                    A.setAlterDate(element[element.length - 1]);
                    //System.out.println(A.getAlterDate());
                }

                if (element[0].equalsIgnoreCase("balance")) {
                    A.setBalance(element[element.length - 1]);
                    //System.out.println(A.getBalance());
                }

                if (element[0].equalsIgnoreCase("businessUnitId")) {
                    A.setBusinessUnitId(element[element.length - 1]);
                    //System.out.println(A.getBusinessUnitId());
                }

                if (element[0].equalsIgnoreCase("address")) {
                    A.setAddress(element[element.length - 1]);
                    //System.out.println(A.getAddress());
                }

                if (element[0].equalsIgnoreCase("bankId")) {
                    A.setBankId(element[element.length - 1]);
                    //System.out.println(A.getBankId());
                }

                if (element[0].equalsIgnoreCase("bankName")) {
                    A.setBankName(element[element.length - 1]);
                    //System.out.println(A.getBankName());
                }

                if (element[0].equalsIgnoreCase("bankRegNumber")) {
                    A.setBankRegNumber(element[element.length - 1]);
                    //System.out.println(A.getBankRegNumber());
                }

                if (element[0].equalsIgnoreCase("country")) {
                    A.setCountry(element[element.length - 1]);
                    //System.out.println(A.getCountry());
                }
                if (element[0].equalsIgnoreCase("registeredAddress")) {
                    A.setRegisteredAddress(element[element.length - 1]);
                    //System.out.println(A.getRegisteredAddress());
                }

                if (element[0].equalsIgnoreCase("routingNumber")) {
                    A.setRoutingNumber(element[element.length - 1]);
                    //System.out.println(A.getRoutingNumber());
                }

                if (element[0].equalsIgnoreCase("unitName")) {
                    A.setUnitName(element[element.length - 1]);
                    //System.out.println(A.getUnitName());
                }

                if (element[0].equalsIgnoreCase("isJointAccount")) {
                    A.setIsJointAccount(element[element.length - 1]);
                    //System.out.println(A.getIsJointAccount());
                }

                if (element[0].equalsIgnoreCase("isOnlineAccessEnabled")) {
                    A.setIsOnlineAccessEnabled(element[element.length - 1]);
                    //System.out.println(A.getIsOnlineAccessEnabled());
                }

                if (element[0].equalsIgnoreCase("status")) {
                    A.setStatus(element[element.length - 1]);
                    //System.out.println(A.getStatus());
                }

                if (element[0].equalsIgnoreCase("version")) {
                    A.setVersion(element[element.length - 1]);
                    //System.out.println(A.getVersion());
                }

                //System.out.println(step_2[3]);
            }
    }

    private String transactionId;

    public String getTrans(String key) throws IOException {
        API_key = key;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-wufthacks.xlabs.one:8243/td/transaction/V1.0.0/transaction/all?page=1&size=1")
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("X-Api-Key", key)
                .addHeader("Authorization", "Bearer c229f874-c45a-3e4e-8366-1cf2eee0055c")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "de689913-0557-ea4a-8db5-ca969422abe5")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            success = true;
            return response.body().string();
        } else {
            //System.out.println("get_info error");
            success = false;
            return null;
        }
    }

    private String API_key;

    private Account account; //account in question

    private Customer user;

    private Employee employee;

    public Transaction(Account account, Customer user, Employee employee) {
        this.account = account;
        this.user = user;
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
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
