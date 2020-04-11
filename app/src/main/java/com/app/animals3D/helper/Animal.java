package com.app.animals3D.helper;

import com.app.animals3D.R;

public class Animal {
    public static Animal[] list_of_animals = {
            new Animal("tiger", R.mipmap.icon_animals, "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", R.raw.tiger),
            new Animal("bear", R.mipmap.bear, "https://storage.googleapis.com/ar-answers-in-search-models/static/BrownBear/model.glb", R.raw.bear),
            new Animal("cat", R.mipmap.cat, "https://storage.googleapis.com/ar-answers-in-search-models/static/ShortHairedCat/model.glb", R.raw.cat),
            new Animal("dog", R.mipmap.dog, "https://storage.googleapis.com/ar-answers-in-search-models/static/LabradorRetriever/model.glb", R.raw.dog),
            new Animal("duck", R.mipmap.duck, "https://storage.googleapis.com/ar-answers-in-search-models/static/MallardDuck/model.glb", R.raw.duck),
            new Animal("eagle", R.mipmap.eagle, "https://storage.googleapis.com/ar-answers-in-search-models/static/GoldenEagle/model.glb", R.raw.eagle),
            new Animal("fish", R.mipmap.fish, "https://storage.googleapis.com/ar-answers-in-search-models/static/AnglerFish/model.glb"),
            new Animal("horse", R.mipmap.horse, "https://storage.googleapis.com/ar-answers-in-search-models/static/ArabianHorse/model.glb", R.raw.horse),
            new Animal("leopard", R.mipmap.leopard, "https://storage.googleapis.com/ar-answers-in-search-models/static/AfricanLeopard/model.glb", R.raw.tiger),
            new Animal("lion", R.mipmap.lion, "https://storage.googleapis.com/ar-answers-in-search-models/static/Lion/model.glb", R.raw.tiger),
            new Animal("octopus", R.mipmap.octopus, "https://storage.googleapis.com/ar-answers-in-search-models/static/CommonOctopus/model.glb"),
            new Animal("panda", R.mipmap.panda, "https://storage.googleapis.com/ar-answers-in-search-models/static/GiantPanda/model.glb"),
            new Animal("parrot", R.mipmap.parrot, "https://storage.googleapis.com/ar-answers-in-search-models/static/Macaw/model.glb"),
            new Animal("penguin", R.mipmap.penguin, "https://storage.googleapis.com/ar-answers-in-search-models/static/EmperorPenguin/model.glb"),
            new Animal("shark", R.mipmap.shark, "https://storage.googleapis.com/ar-answers-in-search-models/static/GreatWhiteShark/model.glb"),
            new Animal("sheep", R.mipmap.sheep, "https://storage.googleapis.com/ar-answers-in-search-models/static/AlpineGoat/model.glb"),
            new Animal("snake", R.mipmap.snake, "https://storage.googleapis.com/ar-answers-in-search-models/static/BallPython/model.glb"),
            new Animal("turtle", R.mipmap.turtle, "https://storage.googleapis.com/ar-answers-in-search-models/static/GreenSeaTurtle/model.glb"),
            new Animal("wolf", R.mipmap.wolf, "https://storage.googleapis.com/ar-answers-in-search-models/static/TimberWolf/model.glb"),
            new Animal("hedgehog", R.mipmap.hedgehog, "https://storage.googleapis.com/ar-answers-in-search-models/static/EuropeanHedgehog/model.glb"),
            new Animal("crocodile", R.mipmap.crocodile, "https://storage.googleapis.com/ar-answers-in-search-models/static/Alligator/model.glb")
    };
    private String name;
    private int idDrawable;
    private String source3D;
    private int idSound;
    private String spanishName;

    public Animal(String name, int idDrawable, String source3D, int idSound) {
        this.name = name;
        this.idDrawable = idDrawable;
        this.source3D = source3D;
        this.idSound = idSound;
    }

    public Animal(String name, int idDrawable, String source3D) {
        this.name = name;
        this.idDrawable = idDrawable;
        this.source3D = source3D;
        this.idSound = 0;
    }

    public String getName() {
        return name;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public String getSource3D() {
        return source3D;
    }

    public int getIdSound() {
        return idSound;
    }

    public String getSpanishName() {
        return spanishName;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + idDrawable + source3D.hashCode() + idSound + spanishName.hashCode();
    }
}
