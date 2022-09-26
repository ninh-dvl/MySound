package com.aptech.team5.mysound.Service;

public class APIService {
    private static String base_url = "https://mysound2.000webhostapp.com/Server/";
    public  static DataService getService() {
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
