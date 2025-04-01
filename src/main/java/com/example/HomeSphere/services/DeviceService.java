package com.example.HomeSphere.services;

import com.example.HomeSphere.models.Device;
import com.example.HomeSphere.models.DeviceEvent;
import com.example.HomeSphere.models.UserEvent;
import com.example.HomeSphere.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<DeviceEvent> getDeviceEvents(){
        //TODO

        return null;
    }

    public void save(Device device) {
        deviceRepository.save(device);
    }
}
