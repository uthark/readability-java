package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class Contribution {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkFilter.class);

    @JsonProperty("contribution")
    private Double contribution;

    @JsonProperty("user")
    private String user;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("num_bookmarks")
    private Integer numBookmarks;

    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date date;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    /**
     *  "date": "2010-09-01",
     "contribution": "1.33",
     "user": "jdoe",
     "domain": "www.nytimes.com",
     "num_bookmarks": 1
     */
}
