package LucasGodoy1.com.github.service;

import LucasGodoy1.com.github.model.TelegraaAutoMsg;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class TesteTelegran {
    public static void main(String[] args) throws TelegramApiException {
        TelegraaAutoMsg bot = new TelegraaAutoMsg();
        bot.runBot();


    }

}

