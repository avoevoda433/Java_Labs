package com.drugstore;
import java.io.*;

public class ObjectIO {
    public static void serializeObjects(Object[] objects, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(objects);
            System.out.println("Объекты успешно сериализованы в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации объектов: " + e.getMessage());
        }
    }

    public static Object[] deserializeObjects(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object[] objects = (Object[]) inputStream.readObject();
            System.out.println("Объекты успешно десериализованы из файла: " + filePath);
            return objects;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации объектов: " + e.getMessage());
        }
        return null;
    }
}

