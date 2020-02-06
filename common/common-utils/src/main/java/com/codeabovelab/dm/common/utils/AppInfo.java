

package com.codeabovelab.dm.common.utils;

import com.jcabi.manifests.Manifests;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class AppInfo {

    /**
     * extract '$artifactId' from manifest (Implementation-Title) or other places.
     *
     * @return
     */
    public static String getApplicationName() {
        return getValue("dm-cluman-info-name");
    }

    /**
     * extract '$version' from manifest (Implementation-Version) or other places.
     *
     * @return
     */
    public static String getApplicationVersion() {
        return getValue("dm-cluman-info-version");
    }

    public static String getBuildRevision() {
        return getValue("dm-cluman-info-buildRevision");
    }

    public static OffsetDateTime getBuildTime() {
        try {
            return OffsetDateTime.parse(getValue("dm-cluman-info-date"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            return OffsetDateTime.now();
        }
    }

    private static String getValue(String key) {
        try {
            // we expect error like IllegalArgumentException: Attribute 'dm-cluman-info-version' not found in MANIFEST.MF file(s) among 90 other attribute(s):
            // which appear anytime when we run app without jar file
            return Manifests.read(key);
        } catch (IllegalArgumentException e) {
            return "MANIFEST_WAS_NOT_FOUND";
        }
    }


}
