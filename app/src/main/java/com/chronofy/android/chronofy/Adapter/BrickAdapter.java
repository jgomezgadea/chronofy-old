package com.chronofy.android.chronofy.Adapter;

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

import com.chronofy.android.chronofy.MainActivity;
import com.chronofy.android.chronofy.Model.Brick;
import com.chronofy.android.chronofy.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Se encarga de adaptar el DynamicListView para que sea compatible con la apariencia de los bricks.
 */

// TODO Adaptador de la mainListView para enlazarle la vista brick_viewl
public class BrickAdapter extends ArrayAdapter<Brick> {

    /* Creamos las variables necesarias para capturar el contexto
    *  y los datos que se publicarán en la lista
    */
    private MainActivity activity;
    private HashMap<Brick, Integer> datos = new HashMap<>();
    private View view;
    private final int INVALID_ID = -1;

    /* Constructor de la clase, donde pasamos por parámetro los datos
     * a mostrar en la lista y el contexto
    */
    public BrickAdapter(MainActivity activity, ArrayList<Brick> datos) {
        super(activity.getApplicationContext(), R.layout.brick_view,datos);
        this.activity = activity;
        for (int i = 0; i < datos.size(); ++i) {
            this.datos.put(datos.get(i), i);
        }
    }

    // TODO Hacer que si deslizo un view hacia la izquierda, se elimine (con un toast para confirmar su eliminación).
    @NonNull
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        // Obtenemos el inflater (xml) actual
        LayoutInflater inflater = activity.getLayoutInflater();
        // Lo modificamos por el nuestro, y ponemos el View en la variable view
        view = inflater.inflate(R.layout.brick_view, null);

        // En el TextView titulo del xml, ponemos el nombre
        TextView title = (TextView) view.findViewById(R.id.tituloBrick);
        // TODO Revisar el getItem (con el array teníamos "datos.get(position)")
        title.setText(getItem(position).getNombre());

        // Y en el TextView descripcion del xml, ponemos el tipo
        TextView descrip = (TextView) view.findViewById(R.id.descripcionBrick);
        descrip.setText(getItem(position).getTipo() + "");

        // Botón de ajustes del brick
        final ImageView opciones = view.findViewById(R.id.imagenOpcionesBrick);
        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Acción de cada uno de los botones.
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
                                activity.eliminarBrick(position);
                                Toast.makeText(view.getContext(), "Elemento " + position + " eliminado",
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

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= datos.size()) {
            return INVALID_ID;
        }
        Brick item = getItem(position);
        return datos.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}



