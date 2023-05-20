import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disk {
    private List<MusicComposition> compositions;

    public Disk() {
        compositions = new ArrayList<>();
    }

    public void addComposition(MusicComposition composition) {
        compositions.add(composition);
    }

    public void rearrangeCompositionsByStyle(String style) {
        Collections.sort(compositions, (c1, c2) -> {
            if (c1.getStyle().equals(style) && !c2.getStyle().equals(style)) {
                return -1;
            } else if (!c1.getStyle().equals(style) && c2.getStyle().equals(style)) {
                return 1;
            }
            return 0;
        });
    }

    public MusicComposition findCompositionByDurationRange(int minDuration, int maxDuration) {
        for (MusicComposition composition : compositions) {
            if (composition.getDuration() >= minDuration && composition.getDuration() <= maxDuration) {
                return composition;
            }
        }
        return null;
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (MusicComposition composition : compositions) {
            totalDuration += composition.getDuration();
        }
        return totalDuration;
    }

    public List<MusicComposition> getCompositions() {
        return compositions;
    }


    public void printCompositions() {
        for (MusicComposition composition : compositions) {
            System.out.println(composition);
        }
    }
}
