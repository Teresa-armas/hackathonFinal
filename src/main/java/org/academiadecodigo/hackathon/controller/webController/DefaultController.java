package org.academiadecodigo.hackathon.controller.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("defaultPack")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET, value = {"", "/"})
    public String defaultPack() {
        return "default";
    }

}
