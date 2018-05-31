package com.example.ramonsl.exemplocontratosqlite.data;

import android.provider.BaseColumns;

public class HabitContract {

    private HabitContract(){}


    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_TIMES = "times";
    }
}
