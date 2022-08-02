package com.restful2.restful2.Controller;

import com.GenSpark.RESTFulApp_5.Service.EmailSenderService;
import com.restful2.restful2.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired
    private EmailService senderService;

    @RequestMapping("/sendmail")
    public void sendEmail() throws MessagingException
    {
        senderService.sendEmail("*******************", "Test", "Sup");
    }
}
