package ua.goit.moneybot.model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Scheduler {

    UserSettings userSettings = new UserSettings();
    Facade alert = new Facade();
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            alert.getResponseFromBank(userSettings, Message message);
        }
    };
    long time = 0l;
    switch(userSettings.getNotificationTime){
        case(9):
    }
    public void schedule(TimerTask task,Date notification, long period) {
        Date notification = new Date();
        notification.setTime();

        timer.schedule(task, notification, 84600000);
    }

}