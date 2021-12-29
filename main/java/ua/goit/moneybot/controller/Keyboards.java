package ua.goit.moneybot.controller;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.goit.moneybot.model.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keyboards {

    UserService userService = UserService.create();

    public List<List<InlineKeyboardButton>> getMainMenu(){
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Получить инфо")
                                .callbackData("get_info")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Настройки")
                                .callbackData("settings")
                                .build()));
        return menu;
    }

    public List<List<InlineKeyboardButton>> getSettingsMenu(){
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Кол-во знаков после запятой")
                                .callbackData("digitAfterComa")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Банк")
                                .callbackData("banks")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Валюты")
                                .callbackData("currency")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Время оповещений")
                                .callbackData("schedule")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("На главную")
                                .callbackData("/start")
                                .build()));
        return menu;
    }

    public List<List<InlineKeyboardButton>> getDigitMenu(Message message){
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getDigitAfterComa() == (byte) 2 ? "✅2" : "2")
                                .callbackData("/2")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getDigitAfterComa() == (byte) 3 ? "✅3" : "3")
                                .callbackData("/3")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getDigitAfterComa() == (byte) 4 ? "✅4" : "4")
                                .callbackData("/4")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("На главную")
                                .callbackData("/start")
                                .build()));
        return menu;

    }

    public List<List<InlineKeyboardButton>> getBankMenu(Message message){
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getSelectedBank().equals("Monobank") ? "✅Monobank" : "Monobank")
                                .callbackData("Monobank")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getSelectedBank().equals("PrivatBank") ? "✅PrivatBank" : "PrivatBank")
                                .callbackData("PrivatBank")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getSelectedBank().equals("NBU") ? "✅NBU" : "NBU")
                                .callbackData("NBU")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("На главную")
                                .callbackData("/start")
                                .build()));
        return menu;
    }

    public List<List<InlineKeyboardButton>> getCurrencyMenu(Message message) {
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isUsd() ? "✅USD" : "USD")
                                .callbackData("USD")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isEur() ? "✅EUR" : "EUR")
                                .callbackData("EUR")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isRub() ? "✅RUB" : "RUB")
                                .callbackData("RUB")
                                .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("На главную")
                                .callbackData("/start")
                                .build()));
        return menu;
    }

    public List<List<InlineKeyboardButton>> getTimeAlert(Message message) {
        byte time = userService.getUser(message).getNotificationTime();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText(time == 9 ? "✅09:00" : "09:00");
        inlineKeyboardButton1.setCallbackData("09:00");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText(time == 10 ? "✅10:00" : "10:00");
        inlineKeyboardButton2.setCallbackData("10:00");
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText(time == 11 ? "✅11:00" : "11:00");
        inlineKeyboardButton3.setCallbackData("11:00");
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText(time == 12 ? "✅12:00" : "12:00");
        inlineKeyboardButton4.setCallbackData("12:00");
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        inlineKeyboardButton5.setText(time == 13 ? "✅13:00" : "13:00");
        inlineKeyboardButton5.setCallbackData("13:00");
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        inlineKeyboardButton6.setText(time == 14 ? "✅14:00" : "14:00");
        inlineKeyboardButton6.setCallbackData("14:00");
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        inlineKeyboardButton7.setText(time == 15 ? "✅15:00" : "15:00");
        inlineKeyboardButton7.setCallbackData("15:00");
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        inlineKeyboardButton8.setText(time == 16 ? "✅16:00" : "16:00");
        inlineKeyboardButton8.setCallbackData("16:00");
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
        inlineKeyboardButton9.setText(time == 17 ? "✅17:00" : "17:00");
        inlineKeyboardButton9.setCallbackData("17:00");
        InlineKeyboardButton inlineKeyboardButton10 = new InlineKeyboardButton();
        inlineKeyboardButton10.setText(time == 18 ? "✅18:00" : "18:00");
        inlineKeyboardButton10.setCallbackData("18:00");
        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        inlineKeyboardButton11.setText(time == 0 ? "✅Выключить уведомления" : "Выключить уведомления");
        inlineKeyboardButton11.setCallbackData("0");
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        inlineKeyboardButton12.setText("На главную");
        inlineKeyboardButton12.setCallbackData("/start");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow2.add(inlineKeyboardButton4);
        keyboardButtonsRow2.add(inlineKeyboardButton5);
        keyboardButtonsRow2.add(inlineKeyboardButton6);
        keyboardButtonsRow3.add(inlineKeyboardButton7);
        keyboardButtonsRow3.add(inlineKeyboardButton8);
        keyboardButtonsRow3.add(inlineKeyboardButton9);
        keyboardButtonsRow4.add(inlineKeyboardButton10);
        keyboardButtonsRow4.add(inlineKeyboardButton11);
        keyboardButtonsRow4.add(inlineKeyboardButton12);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);



        return rowList;
    }



}
