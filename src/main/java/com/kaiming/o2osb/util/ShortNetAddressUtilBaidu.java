package com.kaiming.o2osb.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
//服务已过期，不能用
public class ShortNetAddressUtilBaidu {

    public static int TIMEOUT = 30*1000;
    public static String ENCODING = "UTF-8";

    public static String getShortURL(String originURL){
        String tinyUtil = null;
        try{
            URL url = new URL("http://dwz.cn/create.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestMethod("POST");

            String postData = URLEncoder.encode(originURL.toString(), "utf-8");
            connection.getOutputStream().write(("url=" + postData).getBytes());
            connection.connect();
            String responseStr = getResponseStr(connection);

            tinyUtil = getValueByKey(responseStr, "tinyurl");
            
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return tinyUtil;
    }

    private static String getValueByKey(String replyText, String key) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;
        String targetValue = null;
        try{
            node = mapper.readTree(replyText);
            targetValue = node.get(key).asText();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return targetValue;
    }

    private static String getResponseStr(HttpURLConnection connection) throws IOException{
        StringBuffer result = new StringBuffer();
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, ENCODING));
            String inputLine = "";
            while ((inputLine = reader.readLine()) != null) {

                result.append(inputLine);
            }
        }

        return result.toString();
    }
}
