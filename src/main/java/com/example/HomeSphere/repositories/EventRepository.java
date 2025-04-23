package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findTop10EventsByUser(User user);

    int countByUser(User user);

    Page<Event> findAllByOrderByTimeDesc(Pageable pageable);
}
