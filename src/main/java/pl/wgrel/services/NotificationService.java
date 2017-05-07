package pl.wgrel.services;

import java.util.List;

import pl.wgrel.services.NotificationServiceImpl.NotificationMessage;


public interface NotificationService {
	void addInfoMessage(String msg);
    void addErrorMessage(String msg);
    List<NotificationMessage> getNotificationMessages();
}
