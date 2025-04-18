package com.example.HomeSphere.services;

import com.example.HomeSphere.models.Device;
import com.example.HomeSphere.models.Group;
import com.example.HomeSphere.repositories.DeviceRepository;
import com.example.HomeSphere.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private UserDetailsService userDetailsService;
    private DeviceRepository deviceRepository;
    private GroupRepository groupRepository;
    private UserService userService;

    public DeviceService(UserDetailsService userDetailsService, DeviceRepository deviceRepository, GroupRepository groupRepository, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.deviceRepository = deviceRepository;
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    public void save(Device device) {
        deviceRepository.save(device);
    }

    public List<Device> getAllUserDevicesByGroup(String group) {

        return deviceRepository.findDeviceByGroupId(groupRepository.findByName(group).getId()).get();

    }

    public void save(Group group) {
        groupRepository.save(group);
    }
}
