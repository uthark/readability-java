package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class Meta {

    private static final Logger LOGGER = LoggerFactory.getLogger(Meta.class);

    @JsonProperty("num_pages")
    private Integer numPages;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("item_count_total")
    private Integer itemCountTotal;

    @JsonProperty("item_count")
    private Integer itemCount;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getItemCountTotal() {
        return itemCountTotal;
    }

    public void setItemCountTotal(Integer itemCountTotal) {
        this.itemCountTotal = itemCountTotal;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}
