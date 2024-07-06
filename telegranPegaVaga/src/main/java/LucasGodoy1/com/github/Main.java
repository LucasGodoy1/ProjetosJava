package LucasGodoy1.com.github;


import LucasGodoy1.com.github.telegran.TelegraaAutoMsg;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        TelegraaAutoMsg bot = new TelegraaAutoMsg();
        bot.runBot();

            }

}