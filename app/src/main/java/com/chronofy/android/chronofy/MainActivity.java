package com.chronofy.android.chronofy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.chronofy.android.chronofy.Adapter.BrickAdapter;
import com.chronofy.android.chronofy.Model.Brick;
import com.chronofy.android.chronofy.Model.DynamicListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    DynamicListView listView = null; // Variable con la que referenciamos a la ListView principal
    FloatingActionButton fab = null; // Variable con la que referenciamos al botón de añadir bricks
    BrickAdapter listAdapter;

    // TODO Hacer base de datos con Realm (esta lista se tendrá que guardar y recargar)
    // ArrayList de ejemplo
    ArrayList<Brick> listaEjemplo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*
         * Aquí empieza el código encargado del BrickListView
         */

        // Enlazamos los elementos del xml a variables
        listView = (DynamicListView) findViewById(R.id.mainListView);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        // El ArrayAdapter es lo que define el formato de la ListView y el ArrayList del que lee
        // TODO Tengo que hacer un adaptador del tipo que yo quiero
        listAdapter = new BrickAdapter(this, listaEjemplo);
        listView.setDataList(listaEjemplo);
        listView.setAdapter(listAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // TODO Este botón agregará un elemento a la ListView de tipo Brick
        // Añadimos un listener a dicho botón
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast elementoAnyadido = Toast.makeText(view.getContext(), R.string.added_item, Toast.LENGTH_SHORT);
                // Añadimos el elemento
                // TODO Esto en un futuro se hará desde otra ventana donde elegiremos el tipo
                listaEjemplo.add(new Brick("Juanito", 1354));
                listAdapter.notifyDataSetChanged();
                // Mostramos el toast
                elementoAnyadido.show();
            }
        });

        // Creamos la listView con los Bricks de forma paralela.
        new BrickList().execute();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        // TODO Acciones de los diferentes accesos del menú desplegable de la izquierda
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
     * Código de control de la BrickListView
     */

    // Ejecuta en paralelo la lista de bricks
    class BrickList extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            // Añadimos los bricks iniciales a listaEjemplo
            listaEjemplo.add(new Brick("Hola", 78587578));
            listaEjemplo.add(new Brick("que", 4521));
            listaEjemplo.add(new Brick("tal", 578587));
            listaEjemplo.add(new Brick("estás", 45587521));
            listaEjemplo.add(new Brick("loko", 8755));

            listAdapter.notifyDataSetChanged();

            return null;
        }
    }
    public void eliminarBrick(final int pos) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listaEjemplo.remove(pos);
                listAdapter.notifyDataSetChanged();
            }
        });
    }
}
