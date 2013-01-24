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
public class ContributionsResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContributionsResponse.class);

    @JsonProperty("conditions")
    private ContributionsFilter filter;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("contributions")
    private List<Contribution> contributions;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    public ContributionsFilter getFilter() {
        return filter;
    }

    public void setFilter(ContributionsFilter filter) {
        this.filter = filter;
    }
}
