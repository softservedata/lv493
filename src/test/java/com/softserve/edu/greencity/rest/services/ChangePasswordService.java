package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.resources.changepassword.ChangePasswordResource;
import com.softserve.edu.greencity.rest.resources.changepassword.RestorePasswordResource;
import com.softserve.edu.greencity.rest.tools.EmailTools;
import com.softserve.edu.greencity.rest.tools.MessageParseTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;

public class ChangePasswordService {

    private String  mailSender = "mailgreencity1@gmail.com";
    private String mailSubject = "Confirm restoring password";

    private ChangePasswordResource changePasswordResource;
    private RestorePasswordResource restorePasswordResource;
    private EmailTools emailTool;


    private User mailUser;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChangePasswordService(User user) {
        this.changePasswordResource = new ChangePasswordResource();
        this.restorePasswordResource = new RestorePasswordResource();
        this.setMailUser(user);
    }

    public void setMailUser(User mailUser) {
        this.mailUser = mailUser;
        emailTool = new EmailTools(mailUser);
    }

    public ChangePasswordService() {
        this.changePasswordResource = new ChangePasswordResource();
        this.restorePasswordResource = new RestorePasswordResource();
    }



    public ResponseCodeEntity restorePassword(String email) {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, email);  // fixme .replace("@", "%40")

        return restorePasswordResource
                .httpGetAsEntity(methodParameters
                        .addUrlParameters(urlParameters));
    }

    public ResponseCodeEntity restorePassword() {
        return restorePassword(mailUser.getEmail());
    }

    public String getTokenForChangingPassword() {
        Message messageWithToken = emailTool.waitForMessage(mailSender, mailSubject);
        emailTool.markAsRead(messageWithToken);
        return MessageParseTool.get().getTokenFromMessage(messageWithToken);
    }

    public ResponseCodeEntity changePassword(String token, String newPassword) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.CONFIRM_PASSWORD, newPassword)
                .addParameter(KeyParameters.PASSWORD, newPassword)
                .addParameter(KeyParameters.TOKEN, token);
//        RestParameters headerParameters = new RestParameters()
//                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());


        return changePasswordResource.httpPostAsEntity(methodParameters
                .addMediaTypeParameters(mediaTypeParameters));
    }
}
