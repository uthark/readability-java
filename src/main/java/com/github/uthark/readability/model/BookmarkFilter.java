package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class BookmarkFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkFilter.class);

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("archive")
    private Boolean archive;

    @JsonProperty("archived_since")
    private Date archivedSince;

    @JsonProperty("archived_until")
    private Date archivedUntil;

    @JsonProperty("favorite")
    private Boolean favorite;

    @JsonProperty("favorited_since")
    private Date favoritedSince;

    @JsonProperty("favorited_until")
    private Date favoritedUntil;

    @JsonProperty("tags")
    private String[] tags;

    @JsonProperty("opened_since")
    private Date openedSince;

    @JsonProperty("opened_until")
    private Date openedUntil;

    @JsonProperty("added_since")
    private Date addedSince;

    @JsonProperty("added_until")
    private Date addedUntil;

    @JsonProperty("updated_since")
    private Date updatedSince;

    @JsonProperty("updated_until")
    private Date updatedUntil;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("user")
    private String user;

    @JsonProperty("only_deleted")
    private Boolean onlyDeleted;

    @JsonProperty("order")
    // TODO: Convert to enum?
    private String order;

    @JsonProperty("exclude_accessibility")
    @Deprecated
    private String excludeAccessibility;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public Date getOpenedSince() {
        return openedSince;
    }

    public void setOpenedSince(Date openedSince) {
        this.openedSince = openedSince;
    }

    public Date getAddedUntil() {
        return addedUntil;
    }

    public void setAddedUntil(Date addedUntil) {
        this.addedUntil = addedUntil;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getUpdatedUntil() {
        return updatedUntil;
    }

    public void setUpdatedUntil(Date updatedUntil) {
        this.updatedUntil = updatedUntil;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Date getArchivedUntil() {
        return archivedUntil;
    }

    public void setArchivedUntil(Date archivedUntil) {
        this.archivedUntil = archivedUntil;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Date getFavoritedSince() {
        return favoritedSince;
    }

    public void setFavoritedSince(Date favoritedSince) {
        this.favoritedSince = favoritedSince;
    }

    public Date getFavoritedUntil() {
        return favoritedUntil;
    }

    public void setFavoritedUntil(Date favoritedUntil) {
        this.favoritedUntil = favoritedUntil;
    }

    public Date getOpenedUntil() {
        return openedUntil;
    }

    public void setOpenedUntil(Date openedUntil) {
        this.openedUntil = openedUntil;
    }

    public Date getArchivedSince() {
        return archivedSince;
    }

    public void setArchivedSince(Date archivedSince) {
        this.archivedSince = archivedSince;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getAddedSince() {
        return addedSince;
    }

    public void setAddedSince(Date addedSince) {
        this.addedSince = addedSince;
    }

    public Boolean getOnlyDeleted() {
        return onlyDeleted;
    }

    public void setOnlyDeleted(Boolean onlyDeleted) {
        this.onlyDeleted = onlyDeleted;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Date getUpdatedSince() {
        return updatedSince;
    }

    public void setUpdatedSince(Date updatedSince) {
        this.updatedSince = updatedSince;
    }

}
