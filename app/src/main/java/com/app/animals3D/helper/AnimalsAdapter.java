package com.app.animals3D.helper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import com.app.animals3D.R;

import java.util.ArrayList;
import java.util.Collections;

public class AnimalsAdapter extends BaseAdapter {
    private final Context context;
    private final onClickAction action;
    private final LayoutInflater inflater;
    private final ArrayList<Animal> items;

    public AnimalsAdapter(Context context, onClickAction action, ArrayList<Animal> listAnimals) {
        this.context = context;
        this.action = action;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        items = listAnimals;
        // TODO filter animal if they do not have sounds or 3D (depending of the activity)
        // Shuffle element in order to have a different order every time.
        Collections.shuffle(items);

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Animal getItem(int position) {
        return items.get(position);
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
                    Log.i(context.getClass().getSimpleName(), "Open 3D " + animal.getName());
                    ArCoreHelper.showArObject(
                            context,
                            animal.getSource3D(),
                            animal.getName());
                }
            });
        } else if (action == onClickAction.SOUND) {
            buttonAnimal.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.i(context.getClass().getSimpleName(), "Play " + animal.getName() + " sounds");
                    SoundsHelper.getInstance().play(context, animal.getIdSound());
                }
            });

        }

        return view;
    }

}