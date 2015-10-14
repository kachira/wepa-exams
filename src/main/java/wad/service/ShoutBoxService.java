/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import wad.domain.ShoutBoxMessage;

/**
 *
 * @author sc
 */
@Service
public class ShoutBoxService {
    @Autowired
    private SimpMessagingTemplate smt;
    
    public void sendMsg(ShoutBoxMessage message) {
        smt.convertAndSend("/chat", message);
    }
}
