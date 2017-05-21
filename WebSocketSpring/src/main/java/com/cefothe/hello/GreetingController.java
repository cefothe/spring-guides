package com.cefothe.hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by cefothe on 21.05.17.
 */
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public  Greeting greeting(HelloMessage helloMessage) throws InterruptedException {
        Thread.sleep(1000);
        return new Greeting("Hello, "+ helloMessage.getName()+" !");
    }
}
