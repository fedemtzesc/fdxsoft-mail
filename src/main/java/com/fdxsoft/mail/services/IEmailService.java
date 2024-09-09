package com.fdxsoft.mail.services;

import com.fdxsoft.mail.services.models.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailService {
    public void sendEmail(EmailDTO email) throws MessagingException;


}
