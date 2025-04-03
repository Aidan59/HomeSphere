package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.DeviceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceEventRepository extends JpaRepository<DeviceEvent, Integer> {

}
