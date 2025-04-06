package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT e FROM events e WHERE e.user_id = :userId ORDER BY e.time DESC LIMIT 10")
    List<Event> findTopEvents(@Param("userId") User userId);
}
