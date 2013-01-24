package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class TagsResponse implements Iterable<Tag> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagsResponse.class);

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public Iterator<Tag> iterator() {
        if (tags == null || tags.isEmpty()) {
            return Collections.emptyIterator();
        }
        return tags.iterator();

    }
}
