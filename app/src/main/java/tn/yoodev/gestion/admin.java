package tn.yoodev.gestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tn.yoodev.gestion.Connection.RetrofitInstance;
import tn.yoodev.gestion.G_Adapter.ProductAdapter;
import tn.yoodev.gestion.List.ProductList;

public class admin extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<ProductList> Productsdata;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);






        recyclerView=(RecyclerView)findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // adapter=new ProductAdapter(Productsdata,admin.this);
       // recyclerView.setAdapter(adapter);
        apiInterface= RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        recyclerView.setHasFixedSize(true);
        Call<List<ProductList>> call = apiInterface.getProduct();
        //Call<List<ProductList>> call=apiInterface.getProduct();
        call.enqueue(new Callback<List<ProductList>>() {
            @Override
            public void onResponse(Call<List<ProductList>> call, Response<List<ProductList>> response) {
                Productsdata=response.body();
                adapter=new ProductAdapter(Productsdata,admin.this);
                recyclerView.setAdapter(adapter);
               // Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<ProductList>> call, Throwable t) {

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