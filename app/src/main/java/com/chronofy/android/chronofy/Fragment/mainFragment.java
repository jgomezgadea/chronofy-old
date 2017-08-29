package com.chronofy.android.chronofy.Fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.chronofy.android.chronofy.Adapter.inflateBrick;
import com.chronofy.android.chronofy.Model.Brick;
import com.chronofy.android.chronofy.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class mainFragment extends Fragment {

    ListView mainListView = null; // Variable con la que referenciamos a la ListView principal
    FloatingActionButton fab = null; // Variable con la que referenciamos al botón de añadir bricks

    public mainFragment() {
        // Required empty public constructor
    }

    // Creamos un ArrayList de ejemplo que en un futuro serán los bricks
    ArrayList<Brick> listaEjemplo = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Añadimos los bricks iniciales a listaEjemplo
        listaEjemplo.add(new Brick("Hola", 78587578));
        listaEjemplo.add(new Brick("que", 4521));
        listaEjemplo.add(new Brick("tal", 578587));
        listaEjemplo.add(new Brick("estás", 45587521));
        listaEjemplo.add(new Brick("loko", 8755));


        // Inflate the layout for this fragment
        final View res = inflater.inflate(R.layout.fragment_main, container, false);

        // Enlazamos los elementos del xml a variables
        mainListView = res.findViewById(R.id.mainListView);
        fab = res.findViewById(R.id.fab);

        // El ArrayAdapter es lo que define el formato de la ListView y el ArrayList del que lee
        // TODO Tengo que hacer un adaptador del tipo que yo quiero
        final inflateBrick mainAdapter = new inflateBrick(this.getActivity(), listaEjemplo);
        mainListView.setAdapter(mainAdapter);

        // TODO Este botón agregará un elemento a la ListView de tipo Brick
        // Añadimos un listener a dicho botón
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast elementoAnyadido = Toast.makeText(res.getContext(), R.string.added_item, Toast.LENGTH_SHORT);
                // Añadimos el elemento
                // TODO Esto en un futuro se hará desde otra ventana donde elegiremos el tipo
                listaEjemplo.add(new Brick("Juanito", 1354));
                mainAdapter.notifyDataSetChanged();
                // Mostramos el toast
                elementoAnyadido.show();
            }
        });

        return res;
    }

}
