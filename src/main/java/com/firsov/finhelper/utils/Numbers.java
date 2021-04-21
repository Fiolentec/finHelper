package com.firsov.finhelper.utils;

public class Numbers {
    public static String fromInteger(int x) {
        switch(x) {
            case 1:
                return "один ";
            case 10:
                return "десять ";
            case 100:
                return "сто ";
        }
        return "одна ";
    }
}
