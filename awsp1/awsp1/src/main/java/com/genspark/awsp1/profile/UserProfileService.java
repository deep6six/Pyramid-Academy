package com.genspark.awsp1.profile;

import com.amazonaws.services.s3.model.Bucket;
import com.genspark.awsp1.bucket.BucketName;
import com.genspark.awsp1.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserProfileService
{
    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }

    List<UserProfile> getUserProfiles() { return userProfileDataAccessService.getUserProfiles(); }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file)
    {
        isFileEmpty(file);
        isImage(file);

        UserProfile user = getUserProfile(userProfileId);

        Map<String, String> metadata = extractMetadata(file);

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
        String filename = String.format("%s-%s", file.getName(), UUID.randomUUID());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) { throw new IllegalStateException(e); }

    }

    private static Map<String, String> extractMetadata(MultipartFile file) {
        Map<String,String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfile getUserProfile(UUID userProfileId) {
        return userProfileDataAccessService.getUserProfiles().stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("User not found", userProfileId)));
    }

    private static void isImage(MultipartFile file) {
        if (Arrays.asList(ContentType.IMAGE_JPEG, ContentType.IMAGE_PNG, ContentType.IMAGE_GIF)
                .contains(file.getContentType())) { throw new IllegalStateException("file must be an image"); }
    }

    private static void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) { throw new IllegalStateException("empty file"); }
    }
}
