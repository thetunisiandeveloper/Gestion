package tn.yoodev.gestion.Connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tn.yoodev.gestion.ApiInterface;


public class RetrofitInstance {

        private static RetrofitInstance myClient;

        private static Retrofit retrofit=null;
        private static final String BASE_URL = "http://10.0.0.2/db/admin/";

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

        private RetrofitInstance(){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        public static synchronized RetrofitInstance getInstance(){
            if (myClient==null){
                myClient=new RetrofitInstance();
            }
            return myClient;
        }
        public ApiInterface getMyApi(){
            return retrofit.create(ApiInterface.class);
        }
    }


