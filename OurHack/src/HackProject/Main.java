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
public class Main {

    public static void main(String[] args){
        Main hp = new Main();
        hp.run();
    }
    

   
    public void run(){
        try{
         test();
        }catch(IOException e){
        e.printStackTrace();
        }
            
        
        
        
        System.out.println("Hello world");
        
    }

    public void test() throws IOException {
        OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
  .url("https://api-wufthacks.xlabs.one:8243/td/account/V1.0.0/account/all?page=1&size=1")
  .get()
  .addHeader("Accept", "application/json")
  .addHeader("X-Api-Key", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdGVwaGFuam9lMTQxIiwiZXhwIjoxNTE4NDkzMzc1fQ.PsrtsBoluOKSVv798e9ryJDfCW1zNtTAp4XsgmF9e_S7A9C-hwcvjlcryxZZ_lMMzUjP3lXKmhQIFIkhpfUgEg")
  .addHeader("Authorization", "Bearer c229f874-c45a-3e4e-8366-1cf2eee0055c")
  .addHeader("Cache-Control", "no-cache")
  .addHeader("Postman-Token", "47cf7e52-71b4-6d82-76a0-8c2964646946")
  .build();

Response response = client.newCall(request).execute();
System.out.println(response.body().string());
    }


}
