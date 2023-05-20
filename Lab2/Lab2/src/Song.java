public class Song extends MusicComposition {
    private String style;

    public Song(String title, String artist, int duration, String style) {
        super(title, artist, duration);
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
