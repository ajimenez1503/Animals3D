package com.app.animals3D.helper;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Animal {

    private final int idDrawable;
    private final String source3D;
    private final int idSound;
    private final Map<String, String> name;

    Animal(String name, int idDrawable, String source3D, int idSound, String spanishName) {
        this.idDrawable = idDrawable;
        this.source3D = source3D;
        this.idSound = idSound;
        this.name = new HashMap<>();
        this.name.put(Locale.ENGLISH.getDisplayLanguage(), name);
        this.name.put(LocalLocale.SPANISH.getDisplayLanguage(), spanishName);
    }

    public String getName() {
        if (name.containsKey(Locale.getDefault().getDisplayLanguage())) {
            return name.get(Locale.getDefault().getDisplayLanguage());
        } else {
            // If the default language does not exists, return in English
            return name.get(Locale.ENGLISH.getDisplayLanguage());
        }
    }

    String getName(String language) {
        if (name.containsKey(language)) {
            return name.get(language);
        } else {
            // If the language does not exists, return in English
            return name.get(Locale.ENGLISH.getDisplayLanguage());
        }
    }

    Map<String, String> getNameMap() {
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
        return getName(Locale.ENGLISH.getDisplayLanguage());
    }
}
