package com.fdxsoft.mail.services.impl;

import com.fdxsoft.mail.services.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import com.fdxsoft.mail.services.models.EmailDTO;
import org.thymeleaf.context.Context;


@Data
@Service
public class EmailServiceImpl implements IEmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Override
    public void sendEmail(EmailDTO email) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage() ;
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email.getDestinatario());
            helper.setSubject(email.getAsunto());
            //helper.setText(email.getMensaje()); Esto es si quisieramos mandas solo texto plano en el msg
            Context context = new Context();
            context.setVariable("mensaje", email.getMensaje());
            String contentHTML = templateEngine.process("email", context);
            helper.setText(contentHTML, true);
            javaMailSender.send(message);
        }catch(Exception e){
            throw new RuntimeException("No fue posible enviar el correo debido a: " + e.getMessage(), e);
        }
;    }

}
