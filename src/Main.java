import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            float emptyWeight, maxWeight;
            int missileLimit = 0;
            boolean isFlying, canHoldMissile;
            UAV uav = null;


            // Bir UAV oluştur
            while (true) {
                System.out.print("UAV boş ağırlığını girin: ");
                emptyWeight = scanner.nextFloat();
                if (emptyWeight == 0) {
                    System.out.println("Program sonlandırılıyor...");
                    return;
                }

                System.out.print("UAV maksimum kalkış ağırlığını girin: ");
                maxWeight = scanner.nextFloat();

                if (emptyWeight > maxWeight) {
                    System.out.println("UAV boş ağırlığı, UAV maksimum kalkış ağırlığından büyük OLAMAZ!");

                } else {
                    System.out.print("UAV uçuyor mu? (true/false): ");
                    isFlying = scanner.nextBoolean();

                    System.out.print("UAV füze taşıyabilir mi? (true/false): ");
                    canHoldMissile = scanner.nextBoolean();

                    uav = new UAV(emptyWeight, maxWeight, missileLimit, isFlying, canHoldMissile);
                    break; // döngüyü sonlandırmak için.
                }
            } //1. while dongunun bitisi.

            if (canHoldMissile) {
                // Bir Füze oluştur
                System.out.print("UAV füze limiti: ");
                missileLimit = scanner.nextInt();

                System.out.print("Füze menzilini girin: ");
                float range = scanner.nextFloat();

                System.out.print("Füze ağırlığını girin: ");
                float weight = scanner.nextFloat();

                scanner.nextLine(); // satır sonu karakterini tüket

                System.out.print("Füze hedefini girin (hava/kara): ");
                String target = scanner.nextLine();

                Missile missile = new Missile(range, weight, target);

                List<Missile> missiles = new ArrayList<>();
                missiles.add(missile);

                // Füzeyi UAV'ye ekle
                uav.addMissile(missile);

                // Füze ateşle
                System.out.println(uav.fire());

                float totalWeight = uav.getCurrentWeight() + (missile.getWeight()*missileLimit);
                // UAV ve füze detaylarını yazdır
                System.out.println("UAV şu anda " + totalWeight + " kg ağırlığında.");
                System.out.println("Füze hedefi: " + missile.getTarget());


            } else {
                System.out.println("UAV füze taşımıyor, füze ile ilgili işlemler atlanmıştır.");
            }
            System.out.println("*********************** ( Kodu sonlandırmak için '0' tuşuna basınız ) ***********************");
        }
    }
} //2. while (butun kodu kapsayan while) sonu.
