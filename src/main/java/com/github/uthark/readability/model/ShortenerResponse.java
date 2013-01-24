package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class ShortenerResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShortenerResponse.class);

    @JsonProperty("meta")
    private ShortenerMeta meta;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("messages")
    private List<String> messages;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public ShortenerMeta getMeta() {
        return meta;
    }

    public void setMeta(ShortenerMeta meta) {
        this.meta = meta;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
