package coffmach;

import java.util.ArrayList;
import java.util.Scanner;

public interface touser {
    static void returnChange(int money1, int price){
        int change=money1-price;
        System.out.println("Here is your change: "+change);
    }
    static int showMenu(){
        System.out.println("\n** Coffee Machine **\n");
        System.out.println(" Make your choice\n") ;
        System.out.println("1. regular Coffee ...........(10 Dhs)\n") ;
        System.out.println("2. tea ........(5 Dhs)\n") ;
        Scanner clavier=new Scanner(System.in);
        int nb=clavier.nextInt();
        return nb;
    }
    static int showCoffeeMenu(){
        System.out.println("\n** Coffee Machine **\n");
        System.out.println(" Make your choice\n") ;
        System.out.println("1. Milk.........\n") ;
        System.out.println("2. sugar ........\n") ;
        System.out.println("3. Both.........\n") ;
        System.out.println("4. None.........\n") ;
        Scanner clavier=new Scanner(System.in);
        int nbc=clavier.nextInt();
        return nbc;
    }
    static void listofcommande(ArrayList<String> ourlist){
        for (Object ele:ourlist
        ) {
            System.out.println(ele);
        }
    }

}
