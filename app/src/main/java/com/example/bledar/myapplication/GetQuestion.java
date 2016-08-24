package com.example.bledar.myapplication;
import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class GetQuestion extends AsyncTask <String, Integer, Double> {
    String jStr="";
    @Override
    protected Double doInBackground(String... params) {
        // TODO Auto-generated method stub
        getData();
        return null;
    }

    public void getData(){
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet getRequest =new HttpGet("http://quizz.bledarhaxhia.com/get.php");
        try {
            HttpResponse response = httpclient.execute(getRequest);
            int responseCode = response.getStatusLine().getStatusCode();
            switch(responseCode) {
                case 200:
                    HttpEntity entity = response.getEntity();
                    if(entity != null) {
                        String responseBody = EntityUtils.toString(entity);
                        Log.v("OK", "Pergjigjia e serverit: "+responseBody);
                        jParse(responseBody);
                    }
                    break;
            }

            Log.v("Gabim", "Kodi i serverit: "+responseCode);

        } catch (ClientProtocolException e) {
            Log.v("Gabim", "Gabin ne protokoll");
        } catch (IOException e) {
            Log.v("Gabim", "Gabin ne komunikim");
        }
    }

    JSONObject jParse(String responseBody){
        try {
        JSONObject jObject = new JSONObject(responseBody);
            Log.v("Ok", "JSON u gjet");
            return jObject;
        }catch ( JSONException e){
            Log.v("Gabim", "Nuk gjetem JSON!!!!!!!!!!");
            return null;
        }
    }

}