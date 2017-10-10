package com.chronofy.android.chronofy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.chronofy.android.chronofy.Adapter.BrickAdapter;
import com.chronofy.android.chronofy.Model.Brick;
import com.chronofy.android.chronofy.Model.DynamicListView;

import java.util.ArrayList;

/**
 * El controlador de la lista de bricks (que utiliza la view del activity_list_view
 */
public class BrickList extends FragmentActivity {

    DynamicListView listView = null; // Variable con la que referenciamos a la ListView principal
    FloatingActionButton fab = null; // Variable con la que referenciamos al botón de añadir bricks
    BrickAdapter adapter;

    public BrickList() {
        // Required empty public constructor
    }

    // Creamos un ArrayList de ejemplo que en un futuro serán los bricks
    static ArrayList<Brick> listaEjemplo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Añadimos los bricks iniciales a listaEjemplo
        listaEjemplo.add(new Brick("Hola", 78587578));
        listaEjemplo.add(new Brick("que", 4521));
        listaEjemplo.add(new Brick("tal", 578587));
        listaEjemplo.add(new Brick("estás", 45587521));
        listaEjemplo.add(new Brick("loko", 8755));

        // Enlazamos los elementos del xml a variables
        listView = findViewById(R.id.mainListView);
        fab = findViewById(R.id.fab);

        // El ArrayAdapter es lo que define el formato de la ListView y el ArrayList del que lee
        // TODO Tengo que hacer un adaptador del tipo que yo quiero
        adapter = new BrickAdapter(this, listaEjemplo);
        listView.setDataList(listaEjemplo);
        listView.setAdapter(adapter);
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
                adapter.notifyDataSetChanged();
                // Mostramos el toast
                elementoAnyadido.show();
            }
        });
    }

    public void eliminarBrick(int pos) {
        listaEjemplo.remove(pos);
        adapter.notifyDataSetChanged();
    }

}
