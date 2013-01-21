package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class Article {

    private static final Logger LOGGER = LoggerFactory.getLogger(Article.class);

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("lead_image_url")
    private String leadImageUrl;

    @JsonProperty("author")
    private String author;

    @JsonProperty("excerpt")
    private String excerpt;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("word_count")
    private Integer wordCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonProperty("date_published")
    private Date datePublished;

    @JsonProperty("id")
    private String id;

    @JsonProperty("dek")
    private String dek;

    @JsonProperty("processed")
    private Boolean processed;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

}
