package tn.yoodev.gestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Commandes_nl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commandes_nl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.livreur_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(  MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.pfCommandes) {

            Intent intent = new Intent(this,Commandes_nl.class);
            this.startActivity(intent);

            return true;
        }
        if (id == R.id.pfArticles) {

            Intent intent = new Intent(this,L_commercial.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
