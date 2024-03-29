package com.genspark.awsp1.datastore;

import com.genspark.awsp1.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore
{
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "user1", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "user2", null));
    }

    public List<UserProfile> getUserProfiles() { return USER_PROFILES; }
}
