package io.github.osrb2.e_commerceVipDiscount.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @PostMapping()
  public ResponseEntity<UserModel> registerUser(@RequestBody @Valid UserModel user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.register(user));
  }

  @GetMapping()
  public ResponseEntity<List<UserModel>> listAll() {
    return ResponseEntity.ok(service.listAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<UserModel>> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping("/email")
  public ResponseEntity<Optional<UserModel>> findByEmail(@RequestParam String email) {
    return ResponseEntity.ok(service.findUserByEmail(email));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody @Valid UserModel user) {
    user.setId(id);
    return ResponseEntity.ok(service.updateUserById(user));  
    
  }
}
