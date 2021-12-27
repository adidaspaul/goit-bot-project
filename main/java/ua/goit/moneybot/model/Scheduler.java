package ua.goit.moneybot.model;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.goit.moneybot.controller.Application;
import ua.goit.moneybot.controller.Controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    public void schedulerStart(Message message) {

        Calendar calendar = new GregorianCalendar();

        for (User user :
                UserService.getUserService().getUserList()) {
            if (user.getNotificationTime() != 0) {
                calendar.set(Calendar.HOUR_OF_DAY, user.getNotificationTime());
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                Date date = calendar.getTime();
                long delay = date.getTime() - System.currentTimeMillis();
                if (delay < 0) {
                    delay = delay + 24 * 60 * 60 * 1000;
                }
                System.out.println(delay);
                System.out.println(date);

                Runnable runnable = () -> {
                    try {
                        Application.getBot().execute(SendMessage.builder()
                                .text(UserService.getUserService().getInfo(message))
                                .chatId(user.getChatId().toString())
                                .build());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                };
                executor.scheduleAtFixedRate(runnable, date.getTime() - System.currentTimeMillis(), 24 * 60 * 60 * 1000, TimeUnit.MILLISECONDS);
            }
        }
    }
}

