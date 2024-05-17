import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class UAV {

    private float emptyWeight; // ucak bos iken agirligi
    private float maxWeight; // ucagin max kalkis agirligi
    private float filledWeight; // dolu iken agirligi
    private int missleLimit;
    List<Missile> missiles = new ArrayList<>();

    private String missleType;


    //UAV nin durumlari
    private boolean isFlying; // ucak ucup ucmadigini belirleyen  degisken
    private boolean canHoldMissle; // ucak fuze tasiyabildigini yada tasiyamadigini belirleyen degisken

    public UAV(float emptyWeight, float maxWeight, int missleLimit, boolean isFlying, boolean canHoldMissle) {
        this.emptyWeight = emptyWeight;
        this.maxWeight = maxWeight;
        this.missleLimit = missleLimit;
        this.isFlying = isFlying;
        this.canHoldMissle = canHoldMissle;
    }


    //fuze ekleme
    public void addMissile(List<Missile> missiles){

        if(!canHoldMissle){
            System.out.println("ucak fuze tasiyamaz!");
            exit(0);
        }
        if (missleLimit <= missiles.toArray().length)
        {
           System.out.println("Fuze tasima limitini gectiniz!");
        }

        Missile newMissle = new Missile(100 , 10,"hava");

        missiles.add(newMissle);

    }

    public String Fire(){

        if(!isFlying){
            return "Ucak ucama durumunda olmadigi icin fuze ATESLIYEMEZ! ";
        }

        return "Fuze ateslendi";

    }



}
