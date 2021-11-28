package net.kiranatos.javarush.q3threads.lvl1;

/* Java Multithreading level 1, lection 2, task 1

Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании

Old variant: package com.javarush.test.level21.lesson02.task01;
byte 8 bit  -128 … +127
 */

public class ThreadsL1L02T1 {
    public static void main(String[] args) {
        byte[] ip = new byte[]  {(byte)192, (byte)168, 1, 2};
        byte[] mask = new byte[]{(byte)255, (byte)255, (byte)254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] address = new byte[4];

        for (int i=0; i<4; i++) {
            //address[i] = (byte)((ip[i]& (0xff)) & (mask[i]& (0xff)));
            address[i] = (byte)(ip[i] & mask[i]);
        }
        return address;
    }

    public static void print(byte[] bytes) {
        for (int i=0; i<bytes.length; i++) {
            //System.out.print(Integer.toBinaryString(bytes[i]& (0xff)) + " ");
            String str = String.valueOf(Integer.toBinaryString(bytes[i] & (0xff)));

            while (str.length()<8) 
                str='0'+str;

            if (i == bytes.length-1) System.out.print(str + "\n");
            else System.out.print(str + " ");
        }
    }
}
