package com.bakh.practice.springbootstrapdemo;

import com.bakh.practice.springbootstrapdemo.model.Role;
import com.bakh.practice.springbootstrapdemo.model.User;
import com.bakh.practice.springbootstrapdemo.repository.RoleRepository;
import com.bakh.practice.springbootstrapdemo.repository.UserRepository;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@SpringBootApplication
public class SpringBootstrapDemoApplication implements CommandLineRunner {

    final UserRepository userRepository;
    final RoleRepository roleRepository;


    public SpringBootstrapDemoApplication(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootstrapDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Set<Role> roles1 = new HashSet<>();
        Set<Role> roles2 = new HashSet<>();
        Role role1 = new Role(1L, "ROLE_ADMIN");
        Role role2 = new Role(2L, "ROLE_USER");

        roles1.add(role1);
        roles1.add(role2);
        roles2.add(role2);
        User admin = new User("Bakhmai", "Begaev", (byte) 49,
                "admin@mail.ru","$2a$12$pqvSkCFbx61Gr..bzs2eNuVr/eoO9biv/KkgsQ51T0DTt.baMkCpq", roles1);
        User user = new User("Иван", "Пшыченко", (byte) 33, "user@mail.ru",
                "$2a$12$SXxF.BgRpKyaLgWEoP8Qe.GPaaAzVT21DsdhvXAhq3u5OQV7dJjre",
                roles2);
        if (userRepository.findAll().isEmpty()) {
            roleRepository.save(role1);
            roleRepository.save(role2);
            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}
