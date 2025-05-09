package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.*;
import com.example.HomeSphere.services.DeviceService;
import com.example.HomeSphere.services.EventService;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class NavigationController {

    @Autowired
    private UserService userService;
    private DeviceService deviceService;
    private EventService eventService;
    private UserDetailsService userDetailsService;

    public NavigationController(UserService userService, DeviceService deviceService, EventService eventService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.eventService = eventService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/homePage/home")
    public String home(@ModelAttribute("device") Device device, Model model) {

        model.addAttribute("events", eventService.getTopEvents());
        model.addAttribute("deviceList", userDetailsService.getCurrentUser().getDeviceList());
        model.addAttribute("groupList", userDetailsService.getCurrentUser().getGroupList());

        return "/homePage/home";
    }

    @RequestMapping(value = "/homePage/devices", method = {RequestMethod.GET, RequestMethod.POST})
    public String devices(@RequestParam(value = "groupName", required = false) String groupName,
                          @RequestParam(value = "deleteGroup", required = false) String deleteGroup,
                          Model model) {

        List<Group> groupList = new ArrayList<>();
        if (groupName == null || groupName.equals("All")) {
            groupList.add(new Group(-1, null, "All"));
            groupList.addAll(userDetailsService.getCurrentUser().getGroupList());

            model.addAttribute("deviceList", userDetailsService.getCurrentUser().getDeviceList());
        } else {
            groupList.addAll(userDetailsService.getCurrentUser().getGroupList());
            groupList.add(new Group(-1, null, "All"));

            model.addAttribute("deviceList", deviceService.getAllUserDevicesByGroup(groupName));
        }

        System.out.println(deleteGroup);
        if (deleteGroup != null) {
            deviceService.deleteGroupByName(deleteGroup);
        }

        Group newGroup = new Group();
        Group currentGroup = new Group();
        currentGroup.setName(groupName);

        model.addAttribute("groupList", groupList);
        model.addAttribute("newGroup", newGroup);
        model.addAttribute("currentGroup", currentGroup);
        model.addAttribute("device", new Device());


        return "/homePage/devices";
    }

    @RequestMapping(value = "/homePage/events", method = {RequestMethod.GET, RequestMethod.POST})
    public String events(@RequestParam(defaultValue = "1") int page,
                         Model model) {

        int pageSize = 10;

        model.addAttribute("events", eventService.getEventsPage(page));
        model.addAttribute("pageCount", eventService.getCountOfPages() + 1);
        model.addAttribute("page", page);

        return "/homePage/events";
    }

    @GetMapping("/homePage/settings")
    public String settings(@ModelAttribute("settings") UserSettings settings, Model model) {

        model.addAttribute("settings", userService.getUserSettings());

        return "/homePage/settings";
    }

    @GetMapping("/homePage/help")
    public String help() {

        return "/homePage/help";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        model.addAttribute("user", userDetailsService.getCurrentUser());

        return "/homePage/profile";
    }



}
