package net.kiranatos.javarush.q2сore.lvl7;

/* Java Core,  7 уровень,  4 лекция 
Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения 
к листу notes блокировали мьютекс notes, не this 
2. Все System.out.println не должны быть заблокированы (синхронизированы), 
т.е. не должны находиться в блоке synchronized

Old variant: package com.javarush.test.level17.lesson04.task01;
 */
import java.util.ArrayList;
import java.util.List;

/* Синхронизированные заметки
1. Класс Note будет использоваться нитями.
Поэтому сделай так, чтобы обращения к листу notes блокировали мютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е.
не должны находиться в блоке synchronized
*/

public class Core7Lvl17Lesson04Task01 {
     public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            synchronized (notes) { notes.add(index, note); }
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            synchronized (notes) { String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index); }
        }
    }    
}
