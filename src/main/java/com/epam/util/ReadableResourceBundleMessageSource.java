package com.epam.util;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

public class ReadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {
    public Properties getAllProperties(Locale locale) {
        clearCacheIncludingAncestors();
        PropertiesHolder propertiesHolder = getMergedProperties(locale);
        return propertiesHolder.getProperties();
    }
}
