package LucasGodoy1.com.github.telegran;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegraaAutoMsg extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            // Implemente a lógica para responder a mensagens específicas
            if (messageText.equals("/ola")) {
                sendResponse(chatId, "Olá! esse é o bot preAlpha do king");
            }
        }
    }

    private void sendResponse(long chatId, String response) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId)); // Convertendo chatId para String
        message.setText(response);
        try {
            execute(message); // Chama o método para enviar a mensagem
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void runBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            botsApi.registerBot(this);
            System.out.println("Bot iniciado. Pressione Ctrl-C para encerrar.");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "bob_vagas_bot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("TELEGRAM_BOT_TOKEN");
    }



}
