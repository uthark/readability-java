package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class User {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    @JsonProperty("username")
    private String username;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("has_active_subscription")
    private Boolean hasActiveSubscription;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("is_publisher")
    private Boolean isPublisher;

    @JsonProperty("email_into_address")
    private String emailIntoAddress;

    @JsonProperty("kindle_email_address")
    private String kindleEmailAddress;

    @JsonProperty("date_joined")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateJoined;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getHasActiveSubscription() {
        return hasActiveSubscription;
    }

    public void setHasActiveSubscription(Boolean hasActiveSubscription) {
        this.hasActiveSubscription = hasActiveSubscription;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getPublisher() {
        return isPublisher;
    }

    public void setPublisher(Boolean publisher) {
        isPublisher = publisher;
    }

    public String getEmailIntoAddress() {
        return emailIntoAddress;
    }

    public void setEmailIntoAddress(String emailIntoAddress) {
        this.emailIntoAddress = emailIntoAddress;
    }

    public String getKindleEmailAddress() {
        return kindleEmailAddress;
    }

    public void setKindleEmailAddress(String kindleEmailAddress) {
        this.kindleEmailAddress = kindleEmailAddress;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
}
