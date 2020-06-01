package com.softserve.edu.greencity.rest.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParseTool {
    private static MessageParseTool instance = null;
    private Logger logger;

    private String tokenFindPattern = "token=(.*?)&";
    private String userIdFindPattern = "user_id=(\\d{1,4})";
    private String tokenReplacePattern = "[token=, &]";
    private String userIdReplacePattern = "user_id=";


    private MessageParseTool() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public static MessageParseTool get() {
        if(instance == null) {
            instance = new MessageParseTool();
        }
        return instance;
    }

    public String getTokenFromMessage(Message message) {
        return findByPatternFromMessage(message,tokenFindPattern, tokenReplacePattern);
    }


    public String getUserIdFromMessage(Message message) {
        return findByPatternFromMessage(message,userIdFindPattern, userIdReplacePattern);
    }

    public String findByPatternFromMessage(Message message, String findPattern, String replacePattern) {
        Pattern pattern = Pattern.compile(findPattern, Pattern.DOTALL);
        try {
            Matcher matcher = pattern.matcher(message.getContent().toString());
            if (matcher.find()) {
                return matcher.group().replaceAll(replacePattern,"");
            }
        } catch (IOException | MessagingException e) {
            logger.error(e.toString());
        }
        return "";
    }
}
