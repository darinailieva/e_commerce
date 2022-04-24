package com.brainstars.ecommerce.services.impls;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Implementation of auditor for getting date of creation or modification.
 */

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Current Auditor");
    }
}

