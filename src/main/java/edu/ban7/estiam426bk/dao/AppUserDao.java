package edu.ban7.estiam426bk.dao;

import edu.ban7.estiam426bk.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDao extends JpaRepository<AppUser, Integer> {

}
