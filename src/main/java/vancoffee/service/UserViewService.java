package vancoffee.service;

import java.util.concurrent.TimeUnit;

public class UserViewService {


    public void showMessage(String message) {
        System.out.println(message);
    }

    public void lineInTable(int length){
        for (int i=1; i<length;i++){
             System.out.printf("%s","-");
        }
        System.out.println();
    }

    public void headInTable(){
        System.out.println("| Арт |   Сорт   |      Тип кави     |Вага (кг)|Ціна (грн)|");
    }


    public void showDownload(String message) throws InterruptedException {
        System.out.printf(message);
        int i = 0;
        while (i < 30) {
            System.out.printf(".");
            TimeUnit.MILLISECONDS.sleep(100);
            i++;
        }
        System.out.printf(" OK\n");
    }

    public void cleanConsole() {
        System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void showBalances(int weight,int capacity,double deposit){
        System.out.printf("Ліміт ваги %18d кг.\nЛіміт об'єму %16d ящ.\nЛіміт коштів %15s грн.\n", weight,capacity,deposit);
    }


}



