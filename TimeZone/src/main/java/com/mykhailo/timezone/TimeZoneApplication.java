package com.mykhailo.timezone;

import com.mykhailo.timezone.services.storage.StorageProperties;
import com.mykhailo.timezone.services.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(StorageProperties.class)
public class TimeZoneApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeZoneApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }
}
