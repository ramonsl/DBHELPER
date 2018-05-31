package com.example.ramonsl.exemplocontratosqlite.data;

public class Habits
{

    private int _ID;
    private int nHabit;
    private int nTimes;

    public int get_ID() {
        return _ID;
    }

    public int getnHabit() {
        return nHabit;
    }

    public int getnTimes() {
        return nTimes;
    }


    public Habits(int _ID, int nHabit, int nTimes) {
        this._ID = _ID;
        this.nHabit = nHabit;
        this.nTimes = nTimes;
    }


    public Habits( int nHabit, int nTimes) {
        this.nHabit = nHabit;
        this.nTimes = nTimes;
    }
}


