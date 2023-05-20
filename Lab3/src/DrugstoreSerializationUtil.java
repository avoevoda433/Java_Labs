import java.io.*;

public class DrugstoreSerializationUtil {
    public static void serialize(Drugstore[] drugstores, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(drugstores);
            System.out.println("Объекты успешно сериализованы в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Drugstore[] deserialize(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Drugstore[] drugstores = (Drugstore[]) inputStream.readObject();
            System.out.println("Объекты успешно десериализованы из файла: " + fileName);
            return drugstores;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
