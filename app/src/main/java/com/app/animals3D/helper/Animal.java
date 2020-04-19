package com.app.animals3D.helper;

import androidx.annotation.NonNull;

public class Animal {

    private final String name;
    private final int idDrawable;
    private final String source3D;
    private final int idSound;

    Animal(String name, int idDrawable, String source3D, int idSound) {
        this.name = name;
        this.idDrawable = idDrawable;
        this.source3D = source3D;
        this.idSound = idSound;
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

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
