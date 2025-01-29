package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.service.AssistantAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantResource {
    private final AssistantAiService assistantService;

    AssistantResource(AssistantAiService assistantService) {
        this.assistantService = assistantService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantService.chat(query);
    }
}
