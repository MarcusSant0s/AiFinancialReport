package com.AiFinancialReport;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final ChatModel chatModel;

    public MyController(ChatModel chatModel){
        this.chatModel = chatModel;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String text){
        return chatModel.call(new Prompt(text))
                .getResult().getOutput().getText();
    }
}
