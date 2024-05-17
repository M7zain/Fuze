import java.util.Objects;

public class Missile {

    private float range;
    private float weights;
    private String target;

    public float getRange() {
        return range;
    }

    public float getWeights() {
        return weights;
    }

    public String getTarget() {
        return target;
    }

    // constructor
    public Missile(float range, float weights , String target){
        if(!Objects.equals(target, "hava") && !Objects.equals(target, "kara")){
            System.out.println("Hedef sadece hava yada kara OLMALIDIR.");
        }

        this.range = range;
        this.weights = weights;
        this.target = target;

    }
}
