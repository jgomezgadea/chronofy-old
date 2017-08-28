package com.chronofy.android.chronofy.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.chronofy.android.chronofy.Model.Brick;
import com.chronofy.android.chronofy.R;

/**
 * Created by Jose on 28/08/2017.
 */

// TODO Adaptador de la mainListView para enlazarle la vista inflate_brick.xml
public class inflateBrick extends ArrayAdapter {

    /* Creamos las variables necesarias para capturar el contexto
    *  y los datos que se publicarán en la lista
    */
    Activity context;
    Brick[] datos;

    /* Constructor de la clase, donde pasamos por parámetro los datos
     * a mostrar en la lista y el contexto
    */
    public inflateBrick(Activity context,Brick[] datos) {
        super(context, R.layout.inflate_brick,datos);
        this.context=context;
        this.datos=datos;
        // Auto-generated constructor stub
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View item=inflater.inflate(R.layout.inflate_brick, null);

        TextView title=(TextView) item.findViewById(R.id.titulo);
        title.setText(datos[position].getNombre());

        TextView descrip=(TextView) item.findViewById(R.id.descripcion);
        descrip.setText(datos[position].getTipo() + "");

        return item;
    }
}