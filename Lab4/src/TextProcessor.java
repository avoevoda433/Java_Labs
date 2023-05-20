import java.util.ArrayList;
import java.util.List;

public class TextProcessor {
    private String text;

    public TextProcessor(String text) {
        this.text = text;
    }

    public String processText() {
        StringBuilder processedText = new StringBuilder();

        // Разделение текста на предложения
        String[] sentences = text.split("[.!?]+");

        // Обработка каждого предложения
        for (String sentence : sentences) {
            Sentence processedSentence = processSentence(sentence);
            processedText.append(processedSentence.toString()).append(" ");
        }

        return processedText.toString().trim();
    }

    private Sentence processSentence(String sentence) {
        List<Word> words = new ArrayList<>();

        // Разделение предложения на слова
        String[] sentenceWords = sentence.split("\\s+");

        // Добавление слов в список
        for (String word : sentenceWords) {
            words.add(new Word(word));
        }

        // Поменять местами первое и последнее слово
        if (words.size() >= 2) {
            Word firstWord = words.get(0);
            Word lastWord = words.get(words.size() - 1);
            words.set(0, lastWord);
            words.set(words.size() - 1, firstWord);
        }

        return new Sentence(words);
    }
}
