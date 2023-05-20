import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Чтение текста из файла
        String filePath = "TextFile.txt";
        String text = TextFileReader.readTextFromFile(filePath);

        // Создание экземпляра TextProcessor и обработка текста
        TextProcessor textProcessor = new TextProcessor(text);
        String processedText = textProcessor.processText();

        // Запись результата в файл
        String outputFilePath = "OutputFile.txt";
        writeTextToFile(processedText, outputFilePath);

        System.out.println("Результат записан в файл " + outputFilePath);
    }

    private static void writeTextToFile(String text, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
