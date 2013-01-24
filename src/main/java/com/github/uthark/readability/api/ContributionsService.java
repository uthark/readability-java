package com.github.uthark.readability.api;

import com.github.uthark.readability.model.ContributionsFilter;
import com.github.uthark.readability.model.ContributionsResponse;

import java.io.IOException;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public interface ContributionsService {

    ContributionsResponse getContributions(ContributionsFilter contributionsFilter) throws IOException;
}
