package org.example.shared.service.impl;

import org.example.shared.domain.User;
import org.example.shared.service.UserExtractor;
import org.example.shared.service.UserRepository;
import org.example.shared.service.UserService;
import org.example.shared.service.validation.UserValidation;

public class UserServiceImpl implements UserService {
    private final UserValidation userValidation;
    private final UserRepository userRepository;
    private final UserExtractor userExtractor;

    public UserServiceImpl(UserValidation userValidation,
                           UserRepository userRepository,
                           UserExtractor userExtractor) {
        this.userValidation = userValidation;
        this.userRepository = userRepository;
        this.userExtractor = userExtractor;
    }

    @Override
    public void addUser(User input) {
        userValidation.validate(input);
        User user = userExtractor.getUser(input);
        userRepository.addUser(user);
    }

    @Override
    public void deleteUser(String birthNumber) {
        userValidation.validateBirthNumber(birthNumber);
        birthNumber = userExtractor.normalizeBirthNumber(birthNumber);
        userRepository.deleteUser(birthNumber);
    }

    @Override
    public User getUser(String birthNumber) {
        userValidation.validateBirthNumber(birthNumber);
        birthNumber = userExtractor.normalizeBirthNumber(birthNumber);
        return userRepository.getUser(birthNumber);
    }
}
