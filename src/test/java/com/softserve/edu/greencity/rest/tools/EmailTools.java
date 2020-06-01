package com.softserve.edu.greencity.rest.tools;

import com.softserve.edu.greencity.rest.data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.mail.*;

public class EmailTools {
    private static String host = "imap.gmail.com";
    private static String protocol = "imaps";
    private static TimeUnit delayUnit = TimeUnit.SECONDS;
    private static int delay = 30;

    private Session session;
    private User mailUser;
    private Logger logger;

    public EmailTools(User mailUser) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", protocol);
        this.session = Session.getDefaultInstance(props, null);
        this.mailUser = mailUser;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public Store connectToStore(String userName, String password) {
        Folder emailFolder = null;
        Store store = null;
        try {
            store = session.getStore(protocol);
            store.connect(host, userName,password);
        } catch (MessagingException e) {
            logger.error(e.toString());
        }
        return store;
    }

    private List<Message> getMessagesFromStore(Store store) {
        List<Message> messages = null;
        try {
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            messages = Arrays.asList(folder.getMessages());
//            folder.close(false);
//            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public List<Message> getInboxMessages() {
        return getMessagesFromStore(this.connectToStore(mailUser.getEmail(), mailUser.getPassword()));
    }

    public List<Message> getUnreadMessages() {
        return getInboxMessages().stream().filter(message -> {
                try {
                    return !message.isSet(Flags.Flag.SEEN);
                } catch (MessagingException e) {
                    logger.error(e.toString());
                    return false;
                }
            }).collect(Collectors.toList());
    }

    public List<Message> filterMessagesByFrom(String from, List<Message> messages) {
        return messages.stream().filter(message -> {
            try {
                return message.getFrom()[0].toString().equals(from);
            } catch (MessagingException e) {
                logger.error(e.toString());
                return false;
            }
        }).collect(Collectors.toList());
    }

    public List<Message> filterMessagesBySubject(String subject, List<Message> messages) {
        return messages.stream().filter(message -> {
            try {
                return message.getSubject().equals(subject);
            } catch (MessagingException e) {
                logger.error(e.toString());
                return false;
            }
        }).collect(Collectors.toList());
    }


    public Message waitForMessage(String from, String subject) {
        Message targetMessage = null;

        while (targetMessage == null) {
            DelayTool.wait(delayUnit, delay);

            List<Message> filteredMessages = filterMessagesByFrom(from,
                    filterMessagesBySubject(subject, this.getInboxMessages())); // fixme
            if (filteredMessages.size() > 0) {
                targetMessage = filteredMessages.get(filteredMessages.size()-1);
                markAsRead(targetMessage);
            }

        }

        return targetMessage;
    }

    public void markAsRead(Message message) {
        try {
            message.setFlag(Flags.Flag.SEEN, true);
        } catch (MessagingException e) {
            logger.error(e.toString());
        }
    }


}
