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
import java.util.Arrays;
import java.util.Collections;

public class AnimalsAdapter extends BaseAdapter {
    private final Context context;
    private final onClickAction action;
    private final LayoutInflater inflater;
    private final ArrayList<Animal> items;

    public AnimalsAdapter(Context context, onClickAction action) {
        this.context = context;
        this.action = action;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        items = new ArrayList<>(
                Arrays.asList(
                        new Animal("Tiger", R.mipmap.icon_animals, "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", R.raw.tiger),
                        new Animal("Bear", R.mipmap.bear, "https://storage.googleapis.com/ar-answers-in-search-models/static/BrownBear/model.glb", R.raw.bear),
                        new Animal("Cat", R.mipmap.cat, "https://storage.googleapis.com/ar-answers-in-search-models/static/ShortHairedCat/model.glb", R.raw.cat),
                        new Animal("Dog", R.mipmap.dog, "https://storage.googleapis.com/ar-answers-in-search-models/static/LabradorRetriever/model.glb", R.raw.dog),
                        new Animal("Duck", R.mipmap.duck, "https://storage.googleapis.com/ar-answers-in-search-models/static/MallardDuck/model.glb", R.raw.duck),
                        new Animal("Eagle", R.mipmap.eagle, "https://storage.googleapis.com/ar-answers-in-search-models/static/GoldenEagle/model.glb", R.raw.eagle),
                        new Animal("Fish", R.mipmap.fish, "https://storage.googleapis.com/ar-answers-in-search-models/static/AnglerFish/model.glb", R.raw.fish),
                        new Animal("Horse", R.mipmap.horse, "https://storage.googleapis.com/ar-answers-in-search-models/static/ArabianHorse/model.glb", R.raw.horse),
                        new Animal("Leopard", R.mipmap.leopard, "https://storage.googleapis.com/ar-answers-in-search-models/static/AfricanLeopard/model.glb", R.raw.tiger),
                        new Animal("Lion", R.mipmap.lion, "https://storage.googleapis.com/ar-answers-in-search-models/static/Lion/model.glb", R.raw.tiger),
                        new Animal("Octopus", R.mipmap.octopus, "https://storage.googleapis.com/ar-answers-in-search-models/static/CommonOctopus/model.glb", R.raw.fish),
                        new Animal("Panda", R.mipmap.panda, "https://storage.googleapis.com/ar-answers-in-search-models/static/GiantPanda/model.glb", R.raw.panda),
                        new Animal("Parrot", R.mipmap.parrot, "https://storage.googleapis.com/ar-answers-in-search-models/static/Macaw/model.glb", R.raw.parrot),
                        new Animal("Penguin", R.mipmap.penguin, "https://storage.googleapis.com/ar-answers-in-search-models/static/EmperorPenguin/model.glb", R.raw.penguin),
                        new Animal("Shark", R.mipmap.shark, "https://storage.googleapis.com/ar-answers-in-search-models/static/GreatWhiteShark/model.glb", R.raw.fish),
                        new Animal("Sheep", R.mipmap.sheep, "https://storage.googleapis.com/ar-answers-in-search-models/static/AlpineGoat/model.glb", R.raw.sheep),
                        new Animal("Snake", R.mipmap.snake, "https://storage.googleapis.com/ar-answers-in-search-models/static/BallPython/model.glb", R.raw.snake),
                        new Animal("Turtle", R.mipmap.turtle, "https://storage.googleapis.com/ar-answers-in-search-models/static/GreenSeaTurtle/model.glb", R.raw.turtle),
                        new Animal("Wolf", R.mipmap.wolf, "https://storage.googleapis.com/ar-answers-in-search-models/static/TimberWolf/model.glb", R.raw.wolf),
                        new Animal("Hedgehog", R.mipmap.hedgehog, "https://storage.googleapis.com/ar-answers-in-search-models/static/EuropeanHedgehog/model.glb", R.raw.hedgehog),
                        new Animal("Crocodile", R.mipmap.crocodile, "https://storage.googleapis.com/ar-answers-in-search-models/static/Alligator/model.glb", R.raw.crocodile)
                )
        );
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