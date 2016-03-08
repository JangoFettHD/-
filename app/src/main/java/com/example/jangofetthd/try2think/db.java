package com.example.jangofetthd.try2think;

import android.content.SharedPreferences;

/**
 * Created by MikhailTablet on 03.03.2016.
 */
public class db {

    private static String temp_1 = "", temp = "";

    public static void chtostr(int ch){
        for (int z=0; z<db.sections[ch].section.length; z++) {
            temp+=db.sections[ch].section[z].tryCount;
            temp+=db.sections[ch].section[z].helpCount;
            temp+=db.sections[ch].section[z].status;
        }
        temp_1=temp;
        temp="";
    }
    public static void strtoch(int ch){
        System.out.println(temp_1);
        int k=0;
        for (int z=0; z<temp_1.length(); z+=3) {
            db.sections[ch].section[k].tryCount=temp_1.charAt(z)-'0';
            db.sections[ch].section[k].helpCount=temp_1.charAt(z+1)-'0';
            db.sections[ch].section[k].status=temp_1.charAt(z+2)-'0';
            k++;
        }
        temp_1="";
        k = 0;
    }
    private static SharedPreferences P_Main_settings;

    public static void savech(int chapter){
        SharedPreferences.Editor editor = P_Main_settings.edit();
        chtostr(chapter);
        switch (chapter){
            case 0: editor.putString(PrefsContract.db1_ch1, temp_1); break;
            case 1: editor.putString(PrefsContract.db1_ch2, temp_1); break;
        }
    }

    public static void loadch(int chapter){
        switch (chapter){
            case 0: if (P_Main_settings.contains(PrefsContract.db1_ch1)) temp_1=P_Main_settings.getString(PrefsContract.db1_ch1,""); break;
            case 1: if (P_Main_settings.contains(PrefsContract.db1_ch2)) temp_1=P_Main_settings.getString(PrefsContract.db1_ch2,""); break;
        }
        strtoch(chapter);
    }

    static DataBase sections[] = new DataBase[]{
            new DataBase("First Test", 0, 0, new lvl[]{
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //1
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //2
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //3
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //4
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //5
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //6
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //7
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //8
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //9
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //10
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //11
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //12
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //13
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //14
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //15
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //16
            }),
            new DataBase("Second Test", 0, 0, new lvl[]{
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //1
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //2
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //3
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //4
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //5
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //6
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //7
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //8
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //9
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //10
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //11
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //12
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //13
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //14
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //15
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //16
            }),
            new DataBase("3 Test", 0, 0, new lvl[]{
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //1
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //2
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //3
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //4
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //5
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //6
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //7
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //8
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //9
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //10
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //11
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //12
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //13
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //14
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //15
                    new lvl(00, "Подумай", 0, 0, 0, "На второй картинке - байк", 0), //16
            })
    };

    public static class lvl {
        public int image;
        public String answer;
        public int status;
        public int tryCount;
        public int helpCount;
        public int lock;
        public String help;

        lvl(int image, String answer, int tryCount, int helpCount, int lock, String help, int status) {
            this.image = image;
            this.answer = answer;
            this.tryCount = tryCount;
            this.helpCount = helpCount;
            this.lock = lock;
            this.help = help;
            this.status = status;
        }
    }
    public static class DataBase {
        public String name;
        public int price;
        public int lvls;
        public lvl section[];

        DataBase(String name, int price, int lvls, lvl section[]) {
            this.name = name;
            this.price = price;
            this.lvls = lvls;
            this.section = section;
        }
    }
}
