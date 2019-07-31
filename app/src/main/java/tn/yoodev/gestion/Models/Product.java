package tn.yoodev.gestion.Models;

import com.google.gson.annotations.SerializedName;


public class Product  {

    @SerializedName("Code")

    private String code;
    @SerializedName("Fournisseur")

    private String fournisseur;
    @SerializedName("Marque")

    private String marque;
    @SerializedName("Qantite")

    private String qantite;
    @SerializedName("Prix")

    private String prix;
    @SerializedName("Seuil")

    private String seuil;

    @SerializedName("ndv")

    private String ndv;
    @SerializedName("categorie")

    private String categorie;
    @SerializedName("Nomp")

    private String nomp;


    public Product(String code, String fournisseur, String marque, String qantite, String prix, String seuil, String ndv, String categorie, String nomp) {
        this.code = code;
        this.fournisseur = fournisseur;
        this.marque = marque;
        this.qantite = qantite;
        this.prix = prix;
        this.seuil = seuil;
        this.ndv = ndv;
        this.categorie = categorie;
        this.nomp = nomp;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getQantite() {
        return qantite;
    }

    public void setQantite(String qantite) {
        this.qantite = qantite;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getSeuil() {
        return seuil;
    }

    public void setSeuil(String seuil) {
        this.seuil = seuil;
    }

    public String getNdv() {
        return ndv;
    }

    public void setNdv(String ndv) {
        this.ndv = ndv;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }
}



