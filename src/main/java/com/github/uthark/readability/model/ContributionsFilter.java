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
public class ContributionsFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContributionsFilter.class);

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("since")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date since;

    @JsonProperty("until")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date until;

    @JsonProperty("user")
    private String user;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("page")
    private Integer page;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
