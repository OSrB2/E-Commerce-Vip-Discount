package io.github.osrb2.e_commerceVipDiscount.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.github.osrb2.e_commerceVipDiscount.model.dtos.UserResponseDto;
import io.github.osrb2.e_commerceVipDiscount.model.mappers.UserMapper;
import org.apache.catalina.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.repository.UserRepository;
import io.github.osrb2.e_commerceVipDiscount.service.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;
  private final ApplicationEventPublisher eventPublisher;
  private final UserMapper userMapper;

  public UserModel register(UserModel user) {
    UserModel saved = repository.save(user);
    eventPublisher.publishEvent(new UserCreatedEvent(saved));
    return saved;
  }

  public List<UserResponseDto> listAllUsers() {
    List<UserModel> users = repository.findAll();

    if (users.isEmpty()) {
      throw new RuntimeException("Users not found!");
    }

    List<UserResponseDto> userDto = new ArrayList<>();

    for (UserModel user : users) {
        userDto.add(userMapper.toResponseDto(user));
    }
    return userDto;
  }

  public Optional<UserModel> findById(Long id) {
    return repository.findById(id);
  }

  public Optional<UserModel> findUserByEmail(String email) {
    return repository.findByEmail(email);
  }

  @Transactional
  public UserModel updateUserById(UserModel user) {
    UserModel userToUpdate = repository.findById(user.getId())
      .orElseThrow(() -> new RuntimeException("User not found!"));

    if (userToUpdate.getEmail().equals(user.getEmail())) {
      throw new RuntimeException("This email already exists!");
    } else {
      Optional.ofNullable(user.getEmail()).ifPresent(userToUpdate::setEmail);
    }

    Optional.ofNullable(user.getPhone()).ifPresent(userToUpdate::setPhone);
    Optional.ofNullable(user.getName()).ifPresent(userToUpdate::setName);
    
    return repository.save(userToUpdate);
  }

  public void deleteUserById(Long id) {
    repository.deleteById(id);
  }
}
