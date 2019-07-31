package tn.yoodev.gestion.List;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tn.yoodev.gestion.Models.Product;

/**
 * Created by connecter on 30/06/2018.
 */

public class ProductList {
    @SerializedName("Produits")
    private List<Product> produits;

    public List<Product> getProduct() {
        return produits;
    }
}
