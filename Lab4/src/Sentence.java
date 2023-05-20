import java.util.List;

public class Sentence {
    private List<Word> words;

    public Sentence(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        StringBuilder sentenceBuilder = new StringBuilder();

        for (Word word : words) {
            sentenceBuilder.append(word.toString()).append(" ");
        }

        return sentenceBuilder.toString().trim();
    }
}
