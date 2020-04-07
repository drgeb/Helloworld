package com.drgeb;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class MACAdressSearch {
    private static String API_KEY="API_KEY";
    public static void main(String[] args) {
        
        String apiKey = System.getenv(API_KEY);
        String search = args[0];
        if (args.length==2){
            String type = args[1];
        }
        
        HttpClient client = HttpClient.newHttpClient();
        String uri="https://api.macaddress.io/v1?apiKey=" + apiKey + "&output=json&search=" + search;
		HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(uri))
              .build();
        client.sendAsync(request, BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenAccept(System.out::println)
              .join();
    }
}