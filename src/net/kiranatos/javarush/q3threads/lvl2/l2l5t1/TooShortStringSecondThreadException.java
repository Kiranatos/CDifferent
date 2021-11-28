package net.kiranatos.javarush.q3threads.lvl2.l2l5t1;

public class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(StringIndexOutOfBoundsException e) {
        super(e);
    }
}
