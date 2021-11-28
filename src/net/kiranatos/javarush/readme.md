Java Rush Notes / 21 (finished).docx

Decipher for names:
ThreadsL1L2T1 - Java Multithreading Level #1, Lesson #2, Task 01

**************************************************************************
ThreadsL1L2T1 : Определяем адрес сети
    task: make out the meaning of (bytes[i] & (0xff). The topic is broader than it seems.
    tags: bit_operation, IP_address

ThreadsL1L2T2 : Сравниваем модификаторы
    task: consider bit operation : (allModifiers&specificModifier)==specificModifier.
    tags: reflection

ThreadsL1L2T3 : Все гениальное - просто!
    task: back and re-consider, when I will know boolean algebra better

ThreadsL1L8T1 : Глубокое клонирование карты
    theme: deep cloning

ThreadsL1L10T1Demo : Рефакторинг
    theme: ZIP-archive
    note: в SCore есть конспект

ThreadsL1L10T2 : Освобождаем ресурсы
    task: I will be back, when repeat SQL
    tags: SQL

ThreadsL1L10T3 : AutoCloseable и try-with-resources
    task: Решить! Обновлённая задача, вместо решённой. Сайт считает её решонной - остаестя только изучить возможные варианты решения без проверки.


********************************************************************
Как в java скачать файл из интернета?
URL website = new URL("http://www.website.com/information.asp");
ReadableByteChannel rbc = Channels.newChannel(website.openStream());
FileOutputStream fos = new FileOutputStream("information.html");
fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);