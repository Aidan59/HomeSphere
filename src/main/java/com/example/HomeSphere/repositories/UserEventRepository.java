package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {
    
}
