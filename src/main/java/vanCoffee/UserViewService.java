package vanCoffee;

import java.util.concurrent.TimeUnit;

public class UserViewService {


    public void showMessage(String message) {
        System.out.println(message);
    }


    public void showDownload(String message) throws InterruptedException {
        System.out.printf(message);
        int i = 0;
        while (i < 30) {
            System.out.printf(".");
            TimeUnit.MILLISECONDS.sleep(1);
            i++;
        }
        System.out.printf(" OK\n");
    }

    public void cleanConsole() {
        System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


}



