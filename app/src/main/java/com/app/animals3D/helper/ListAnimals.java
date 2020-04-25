package com.app.animals3D.helper;

import com.app.animals3D.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ListAnimals {

    private static ListAnimals single_instance = null;
    private final ArrayList<Animal> items;

    private ListAnimals() {
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

    }

    // static method to create instance of Singleton class
    public static ListAnimals getInstance() {
        if (single_instance == null)
            single_instance = new ListAnimals();

        return single_instance;
    }

    public ArrayList<Animal> get() {
        return items;
    }
}
