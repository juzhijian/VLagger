package com.mcml.space.util;

import gnu.trove.strategy.HashingStrategy;

/**
 * @author md_5
 */
@SuppressWarnings("serial")
class CaseInsensitiveHashingStrategy implements HashingStrategy<String> {

    static final CaseInsensitiveHashingStrategy INSTANCE = new CaseInsensitiveHashingStrategy();

    @Override
    public int computeHashCode(final String string) {
        return string.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(final String s1, final String s2) {
        return s1 == s2 || s1.equalsIgnoreCase(s2);
    }
}
