import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a UAV
        System.out.print("UAV boş ağırlığını girin: ");
        float emptyWeight = scanner.nextFloat();

        System.out.print("UAV maksimum kalkış ağırlığını girin: ");
        //bunu muaz ekledi
        float maxWeight = scanner.nextFloat();

        System.out.print("UAV füze limiti: ");
        int missileLimit = scanner.nextInt();

        System.out.print("UAV uçuyor mu? (true/false): ");
        boolean isFlying = scanner.nextBoolean();
        //benim adim name
        System.out.print("UAV füze taşıyabilir mi? (true/false): ");
        boolean canHoldMissile = scanner.nextBoolean();

        UAV uav = new UAV(emptyWeight, maxWeight, missileLimit, isFlying, canHoldMissile);
        //fsdffsdf
        // Create a Missile
        System.out.print("Füze menzilini girin: ");
        float range = scanner.nextFloat();

        System.out.print("Füze ağırlığını girin: ");
        float weight = scanner.nextFloat();

        scanner.nextLine(); // consume the newline

        System.out.print("Füze hedefini girin (hava/kara): ");
        String target = scanner.nextLine();

        Missile missile = new Missile(range, weight, target);

        List<Missile> missiles = new ArrayList<>();
        missiles.add(missile);

        // Add missile to UAV
        uav.addMissile(missile);

        // Fire missile
        System.out.println(uav.fire());

        // Print UAV and missile details
        System.out.println("UAV şu anda " + uav.getCurrentWeight() + " kg ağırlığında.");
        System.out.println("Füze hedefi: " + missile.getTarget());
    }
}
