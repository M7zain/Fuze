import java.util.Objects;

public class Missile {
    private final float range; // immutable
    private final float weight; // immutable
    private final String target; // immutable

    public float getRange() {
        return range;
    }

    public float getWeight() {
        return weight;
    }

    public String getTarget() {
        return target;
    }

    // Constructor
    public Missile(float range, float weight, String target) {
        if (!Objects.equals(target, "hava") && !Objects.equals(target, "kara")) {
            throw new IllegalArgumentException("Hedef sadece hava ya da kara OLMALIDIR.");
        }
        this.range = range;
        this.weight = weight;
        this.target = target;
    }
}
