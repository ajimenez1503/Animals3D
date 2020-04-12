package com.app.animals3D.helper;

import com.app.animals3D.R;

public class Animal {
    public static final Animal[] list_of_animals = {
            new Animal("Tiger", R.mipmap.icon_animals, "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", R.raw.tiger),
            new Animal("Bear", R.mipmap.bear, "https://storage.googleapis.com/ar-answers-in-search-models/static/BrownBear/model.glb", R.raw.bear),
            new Animal("Cat", R.mipmap.cat, "https://storage.googleapis.com/ar-answers-in-search-models/static/ShortHairedCat/model.glb", R.raw.cat),
            new Animal("Dog", R.mipmap.dog, "https://storage.googleapis.com/ar-answers-in-search-models/static/LabradorRetriever/model.glb", R.raw.dog),
            new Animal("Duck", R.mipmap.duck, "https://storage.googleapis.com/ar-answers-in-search-models/static/MallardDuck/model.glb", R.raw.duck),
            new Animal("Eagle", R.mipmap.eagle, "https://storage.googleapis.com/ar-answers-in-search-models/static/GoldenEagle/model.glb", R.raw.eagle),
            new Animal("Fish", R.mipmap.fish, "https://storage.googleapis.com/ar-answers-in-search-models/static/AnglerFish/model.glb"),
            new Animal("Horse", R.mipmap.horse, "https://storage.googleapis.com/ar-answers-in-search-models/static/ArabianHorse/model.glb", R.raw.horse),
            new Animal("Leopard", R.mipmap.leopard, "https://storage.googleapis.com/ar-answers-in-search-models/static/AfricanLeopard/model.glb", R.raw.tiger),
            new Animal("Lion", R.mipmap.lion, "https://storage.googleapis.com/ar-answers-in-search-models/static/Lion/model.glb", R.raw.tiger),
            new Animal("Octopus", R.mipmap.octopus, "https://storage.googleapis.com/ar-answers-in-search-models/static/CommonOctopus/model.glb"),
            new Animal("Panda", R.mipmap.panda, "https://storage.googleapis.com/ar-answers-in-search-models/static/GiantPanda/model.glb"),
            new Animal("Parrot", R.mipmap.parrot, "https://storage.googleapis.com/ar-answers-in-search-models/static/Macaw/model.glb"),
            new Animal("Penguin", R.mipmap.penguin, "https://storage.googleapis.com/ar-answers-in-search-models/static/EmperorPenguin/model.glb"),
            new Animal("Shark", R.mipmap.shark, "https://storage.googleapis.com/ar-answers-in-search-models/static/GreatWhiteShark/model.glb"),
            new Animal("Sheep", R.mipmap.sheep, "https://storage.googleapis.com/ar-answers-in-search-models/static/AlpineGoat/model.glb"),
            new Animal("Snake", R.mipmap.snake, "https://storage.googleapis.com/ar-answers-in-search-models/static/BallPython/model.glb", R.raw.snake),
            new Animal("Turtle", R.mipmap.turtle, "https://storage.googleapis.com/ar-answers-in-search-models/static/GreenSeaTurtle/model.glb"),
            new Animal("Wolf", R.mipmap.wolf, "https://storage.googleapis.com/ar-answers-in-search-models/static/TimberWolf/model.glb"),
            new Animal("Hedgehog", R.mipmap.hedgehog, "https://storage.googleapis.com/ar-answers-in-search-models/static/EuropeanHedgehog/model.glb"),
            new Animal("Crocodile", R.mipmap.crocodile, "https://storage.googleapis.com/ar-answers-in-search-models/static/Alligator/model.glb")
    };
    private final String name;
    private final int idDrawable;
    private final String source3D;
    private final int idSound;

    private Animal(String name, int idDrawable, String source3D, int idSound) {
        this.name = name;
        this.idDrawable = idDrawable;
        this.source3D = source3D;
        this.idSound = idSound;
    }

    private Animal(String name, int idDrawable, String source3D) {
        this.name = name;
        this.idDrawable = idDrawable;
        this.source3D = source3D;
        this.idSound = 0;
    }

    public String getName() {
        return name;
    }

    int getIdDrawable() {
        return idDrawable;
    }

    String getSource3D() {
        return source3D;
    }

    int getIdSound() {
        return idSound;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + idDrawable + source3D.hashCode() + idSound;
    }
}
