package com.genspark.awsp1.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore
{
    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3) { this.s3 = s3; }

    public void save(String path, String filename, Optional<Map<String, String>> optionalMetadata, InputStream inputStream)
    {
        ObjectMetadata objectMetadata = new ObjectMetadata();

        optionalMetadata.ifPresent(map -> {
            if (!map.isEmpty()) { map.forEach(objectMetadata::addUserMetadata); }
        });

        try {
            s3.putObject(path, filename, inputStream, objectMetadata);
        } catch (AmazonServiceException e) { throw new IllegalStateException(e.toString(), e); }
    }
}
