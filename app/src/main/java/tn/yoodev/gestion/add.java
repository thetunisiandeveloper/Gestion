package tn.yoodev.gestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tn.yoodev.gestion.Connection.RetrofitInstance;

public class add extends AppCompatActivity {
    private EditText etcode, etmarque, etfournisseur,etnomp,etprix,etcategorie,etseuil;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);






        etcode = findViewById(R.id.fcode);
        etmarque = findViewById(R.id.fmarque);
        etfournisseur= findViewById(R.id.ffournisseur);
        etnomp = findViewById(R.id.fnomp);
        etprix= findViewById(R.id.fprix);
        etcategorie= findViewById(R.id.fcategorie);
        etseuil = findViewById(R.id.fseuil);

        btn = findViewById(R.id.btnadd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

    }


    private void insertData() {
        String code = etcode.getText().toString().trim();
        String marque = etmarque.getText().toString().trim();
        String fournisseur = etfournisseur.getText().toString().trim();
        String categorie = etcategorie.getText().toString().trim();
        String nomp = etnomp.getText().toString().trim();
        String prix = etprix.getText().toString().trim();
        String seuil = etseuil.getText().toString().trim();

        if (code.isEmpty()) {
            etcode.setError("donner code a barre");
            etcode.requestFocus();
            return;
        }
        if (marque.isEmpty()) {
            etmarque.setError("donner la marque");
            etmarque.requestFocus();
            return;
        }
        if (fournisseur.isEmpty()) {
            etfournisseur.setError("donner fournisseur");
            etfournisseur.requestFocus();
            return;
        }
        if (categorie.isEmpty()) {
            etcategorie.setError("donner categorie");
            etcategorie.requestFocus();
            return;
        }
        if (prix.isEmpty()) {
            etprix.setError("donner prix");
            etprix.requestFocus();
            return;
        }
        if (nomp.isEmpty()) {
            etnomp.setError("donner Nom du produit");
            etnomp.requestFocus();
            return;
        }
        if (seuil.isEmpty()) {
            etseuil.setError("donner seuil");
            etseuil.requestFocus();
            return;
        }
        Call<ResponseBody> call = RetrofitInstance.getInstance().getMyApi().insertdata(code, marque,prix,nomp,categorie,fournisseur,seuil);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(  MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.addarticles) {

            Intent intent = new Intent(this,add.class);
            this.startActivity(intent);

            return true;
        }
        if (id == R.id.pArticles) {

            Intent intent = new Intent(this,admin.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.pFournisseur) {

            Intent intent = new Intent(this,Fournisseurs.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.pClient) {

            Intent intent = new Intent(this,Clients.class);
            this.startActivity(intent);
            return true;
        }
        if (id == R.id.pCommandes) {

            Intent intent = new Intent(this,Commandes.class);
            this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
