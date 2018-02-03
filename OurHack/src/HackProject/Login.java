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
 * @author mclovin
 */
public class Login {

    private String username, password;

    public Login() {

    }

    public void setUsername(String name) {
        username = name;
    }

    public void setpassword(String code) {
        password = code;
    }

    public String getAPI_key() throws IOException {

        String origin = "\n  \"password\": \"aaaaaa\",\n  \"username\": \"bbbbbb\"\n";

        String part_1 = origin.replace("aaaaaa", username);
        String part_2 = part_1.replace("bbbbbb", password);
        String part_3 = "{" + part_2 + "}";
        //System.out.println(part_3);
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, part_3);
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
        if (response.isSuccessful()) {
            String key = response.body().string();
            String[] parts = key.split(":");
            if(parts.length == 2){
                String step_1 = parts[1].replaceAll("\"", "");
                //String step_2 = step_1.replaceAll("}", "");
                char[] chars = step_1.toCharArray();
                StringBuilder sb = new StringBuilder();
                int wanted_length;
                if(chars.length > 162){
                    wanted_length = 162;    
                }else{
                    wanted_length = chars.length -1;
                }
                for(int i = 0; i < wanted_length; i++){
                sb.append(chars[i]);
                }
                
                String real_key = sb.toString();

                return real_key;
            }else{
                return null;
            }
            
        } else {

            return null;
        }

    }

}
