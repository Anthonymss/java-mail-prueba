package com.javaMail.EnviarMail.principal;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class enviarcorreo {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMailConHtml(@RequestBody CorreoRequest correoRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(correoRequest.getDestinatario());
            helper.setFrom("tranporteLibertadApi@outlook.es");
            helper.setSubject(correoRequest.getAsunto());

            String htmlContent = correoRequest.getContenido() + "\n\n\n\nby Anthony_mss";

            helper.setText(htmlContent, true);
            javaMailSender.send(message);

            return ResponseEntity.ok("Correo enviado correctamente a " + correoRequest.getDestinatario());
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo");
        }


    }
}
/*
@PostMapping("enviar")
    public ResponseEntity<?> ENVIAR_MAIL_(){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo("giananthonych@gmail.com");
        message.setFrom("tranporteLibertadApi@outlook.es");
        message.setSubject("Enviar pROBANDO EMAILS");
        message.setText("Como estas :)");
        javaMailSender.send(message);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

* */
