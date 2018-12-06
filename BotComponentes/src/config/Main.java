/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

/**
 *
 * @author Daniel Garro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        SocialBot bot = new SocialBot();
        
        try 
        {
            telegramBotsApi.registerBot(bot);
        }
        catch (TelegramApiRequestException e)
        {
            e.printStackTrace();
            
    }
    }
    }
    

