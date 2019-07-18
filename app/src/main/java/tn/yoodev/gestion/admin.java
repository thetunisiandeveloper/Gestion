package tn.yoodev.gestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    TextView addArticle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



              addArticle = findViewById(R.id.addarticle);
        addArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ajoutArticles = new Intent(getApplicationContext(),add.class);
                startActivity(ajoutArticles);
                finish();

            }
        });

  /*      public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.addarticles:
                    Intent intent = new Intent(this, ActivityForItemOne.class);
                    this.startActivity(intent);
                    break;

                default:
                    return super.onOptionsItemSelected(item);
            }

            return true;
        }
*/
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


}