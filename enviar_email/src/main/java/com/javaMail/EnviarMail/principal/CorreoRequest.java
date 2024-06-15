package com.javaMail.EnviarMail.principal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorreoRequest {

    private String destinatario;
    private String asunto;
    private String contenido;

}