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
public class Bookmark {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bookmark.class);

    @JsonProperty("article")
    private Article article;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("read_percent")
    private Double readPercent;

    @JsonProperty("tags")
    private String[] tags;

    @JsonProperty("date_updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateUpdated;

    @JsonProperty("favorite")
    private Boolean favorite;

    @JsonProperty("archive")
    private Boolean archive;

    @JsonProperty("date_favorited")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateFavorited;

    @JsonProperty("date_added")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateAdded;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("date_archived")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateArchived;

    @JsonProperty("date_opened")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date dateOpened;

    @JsonProperty("article_href")
    private String articleHref;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }
}
