public class WriterInfo {
    public static void printInfo(MusicComposition composition) {
        System.out.println("Title: " + composition.getTitle());
        System.out.println("Artist: " + composition.getArtist());
        System.out.println("Duration: " + composition.getDuration() + " seconds");
        System.out.println("Style: " + composition.getStyle());
        System.out.println();
    }
}
