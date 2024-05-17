import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Missile fuze = new Missile(100,50, "hava");
        UAV ucak = new UAV(100,50,10, false ,true);
        List<Missile> missiles = new ArrayList<>();



        System.out.println(ucak.Fire());
        ucak.addMissile(missiles);

        System.out.println(fuze.getTarget());
    }


}