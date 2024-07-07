package LucasGodoy1.com.github.model;

import LucasGodoy1.com.github.service.Encontre;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.List;

public class TelegraaAutoMsg extends TelegramLongPollingBot {
    final String emoji = "\uD83D\uDE80\uD83C\uDF89\uD83C\uDF8A";
    private List<String> vagasEncontradas;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String userName = update.getMessage().getFrom().getUserName();
            String firstName = update.getMessage().getFrom().getFirstName();
            String lastName = update.getMessage().getFrom().getLastName();
            long chatId = update.getMessage().getChatId();
            String bsc = messageText.toLowerCase().trim().substring(5);
            String msg;



            System.out.println("==========================");
            System.out.println("Chat ID: " + chatId);
            System.out.println("User Name: " + (userName != null ? userName : "N/A"));
            System.out.println("First Name: " + (firstName != null ? firstName : "N/A"));
            System.out.println("Last Name: " + (lastName != null ? lastName : "N/A"));
            System.out.println("Message: " + messageText);
            System.out.println("==========================");

            if (messageText.toLowerCase().contains("/vaga")) {
                try {
                    bsc.trim();
                    sendResponse(chatId, "Aguarde...");
                    var e = new Encontre();
                    vagasEncontradas = e.iniciarBusca(bsc);
                    msg = "Total de vagas encontradas: " + vagasEncontradas.size() + emoji + " buscado por: " + bsc;


                    if (!vagasEncontradas.isEmpty()) {

                        sendResponse(chatId, msg);
                        vagasEncontradas.forEach(link -> sendResponse(chatId, link));
                        System.out.println(msg);

                    } else {
                        msg = "Nenhuma Vaga encontrada " + "\uD83D\uDE05" + " buscado por: " + bsc;
                        sendResponse(chatId, msg);
                        System.out.println(msg);
                    }


                } catch (IOException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    sendResponse(chatId, "Obrigado por  usar o BOb Bot\n V1.1_Pre_Alpha " +
                            "\n ©️ gitHub.com/LucasGodoy1");

                    System.out.println("====================");
                    vagasEncontradas.forEach(System.out::println);
                    vagasEncontradas.clear();
                }


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
