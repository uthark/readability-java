package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class Tag {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tag.class);

    @JsonProperty("text")
    private String text;

    @JsonProperty("applied_count")
    private Long appliedCount;

    @JsonProperty("id")
    private Long id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getAppliedCount() {
        return appliedCount;
    }

    public void setAppliedCount(Long appliedCount) {
        this.appliedCount = appliedCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

}
