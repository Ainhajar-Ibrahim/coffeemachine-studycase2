package coffmach;

public class hardware extends Thread   {

    signal s;

    public hardware(signal m) {
        this.s=m;

    }

    @Override
    public void run() {
        super.run();

        synchronized (s){

            try {
                s.wait(200);
                System.out.println(s.getMessage());
                send(s,signal.OK_WATER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {
                s.wait();
                System.out.println(s.getMessage());
                switch(s.getMessage()){
                    case signal.FILL_COFFEE:
                        send(s,signal.COFFEE_OK);
                        System.out.println("coffee has been filled");
                        break;
                    case signal.HEAT_WATER:
                        send(s, signal.WARM_WATER);
                        System.out.println("water has been heated");
                        break;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {
                s.wait();
                System.out.println(s.getMessage());
                switch(s.getMessage()){
                    case signal.ADD_MILK:
                        send(s,signal.MILK_OK);
                        System.out.println("milk has been filled");
                        break;
                    case signal.ADD_SUGAR:
                        send(s, signal.SUGAR_OK);
                        System.out.println("sugar has been added");
                        break;
                    case signal.ADD_BOTH:
                        send(s,signal.BOTH_OK);
                        System.out.println("sugar and milk have been added");
                        break;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                s.wait();
                System.out.println(s.getMessage());
                send(s,signal.SUGAR_OK);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }

    public void send(signal s, int c){

        s.setMessage(c);
        s.notify();
    }




}
