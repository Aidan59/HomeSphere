package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.Group;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<Group> findByUserId(int userId);

    Group findByName(String name);

    void deleteGroupByName(@NotEmpty String name);
}
