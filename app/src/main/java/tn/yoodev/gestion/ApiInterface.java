package tn.yoodev.gestion;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tn.yoodev.gestion.List.ProductList;

public interface ApiInterface {
    @GET("articles.php")
    Call<ProductList> getProduct();


    @FormUrlEncoded
    @POST("save.php")
    Call<ResponseBody> insertdata(
                    @Field("Code")String Code,
                    @Field("Marque")String Marque,
                    @Field("Prix")String Prix,
                    @Field("Nomp")String Nomp,
                    @Field("categorie")String categorie,
                    @Field("Fournisseur")String Fournisseur,
                    @Field("Seuil")String Seuil

    );

}
