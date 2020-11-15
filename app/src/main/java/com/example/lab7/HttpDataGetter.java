package com.example.lab7;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpDataGetter implements Runnable {
    private String data;
    private String url;

    public HttpDataGetter(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            InputStream response = conn.getInputStream();
            Scanner scanner = new Scanner(response).useDelimiter("\\A");

            data = scanner.hasNext() ? scanner.next() : "";
        } catch (Exception e) {
            data = e.getMessage();
        }
    }

    public String getData() {
        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }

}
