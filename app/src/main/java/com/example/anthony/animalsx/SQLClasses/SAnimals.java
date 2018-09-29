package com.example.anthony.animalsx.SQLClasses;

import android.provider.BaseColumns;

public class SAnimals {
    public static abstract class AnimalEntry implements BaseColumns {
        public static final String TABLE_NAME ="animal";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PHOTOLINK = "photoLink";

    }
}
