package com.example.ramonsl.exemplocontratosqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitsDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = HabitsDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;


    public HabitsDbHelper(Context context ) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_TABLE_HABIT="CREATE TABLE "+ HabitContract.HabitEntry.TABLE_NAME +" ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_HABIT + " TEXT NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_TIMES + "INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_TABLE_HABIT);
    }

    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Não ficou claro oque era pra fazer aqui, visto que não tenho uma outra versao do banco.
           }

    private long insertHabits(Habits date){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT,date.getnHabit());
        values.put(HabitContract.HabitEntry.COLUMN_TIMES,date.getnTimes());

        long result=db.insert(HabitContract.HabitEntry.TABLE_NAME,null,values);
        return result;

    }

    private Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] projetction={HabitContract.HabitEntry._ID, HabitContract.HabitEntry.COLUMN_TIMES, HabitContract.HabitEntry.TABLE_NAME};
        String order= HabitContract.HabitEntry.TABLE_NAME + " DESC";
        Cursor cursor = db.query(HabitContract.HabitEntry.TABLE_NAME, projetction,null,null,null,null,order);
        return cursor;
    }

}
