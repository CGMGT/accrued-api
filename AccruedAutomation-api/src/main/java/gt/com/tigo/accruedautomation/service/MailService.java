package gt.com.tigo.accruedautomation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String from, String[] to, String subject, String body) {

        try{
            MimeMessage mail = javaMailSender.createMimeMessage();
            mail.setSubject(subject);
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(mail, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(body, true);

            javaMailSender.send(mail);
        } catch (MessagingException ex) {
            logger.error(ex.getMessage());
        }

    }
}

