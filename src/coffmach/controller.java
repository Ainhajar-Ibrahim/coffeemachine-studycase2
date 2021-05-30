package coffmach;


public class controller extends Thread  {
    final signal s;

    public controller(signal m) {
        this.s=m;

    }

    @Override
    public void run() {
        super.run();

        synchronized (s){
                /*
                sent
                * */

            send(s, signal.FILL_WATER);

            try {
                s.wait();
                System.out.println(s.getMessage());
                System.out.println("water has been filled");
                if(s.getMessage() == signal.OK_WATER){

                    switch (Main.getNb()) {
                        case 1 -> send(s, signal.FILL_COFFEE);
                        case 2 -> send(s, signal.HEAT_WATER);
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                s.wait();
                System.out.println(s.getMessage());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (Main.getNbc()) {
                case 0 -> System.out.println("please wait");
                case 1 -> send(s, signal.ADD_MILK);
                case 2 -> send(s, signal.ADD_SUGAR);
                case 3 ->
                        {send(s,signal.ADD_MILK);
                    System.out.println(("milk first"));
                    try {
                        s.wait();
                        System.out.println(s.getMessage());


                    } catch (InterruptedException e) {
                        e.printStackTrace();}


                    send(s,signal.ADD_SUGAR);
                    System.out.println("sugar will be added");
                    break;}

                case 4 -> System.out.println("a regular coffee with no additions");
                default -> System.out.println("unknown command ");
            }

            try {
                s.wait(200);

                System.out.println(s.getMessage());







            } catch (InterruptedException e) {
                e.printStackTrace();}






        }

    }


    public void send(signal s, int c){

        s.setMessage(c);
        s.notify();
    }


}
