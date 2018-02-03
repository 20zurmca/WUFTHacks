/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackProject;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author cameron
 */
public class Main {
private Login login = new Login();
private Account account = new Account();
private String API_key = null;
private boolean success;
    public static void main(String[] args) {
        
        Main hp = new Main();
        hp.run();
    }

    public void run() {
        success = false;
        login.setUsername("stephanjoe141");
        login.setpassword("stephanjoe141");
        
        try {
            while(!success){
            API_key = login.getAPI_key();
            account.run(API_key);
            success = account.getSuccess();
            }
            //System.out.println(API_key);
            //System.out.println(account.get_info(API_key));
            //login();
            //account();
            //trans();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hello world");

    }

    public void login() throws IOException {
        
        OkHttpClient client = new OkHttpClient();

MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "{\n  \"password\": \"stephanjoe141\",\n  \"username\": \"stephanjoe141\"\n}");
Request request = new Request.Builder()
  .url("https://api-wufthacks.xlabs.one:8243/userSignin/V1.0.0/signin")
  .post(body)
  .addHeader("Content-Type", "application/json")
  .addHeader("Accept", "application/json")
  .addHeader("Authorization", "Bearer c229f874-c45a-3e4e-8366-1cf2eee0055c")
  .addHeader("Cache-Control", "no-cache")
  .addHeader("Postman-Token", "b8d4508d-6b02-d41b-bf54-61b83360d630")
  .build();

Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public void account() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-wufthacks.xlabs.one:8243/td/account/V1.0.0/account/all?page=1&size=1")
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("X-Api-Key", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdGVwaGFuam9lMTQxIiwiZXhwIjoxNTE4NDkzMzc1fQ.PsrtsBoluOKSVv798e9ryJDfCW1zNtTAp4XsgmF9e_S7A9C-hwcvjlcryxZZ_lMMzUjP3lXKmhQIFIkhpfUgEg")
                .addHeader("Authorization", "Bearer c229f874-c45a-3e4e-8366-1cf2eee0055c")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "dedf4b7e-c2fe-3d73-deca-bf3cb6b5dd19")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public void trans() throws IOException{
       OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
  .url("https://api-wufthacks.xlabs.one:8243/td/transaction/V1.0.0/transaction/all?page=1&size=1")
  .get()
  .addHeader("Accept", "application/json")
  .addHeader("X-Api-Key", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdGVwaGFuam9lMTQxIiwiZXhwIjoxNTE4NTAyNTc2fQ.cy6BOFlfh7tAWs44ZIKoF4HXCY6RVLUd-NJlaYgdeoByxb0E3ShdCTvdIhqeZyfn6lU41vDvVsax-gS8uurwYg")
  .addHeader("Authorization", "Bearer c229f874-c45a-3e4e-8366-1cf2eee0055c")
  .addHeader("Cache-Control", "no-cache")
  .addHeader("Postman-Token", "de689913-0557-ea4a-8db5-ca969422abe5")
  .build();

Response response = client.newCall(request).execute();
System.out.println(response.body().string());
    }
}
