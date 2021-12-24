package ua.goit.moneybot.model;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Objects;

public class UserSettings {

    private byte digitAfterComa;
    private boolean usd;
    private boolean eur;
    private boolean rub;
    private String selectedBank;
    private boolean notification;
    private byte notificationTime;

    public UserSettings() {
        this.digitAfterComa = 2;
        this.usd = true;
        this.selectedBank = "Monobank";
    }

    public byte getDigitAfterComa() {
        return digitAfterComa;
    }

    public void setDigitAfterComa(byte digitAfterComa) {
        this.digitAfterComa = digitAfterComa;
    }

    public boolean isUsd() {
        return usd;
    }

    public void setUsd(boolean usd) {
        this.usd = usd;
    }

    public boolean isEur() {
        return eur;
    }

    public void setEur(boolean eur) {
        this.eur = eur;
    }

    public boolean isRub() {
        return rub;
    }

    public void setRub(boolean rub) {
        this.rub = rub;
    }

    public String getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(String selectedBank) {
        this.selectedBank = selectedBank;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public byte getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(byte notificationTime) {
        this.notificationTime = notificationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSettings that = (UserSettings) o;
        return digitAfterComa == that.digitAfterComa && usd == that.usd && eur == that.eur && rub == that.rub && notification == that.notification && notificationTime == that.notificationTime && Objects.equals(selectedBank, that.selectedBank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitAfterComa, usd, eur, rub, selectedBank, notification, notificationTime);
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "digitAfterComa=" + digitAfterComa +
                ", usd=" + usd +
                ", eur=" + eur +
                ", rub=" + rub +
                ", selectedBank='" + selectedBank + '\'' +
                ", notification=" + notification +
                ", notificationTime=" + notificationTime +
                '}';
    }
}

