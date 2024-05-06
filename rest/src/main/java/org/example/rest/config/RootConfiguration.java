package org.example.rest.config;

import org.example.shared.service.UserExtractor;
import org.example.shared.service.UserRepository;
import org.example.shared.service.UserService;
import org.example.shared.service.impl.UserExtractorImpl;
import org.example.shared.service.impl.UserRepositoryMockImpl;
import org.example.shared.service.impl.UserServiceImpl;
import org.example.shared.service.validation.UserValidation;
import org.example.shared.service.validation.UserValidationImpl;
import org.example.shared.service.validation.rules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class RootConfiguration {

    @Bean
    public UserService userService(UserValidation validation, UserRepository repository, UserExtractor extractor) {
        return new UserServiceImpl(
                validation,
                repository,
                extractor
        );
    }

    @Bean
    public UserValidation userValidation(Set<ValidationRule> rules, BirthNumberValidationRule birthNumberValidationRule) {
        return new UserValidationImpl(rules, birthNumberValidationRule);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryMockImpl();
    }

    @Bean
    public UserExtractor userExtractor() {
        return new UserExtractorImpl();
    }

    @Bean
    public BirthNumberValidationRule birthNumberValidationRule() {
        return new BirthNumberValidationRule();
    }

    @Bean
    public ValidationRule userBirthNumberValidationRule(BirthNumberValidationRule rule) {
        return new UserBirthNumberValidationRule(rule);
    }

    @Bean
    public ValidationRule userNameValidationRule() {
        return new UserNameValidationRule();
    }

    @Bean
    public ValidationRule userSurnameValidationRule() {
        return new UserSurnameValidationRule();
    }
}
