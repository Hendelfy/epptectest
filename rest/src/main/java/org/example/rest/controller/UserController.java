package org.example.rest.controller;

import org.example.rest.dto.CreateUserRequestDto;
import org.example.rest.dto.GetUserResponseDto;
import org.example.shared.domain.User;
import org.example.shared.service.UserExtractor;
import org.example.shared.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    private final UserExtractor extractor;

    public UserController(UserService userService, UserExtractor extractor) {
        this.userService = userService;
        this.extractor = extractor;
    }

    @GetMapping("{birthNumber}")
    public GetUserResponseDto getUser(@PathVariable String birthNumber) {
        User user = userService.getUser(birthNumber);
        return new GetUserResponseDto(user.getName(), user.getSurname(), user.getBirthNumber(), extractor.getUserAge(user));
    }

    @DeleteMapping("{birthNumber}")
    public void deleteUser(@PathVariable String birthNumber) {
        userService.deleteUser(birthNumber);
    }


    @PostMapping
    public void createUser(@RequestBody CreateUserRequestDto body) {
        userService.addUser(new User(body.getName(), body.getSurname(), body.getBirthNumber()));
    }

}
