package org.chucknorrisApi;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class ChuckNorris {
    public static void main(String[] args) {
        try {
            CallChuckNorrisApi();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CallChuckNorrisApi() throws URISyntaxException, IOException {

        URIBuilder builder=new URIBuilder("https://api.chucknorris.io/jokes/random");

        HttpGet getdata=new HttpGet(builder.build());

        CloseableHttpClient httpclient= HttpClients.createDefault();
        CloseableHttpResponse response=httpclient.execute(getdata);

        HttpEntity EntityResponse= response.getEntity();
        String result= EntityUtils.toString(EntityResponse);


        System.out.print(result);
        httpclient.close();
    }
}