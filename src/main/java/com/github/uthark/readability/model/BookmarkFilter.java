package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class BookmarkFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkFilter.class);

    @JsonProperty("opened_since")
    private String openedSince;

    @JsonProperty("added_until")
    private String addedUntil;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("updated_until")
    private String updatedUntil;

    @JsonProperty("tags")
    private String[] tags;

    @JsonProperty("archive")
    private Boolean archive;

    @JsonProperty("archived_until")
    private String archivedUntil;

    @JsonProperty("favorite")
    private Boolean favorite;

    @JsonProperty("favorited_since")
    private String favoritedSince;

    @JsonProperty("favorited_until")
    private String favoritedUntil;

    @JsonProperty("opened_until")
    private String openedUntil;

    @JsonProperty("archived_since")
    private String archivedSince;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("user")
    private String user;

    @JsonProperty("added_since")
    private String addedSince;

    @JsonProperty("only_deleted")
    private Boolean onlyDeleted;

    @JsonProperty("order")
    private String order;

    @JsonProperty("exclude_accessibility")
    private String excludeAccessibility;

    @JsonProperty("updated_since")
    private String updatedSince;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public String getOpenedSince() {
        return openedSince;
    }

    public void setOpenedSince(String openedSince) {
        this.openedSince = openedSince;
    }

    public String getAddedUntil() {
        return addedUntil;
    }

    public void setAddedUntil(String addedUntil) {
        this.addedUntil = addedUntil;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUpdatedUntil() {
        return updatedUntil;
    }

    public void setUpdatedUntil(String updatedUntil) {
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

    public String getArchivedUntil() {
        return archivedUntil;
    }

    public void setArchivedUntil(String archivedUntil) {
        this.archivedUntil = archivedUntil;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getFavoritedSince() {
        return favoritedSince;
    }

    public void setFavoritedSince(String favoritedSince) {
        this.favoritedSince = favoritedSince;
    }

    public String getFavoritedUntil() {
        return favoritedUntil;
    }

    public void setFavoritedUntil(String favoritedUntil) {
        this.favoritedUntil = favoritedUntil;
    }

    public String getOpenedUntil() {
        return openedUntil;
    }

    public void setOpenedUntil(String openedUntil) {
        this.openedUntil = openedUntil;
    }

    public String getArchivedSince() {
        return archivedSince;
    }

    public void setArchivedSince(String archivedSince) {
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

    public String getAddedSince() {
        return addedSince;
    }

    public void setAddedSince(String addedSince) {
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

    public String getExcludeAccessibility() {
        return excludeAccessibility;
    }

    public void setExcludeAccessibility(String excludeAccessibility) {
        this.excludeAccessibility = excludeAccessibility;
    }

    public String getUpdatedSince() {
        return updatedSince;
    }

    public void setUpdatedSince(String updatedSince) {
        this.updatedSince = updatedSince;
    }

}
