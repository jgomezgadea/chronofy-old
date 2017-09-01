package com.chronofy.android.chronofy.Adapter;

import android.app.Activity;
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

import com.chronofy.android.chronofy.Fragment.MainFragment;
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
    private Activity activityFragment;
    private ArrayList<Brick> datos;
    private View view;

    /* Constructor de la clase, donde pasamos por parámetro los datos
     * a mostrar en la lista y el contexto
    */
    public InflateBrick(Activity activity, ArrayList<Brick> datos) {
        super(activity, R.layout.inflate_brick,datos);
        this.activityFragment = activity;
        this.datos = datos;
    }

    // TODO Hacer que si deslizo un view hacia la izquierda, se elimine (con un toast para confirmar su eliminación)
    @NonNull
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        // Obtenemos el inflater (xml) actual
        LayoutInflater inflater = activityFragment.getLayoutInflater();
        // Lo modificamos por el nuestro, y ponemos el View en la variable view
        view = inflater.inflate(R.layout.inflate_brick, null);

        // En el TextView titulo del xml, ponemos el nombre
        TextView title = (TextView) view.findViewById(R.id.tituloBrick);
        title.setText(datos.get(position).getNombre());

        // Y en el TextView descripcion del xml, ponemos el tipo
        TextView descrip = (TextView) view.findViewById(R.id.descripcionBrick);
        descrip.setText(datos.get(position).getTipo() + "");

        // Botón de ajustes del brick
        final ImageView opciones = view.findViewById(R.id.imagenOpcionesBrick);
        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Acción de cada uno de los botones
                        switch (item.getItemId()) {
                            case R.id.reiniciarBrick:
                                Toast.makeText(view.getContext(), "Reiniciar",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.editarBrick:
                                Toast.makeText(view.getContext(), "Editar",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.eliminarBrick:
                                mirar https://stackoverflow.com/questions/7073577/how-to-get-object-from-listview-in-setonitemclicklistener-in-android
                                MainFragment.eliminarBrick();
                                Toast.makeText(view.getContext(), "Elemento eliminado",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.brick);
                popupMenu.show();
            }
        });
        return view;
    }

}



