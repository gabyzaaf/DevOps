import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

/**
 * Created by zaafranigabriel on 24/11/2016.
 */
public class Webservices {


        // HTTP GET request
        public String sendGet(String nom,String prenom)  {
            StringBuffer response = new StringBuffer();
            try {
                String url = "http://10.211.55.8/phpservices/wsGetUserByName.php?nom="+nom+"&prenom="+prenom;

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");


                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;


                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
            return response.toString();
        }

        // HTTP POST request
        public String sendPost(String nom,String prenom)  {
            StringBuffer response = new StringBuffer();
            String line;
            try {
                String adresseurl = "http://10.211.55.8/phpservices/wsInsertUser.php";


                String data = URLEncoder.encode("nom", "UTF-8") + "=" + URLEncoder.encode(nom, "UTF-8");
                data += "&" + URLEncoder.encode("prenom", "UTF-8") + "=" + URLEncoder.encode(prenom, "UTF-8");

                URL url = new URL(adresseurl);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((line = rd.readLine()) != null) {
                    response.append(line);
                }
                wr.close();
                rd.close();

            }catch (Exception e){
                e.printStackTrace();
            }
            return response.toString();
        }

    // HTTP POST request
    public String updateConnect(String nom,String prenom)  {
        StringBuffer response = new StringBuffer();
        String line;
        try {
            String adresseurl = "http://10.211.55.8/phpservices/wsUpdateUser.php";


            String data = URLEncoder.encode("nom", "UTF-8") + "=" + URLEncoder.encode(nom, "UTF-8");
            data += "&" + URLEncoder.encode("prenom", "UTF-8") + "=" + URLEncoder.encode(prenom, "UTF-8");

            URL url = new URL(adresseurl);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            wr.close();
            rd.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return response.toString();
    }

    // HTTP GET request
    public String getCountUser(String nom,String prenom)  {
        StringBuffer response = new StringBuffer();
        try {
            String url = "http://10.211.55.8/phpservices/wsCountUser.php?nom="+nom+"&prenom="+prenom;

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");


            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return response.toString();
    }


}

