package io.github.osrb2.e_commerceVipDiscount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public UserModel register(UserModel user) {
    return repository.save(user);
  }

  public List<UserModel> listAllUsers() {
    List<UserModel> users = repository.findAll();
    return users;
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

    if (userToUpdate.getEmail() == user.getEmail()) {
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
