package coffmach;

public class signal {

    int message;

    public static final int FILL_WATER = 1;
    public static final int OK_WATER = 10;
    public static final int FILL_COFFEE = 2;
    public static final int COFFEE_OK = 20;
    public static final int HEAT_WATER = 3;
    public static final int WARM_WATER = 30;
    public static final int ADD_SUGAR =4;
    public static final int SUGAR_OK =40;
    public static final int ADD_MILK =5;
    public static final int MILK_OK =50;
    public static final int ADD_BOTH =6;
    public static final int BOTH_OK =60;

    public signal(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}
