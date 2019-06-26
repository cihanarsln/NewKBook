package com.kafein.kbook.util;

import com.kafein.kbook.model.Loan;
import com.kafein.kbook.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailSender {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    private JavaMailSender sender;

    @Scheduled(cron = "30 30 6 * * ?")
    public void mailToUser() throws MessagingException {
        for (Loan loan : loanRepository.findAll()){
            long diff = loan.getMaxDate().getTime()-(new Date()).getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays==5 && loan.getDeliveryDate()==null){
                String text = "Dear "+loan.getUser().getFname()+" "+loan.getUser().getLname()+",\n ID:"+loan.getId()+"\nLast Delivery Date:"+loan.getMaxDate();
                MimeMessage message = sender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo("to@gmail.com");
                helper.setSubject("Last Delivery Date");
                helper.setText(text);
                sender.send(message);
            }

        }
    }



    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("username@gmail.com");
        mailSender.setPassword("password");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
