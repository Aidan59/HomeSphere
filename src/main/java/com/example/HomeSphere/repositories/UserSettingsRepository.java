package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserSettingsRepository extends JpaRepository<UserSettings, Integer> {
    public UserSettings findUserSettingsById(int id);
}
