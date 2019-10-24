package ru.stacy.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stacy.dto.UserDTO;
import ru.stacy.dto.mapper.UserMapper;
import ru.stacy.model.User;
import ru.stacy.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDTO result = userMapper.toDTO(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
