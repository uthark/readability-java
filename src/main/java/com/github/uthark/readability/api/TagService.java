package com.github.uthark.readability.api;

import com.github.uthark.readability.model.Tag;
import com.github.uthark.readability.model.TagsResponse;

import java.io.IOException;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public interface TagService {

    TagsResponse getTags() throws IOException;

    Tag getTag(Long tagId) throws IOException;

    void deleteTag(Long tagId);
}
