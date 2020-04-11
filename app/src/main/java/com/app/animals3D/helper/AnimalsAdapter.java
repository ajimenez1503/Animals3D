package com.app.animals3D.helper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import com.app.animals3D.R;

public class AnimalsAdapter extends BaseAdapter {
    private final Context context;
    private final Animal[] items;
    private final onClickAction action;
    private final LayoutInflater inflater;

    public AnimalsAdapter(Context context, Animal[] items, onClickAction action) {
        this.context = context;
        this.items = items;
        this.action = action;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Animal getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        final Animal animal = getItem(position);
        ImageButton buttonAnimal = view.findViewById(R.id.imageButton_animal);
        buttonAnimal.setImageResource(animal.getIdDrawable());
        if (action == onClickAction.OBJECT3D) {
            buttonAnimal.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.i(context.getPackageName(), "Open 3D " + animal.getName());
                    ArCoreHelper.showArObject(
                            context,
                            animal.getSource3D(),
                            animal.getName());
                }
            });
        }

        return view;
    }

}