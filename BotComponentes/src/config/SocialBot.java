/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author Daniel Garro
 */
public class SocialBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        //Id usuario
        Long id = update.getMessage().getChatId();
        //Mensaje del usuario
        String mensajeRecibido = update.getMessage().getText();

        String command = update.getMessage().getText();

        SendMessage message = new SendMessage().setChatId(id);
        message.setChatId(update.getMessage().getChatId());

        if (mensajeRecibido.equals("/empezar")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText("Hola" + " " + update.getMessage().getFrom().getFirstName() + ", comandos dispnibles \n"
                    + "/FAQ \n"
                    + "/estadisticaCampaña ");

        }

       else if (mensajeRecibido.equals("/FAQ")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText("Estas son nuestras preguntas más frecuentes");

            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            // Create the keyboard (list of keyboard rows)
            List<KeyboardRow> keyboard = new ArrayList<>();
            // Crear keyboard.
            KeyboardRow row = new KeyboardRow();
            // botones
            row.add("¿Como puedo mandar un mensaje a mis usuarios?");
            row.add("¿Como creo una campaña nueva?");

            keyboard.add(row);
            // crear otro keyboar row
            row = new KeyboardRow();
            // agregar datos 
            row.add("¿ ");
            row.add("-------------");

            // agrega el segundo row
            keyboard.add(row);
            row = new KeyboardRow();
            row.add("-----------");
            keyboard.add(row);
            keyboardMarkup.setKeyboard(keyboard);

            message.setReplyMarkup(keyboardMarkup);
        }
       else if (mensajeRecibido.equals("¿Como puedo mandar un mensaje a mis usuarios?")) {
            message.setText("");
        }
       else  if (mensajeRecibido.equals("¿Como creo una campaña nueva?")) {
            message.setText("");

        }
       else if (mensajeRecibido.equals("")) {
            message.setText("");

        }
       else if (mensajeRecibido.equals("")) {
            message.setText("");

        }
       else if (mensajeRecibido.equals("")) {
            message.setText("");
        }

       else if (mensajeRecibido.equals("/estadisticas")) {
          message.setText("http://carlosguerraterol.com/wp-content/uploads/2016/04/Visi%C3%B3n-Genral-Publicaciones-Recientes-Estadisticas-Facebook.jpg");
        }
       else if (mensajeRecibido.contains("/soporte")) {

            String pregunta = update.getMessage().getText().replace("/soporte", "");

            long idAdmin;
            idAdmin = 301740632;
            SendMessage consulta = new SendMessage().setChatId(idAdmin);

            //idAdmin = 301740632; ChatId Daniel
            //chatId Mau 527652281
            consulta.setChatId(idAdmin);
            consulta.setText("El usuario: " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName()
                    + ", ha enviado la siguiente consulta:" + pregunta + ". Username: " + update.getMessage().getFrom().getUserName());

            message.setText("Su consulta:" + update.getMessage().getText().replace("/soporte", "") + ", ha sido enviada. Pronto será contactado.");

            try {
                sendMessage(consulta);
            } catch (TelegramApiException ex) {
                Logger.getLogger(SocialBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       else if (mensajeRecibido.equals("/esconder")) {
            message.setChatId(id).setText("Teclado oculto...");
            ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
            message.setReplyMarkup(keyboardMarkup);

        }else{
           message.setText("No entiendo este comando");
       }

        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public void sendImageFromUrl(String url, String chatId) {
    SendPhoto sendPhotoRequest = new SendPhoto();
    sendPhotoRequest.setChatId(chatId);
    sendPhotoRequest.setPhoto("http://carlosguerraterol.com/wp-content/uploads/2016/04/Visi%C3%B3n-Genral-Publicaciones-Recientes-Estadisticas-Facebook.jpg");
    try {
        sendPhoto(sendPhotoRequest);
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }
}


    @Override
    public String getBotToken() {
        return "786169873:AAEMbo8sY_9O9EC58KMF_3sZv0Uh5mRUro8";
    }

    @Override
    public String getBotUsername() {
        return "@SocialUBot";
    }

}
