/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.ShoutBoxMessage;
import wad.service.ShoutBoxService;

/**
 *
 * @author sc
 */
@Controller
public class ChatController {
    
    @Autowired
    private ShoutBoxService sbs;
    
    @MessageMapping(value = "/messages")
    public void handleMsg(ShoutBoxMessage message) {
        Logger.getLogger("chatctrl").info("handleMsg() here");
        sbs.sendMsg(message);
    }
}
