package coffmach;

import java.util.Scanner;

public interface fromuser {
    public static int insertCoin(){
        System.out.println("\n** Coffee Machine **\n");
        System.out.println("\n** Insert coins **\n");
        Scanner clavier=new Scanner(System.in);
        int money=clavier.nextInt();
        return money;
    }
}
