import java.util.ArrayList;
import java.util.List;

public class UAV {
    private final float emptyWeight; // immutable
    private final float maxWeight; // immutable
    private final int missileLimit;
    private final List<Missile> missiles;
    private final boolean canHoldMissile;
    private boolean isFlying;

    public UAV(float emptyWeight, float maxWeight, int missileLimit, boolean isFlying, boolean canHoldMissile) {
        this.emptyWeight = emptyWeight;
        this.maxWeight = maxWeight;
        this.missileLimit = missileLimit;
        this.isFlying = isFlying;
        this.canHoldMissile = canHoldMissile;
        this.missiles = new ArrayList<>();
    }

    // Add missile
    public void addMissile(Missile missile) {
        if (!canHoldMissile) {
            System.out.println("Uçak füze taşıyamaz!");
            return;
        }
        if (missiles.size() >= missileLimit) {
            System.out.println("Füze taşıma limitini geçtiniz!");
            return;
        }
        if ((getCurrentWeight() + missile.getWeight()) > maxWeight) {
            System.out.println("Maksimum kalkış ağırlığını aştınız!");
            return;
        }
        missiles.add(missile);
    }

    // Get current weight
    public float getCurrentWeight() {
        float currentWeight = emptyWeight;
        for (Missile missile : missiles) {
            currentWeight += missile.getWeight();
        }
        return currentWeight;
    }

    // Fire missile
    public String fire() {
        if (!isFlying) {
            return "Uçak uçma durumunda olmadığı için füze ATEŞLEYEMEZ!";
        }
        if (missiles.isEmpty()) {
            return "Ateşlenecek füze yok!";
        }
        missiles.remove(0);
        return "Füze ateşlendi!";
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }
}
