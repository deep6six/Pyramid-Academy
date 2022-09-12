package com.genspark.awsp1.bucket;

public enum BucketName
{
    PROFILE_IMAGE("awsp1-bucket");
    private final String bucketName;

    BucketName(String bucketName) { this.bucketName = bucketName; }

    public String getBucketName() { return bucketName; }
}
