package com.example.HomeSphere.repositories;

import com.example.HomeSphere.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    Optional<Device> findDeviceById(int id);

    Optional<List<Device>> findDeviceByGroupId(int groupId);

    void deleteDeviceById(int id);
}
