package com.example.spring_security.init;

import com.example.spring_security.entity.Role;
import com.example.spring_security.entity.User;
import com.example.spring_security.service.RoleServiceImpl;
import com.example.spring_security.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {
    private final UserService userService;
    private final RoleServiceImpl roleService;

    public DBInit(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Set<Role> adminRole = new HashSet<>();
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");

        adminRole.add(roleAdmin);
        adminRole.add(roleUser);

        Set<Role> userRole = new HashSet<>();
        userRole.add(roleUser);
        userRole.add(roleAdmin);

        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);

        User admin = new User("Ivan", "Ivanov", 27, "admin@cata.ru", "admin", adminRole);
        User user = new User("Fedor", "Korovin", 25, "user@cata.ru", "user", userRole);
        User user1 = new User("Elena", "Ershova", 22, "user1@cata.ru", "user1", userRole);

        userService.update(admin);
        userService.add(user);
        userService.add(user1);
    }
}