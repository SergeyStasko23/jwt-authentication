package ru.stacy.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stacy.dto.AdminUserDTO;
import ru.stacy.model.User;
import ru.stacy.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
    private final UserService userService;

    // Header: key - "Authorization", value - "Bearer_token"
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<AdminUserDTO> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDTO result = AdminUserDTO.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
