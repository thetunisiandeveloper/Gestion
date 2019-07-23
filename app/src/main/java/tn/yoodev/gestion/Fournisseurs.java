package tn.yoodev.gestion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Fournisseurs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseurs);
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
