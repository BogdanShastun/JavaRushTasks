package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F

Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    String firstFile = consoleReader.readLine();
    String secondFile = consoleReader.readLine();
    BufferedReader reader = new BufferedReader(new FileReader(firstFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(secondFile));

    StringBuilder builder = new StringBuilder();
    while (reader.ready())
      builder.append(reader.readLine());

    String finalString = builder.toString().replaceAll("\\p{Punct}", "");

    writer.write(finalString);

    consoleReader.close();
    reader.close();
    writer.close();

  }
}
