

package com.codeabovelab.dm.cluman.cluster.registry.aws;

import com.amazonaws.auth.AWSCredentials;
import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

/**
 * We need immutable object which can be used as map key
 */
@EqualsAndHashCode
class AwsCredentials implements AWSCredentials {
    private final String secretKey;
    private final String accessKey;
    private final String region;

    public AwsCredentials(String secretKey, String accessKey, String region) {
        Assert.hasText(secretKey, "secretKey is null or empty");
        Assert.hasText(accessKey, "accessKey is null or empty");
        Assert.hasText(region, "region is null or empty");
        this.secretKey = secretKey;
        this.accessKey = accessKey;
        this.region = region;
    }

    @Override
    public String getAWSAccessKeyId() {
        return accessKey;
    }

    @Override
    public String getAWSSecretKey() {
        return secretKey;
    }

    public String getRegion() {
        return region;
    }
}
