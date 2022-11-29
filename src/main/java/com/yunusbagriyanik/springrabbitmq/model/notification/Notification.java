package com.yunusbagriyanik.springrabbitmq.model.notification;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private String notificationId;
    private Date createdDate;
    private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdDate=" + createdDate +
                ", message='" + message + '\'' +
                '}';
    }
}