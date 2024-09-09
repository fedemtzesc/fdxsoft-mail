package com.fdxsoft.mail.services.models;

import lombok.Data;

@Data
public class EmailDTO {
    private String destinatario;
    private String asunto;
    private String mensaje;

}
