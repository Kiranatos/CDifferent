package net.kiranatos.javarush.q3threads.lvl2.l2l5t1;

public class TooShortStringFirstThreadException extends RuntimeException {
    public TooShortStringFirstThreadException(StringIndexOutOfBoundsException e) {
        super(e);
    }
}
