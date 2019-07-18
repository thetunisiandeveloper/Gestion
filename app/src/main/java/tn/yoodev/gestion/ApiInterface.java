package tn.yoodev.gestion;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tn.yoodev.gestion.List.ProductList;

public interface ApiInterface {
    @GET("articles.php")
    Call<List<ProductList>> getProduct();


    @FormUrlEncoded
    @POST("add.php")
    Call<ResponseBody> insertdata(
            @Field("Code")String Code,
            @Field("marque")String Marque

    );

}
