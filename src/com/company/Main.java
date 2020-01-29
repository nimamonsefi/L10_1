package com.company;

public class Main {

    public static void main(String[] args) {

        Insert insert = new Insert();
        Update update = new Update();
        Show show = new Show();
        Thread threadinsert = new Thread(insert);
        Thread threadupdate = new Thread(update);
        Thread threadshow = new Thread(show);
        threadinsert.start();
        threadupdate.start();
        threadshow.start();
    }
}
