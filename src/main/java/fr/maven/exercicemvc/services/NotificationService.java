package fr.maven.exercicemvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements INotificationService{

    public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

    @Autowired
    private HttpSession session;

    private void addNotificationMessage(NotificationMessageType type, String msg) {
       List<NotificationMessage> notifyMessages = (List<NotificationMessage>) session.getAttribute(NOTIFY_MSG_SESSION_KEY);
       if(notifyMessages == null) {
           notifyMessages = new ArrayList<>();
       }
        notifyMessages.add(new NotificationMessage(type, msg));
        session.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);

    }

    @Override
    public void addInfoMessage(String msg) {
        addNotificationMessage(NotificationMessageType.INFO, msg);
    }

    @Override
    public void addErrorMessage(String msg) {
        addNotificationMessage(NotificationMessageType.ERROR, msg);

    }

    public enum NotificationMessageType {
        INFO,
        ERROR
    }

    public class NotificationMessage {
        NotificationMessageType type;
        String text;

        public NotificationMessage(NotificationMessageType type, String text) {
            this.type = type;
            this.text = text;
        }

        public NotificationMessageType getType() {
            return type;
        }

        public String getText() {
            return text;
        }
    }
}
