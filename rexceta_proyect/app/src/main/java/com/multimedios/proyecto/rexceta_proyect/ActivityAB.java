package com.multimedios.proyecto.rexceta_proyect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class ActivityAB extends AppCompatActivity implements OnQueryTextListener, OnActionExpandListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_ab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_activity_ab, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_buscar);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(searchItem, this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        Toast toast1;
        toast1 = Toast.makeText(getApplicationContext(), "Sin funcionalidad", Toast.LENGTH_SHORT);

        if(id == R.id.action_settings)
        {
            toast1.show();
            return true;
        }
        else if(id==R.id.opcion2)
        {
            toast1.show();
            return true;
        }
        else if(id==R.id.opcion3)
        {
            toast1.show();
            return true;
        }
        else if(id==R.id.menu_buscar)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Busqueda de receta", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        Toast.makeText(getApplicationContext(), "COLLAPSE", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        //texto.setText("Texto a buscar\n\n" + s);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        //texto.setText("Escribiendo texto...\n\n" + s);
        return true;
    }
}
