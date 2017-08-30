package com.chronofy.android.chronofy.Model;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.chronofy.android.chronofy.R;

/**
 * Created by Jose on 30/08/2017.
 */

public class BrickPopup extends Activity {
    private Activity activity;
    private View view;

    public BrickPopup(Activity activity, View view) {
        super(activity, view);
        this.activity = activity;
        this.view = view;
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
