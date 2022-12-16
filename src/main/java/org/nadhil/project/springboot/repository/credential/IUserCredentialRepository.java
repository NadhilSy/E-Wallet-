package org.nadhil.project.springboot.repository.credential;

import org.nadhil.project.springboot.model.credential.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserCredentialRepository extends JpaRepository<UserCredential, String> {

    Optional<UserCredential> findByUsername(String username);
    Optional<UserCredential> findByPassword(String password);
}
