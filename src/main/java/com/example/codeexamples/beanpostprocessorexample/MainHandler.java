package com.example.codeexamples.beanpostprocessorexample;

import com.example.codeexamples.beanpostprocessorexample.handler.EventHandler;
import com.example.codeexamples.beanpostprocessorexample.handler.FacebookEventHandler;
import com.example.codeexamples.beanpostprocessorexample.handler.InstagramEventHandler;
import com.example.codeexamples.beanpostprocessorexample.handler.SlackEventHandler;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MainHandler {

    // change annotation to @Autowired to inject all handlers
    @InjectList({FacebookEventHandler.class, InstagramEventHandler.class, SlackEventHandler.class})
    private List<EventHandler> handlers;

    public void handleEvents() {
        handlers.forEach(EventHandler::handle);
    }
}
