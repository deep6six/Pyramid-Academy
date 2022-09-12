package com.jjkr.PetStoreFullStack.bucket;

public enum BucketName {
    PROFILE_IMAGE("pet-shop-uploads");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}

