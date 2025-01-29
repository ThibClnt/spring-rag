package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.web.dto.SampleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResource {

    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) String value) {
        return "Hello " + value + "!";
    }

    @GetMapping("/samples/dto/{value}")
    public SampleDTO helloDTO(@PathVariable(value = "value", required = false) String value) {
        return new SampleDTO("Hello " + value + "!");
    }
}
