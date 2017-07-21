package com.mcml.space.util;

import gnu.trove.map.hash.TCustomHashMap;
import java.util.Map;

/**
 * @author md_5
 */
public class CaseInsensitiveMap<V> extends TCustomHashMap<String, V> {

    public CaseInsensitiveMap() {
        super(CaseInsensitiveHashingStrategy.INSTANCE);
    }

    public CaseInsensitiveMap(final Map<? extends String, ? extends V> map) {
        super(CaseInsensitiveHashingStrategy.INSTANCE, map);
    }
}
