package org.plan.managementweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UIController {
    @GetMapping("/layout")
    public String layout (HttpServletResponse response) {
        response.setHeader("Clear-Site-Data", "cookies");
        return "layout";
    }
}
