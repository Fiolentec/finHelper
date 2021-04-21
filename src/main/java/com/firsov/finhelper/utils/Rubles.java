package com.firsov.finhelper.utils;

public class Rubles {
    public static String fromInteger(int x) {
        switch (x % 10) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
        }
        return " рублей";
    }
}
