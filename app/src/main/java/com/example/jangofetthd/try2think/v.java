package com.example.jangofetthd.try2think;

import android.util.Log;

/**
 * Created by JangoFettHD on 08.03.2016.
 */
public class v {
    public static int section = 0, level = 0;

    public static void win (){
        db.sections[section].section[level].status=1;
        db.savech(section);
        Log.i("SuperLog", "win");
    }

    private static String toCorrectAnswer(String temp){
        return temp.toLowerCase().replaceAll("ё", "е").replaceAll("й", "и");
    }

    public static boolean equalsStr(String first, String second){
        if (toCorrectAnswer(first).equals(toCorrectAnswer(second))) return true;
        return false;
    }
}
