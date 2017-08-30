package com.chronofy.android.chronofy.Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.chronofy.android.chronofy.Model.Brick;
import com.chronofy.android.chronofy.R;

import java.util.ArrayList;

/**
 * Created by Jose on 28/08/2017.
 */

// TODO Adaptador de la mainListView para enlazarle la vista inflate_brick.xml
public class InflateBrick extends ArrayAdapter {

    /* Creamos las variables necesarias para capturar el contexto
    *  y los datos que se publicarán en la lista
    */
    private Activity activity;
    private ArrayList<Brick> datos;
    private View view;

    /* Constructor de la clase, donde pasamos por parámetro los datos
     * a mostrar en la lista y el contexto
    */
    public InflateBrick(Activity activity, ArrayList<Brick> datos) {
        super(activity, R.layout.inflate_brick,datos);
        this.activity = activity;
        this.datos = datos;
    }

    // TODO Hacer que si deslizo un view hacia la izquierda, se elimine (con un toast para confirmar su eliminación)
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Obtenemos el inflater (xml) actual
        LayoutInflater inflater = activity.getLayoutInflater();
        // Lo modificamos por el nuestro, y ponemos el View en la variable view
        view = inflater.inflate(R.layout.inflate_brick, null);

        // En el TextView titulo del xml, ponemos el nombre
        TextView title = (TextView) view.findViewById(R.id.tituloBrick);
        title.setText(datos.get(position).getNombre());

        // Y en el TextView descripcion del xml, ponemos el tipo
        TextView descrip = (TextView) view.findViewById(R.id.descripcionBrick);
        descrip.setText(datos.get(position).getTipo() + "");

        // Botón de ajustes de cada brick
        final ImageView opciones = view.findViewById(R.id.imagenOpcionesBrick);
        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Programar botón de ajustes
                PopupMenu popupMenu = new PopupMenu(activity, view);
                popupMenu.setOnDismissListener(new OnDismissListener());
                popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener());
                popupMenu.inflate(R.menu.brick);
                popupMenu.show();

                Toast pulsado = Toast.makeText(activity, "Botón de opciones pulsado", Toast.LENGTH_SHORT);
                pulsado.show();
            }
        });



        return view;
    }

    private class CrearPopupMenu extends Activity implements View.OnClickListener {
        private PopupMenu popupMenu;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        @Override
        public void onClick(View anchor) {
            // TODO Auto-generated method stub
            popupMenu = new PopupMenu(MainActivity.this, anchor);
            popupMenu.setOnDismissListener(new OnDismissListener());
            popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener());
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.show();
        }
    }

    private class OnDismissListener extends Activity implements PopupMenu.OnDismissListener {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_main);
            Toast.makeText(view.getContext(), "Qut atl",
                    Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onDismiss(PopupMenu menu) {
            // TODO Auto-generated method stub
            Toast.makeText(view.getContext(), "Popup Menu is dismissed",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private class OnMenuItemClickListener extends Activity implements PopupMenu.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // TODO Auto-generated method stub
            switch (item.getItemId()) {
                case R.id.action_one:
                    Toast.makeText(view.getContext(), "Acción 1",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_two:
                    Toast.makeText(view.getContext(), "Acción 2",
                            Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_three:
                    Toast.makeText(view.getContext(), "Acción 3",
                            Toast.LENGTH_SHORT).show();
                    return true;

            }
            return false;
        }
    }

}



