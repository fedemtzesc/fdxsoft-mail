package com.fdxsoft.mail.controllers;

import com.fdxsoft.mail.services.IEmailService;
import com.fdxsoft.mail.services.models.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    IEmailService emailService;

    @GetMapping("/testemail")
    private String test(){
        return "Servicio Arriba!";
    }

    @PostMapping("/sendemail")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {

        emailService.sendEmail(email);
        return new ResponseEntity<>("Correo enviado exitosamente!", HttpStatus.OK);
    }

}
