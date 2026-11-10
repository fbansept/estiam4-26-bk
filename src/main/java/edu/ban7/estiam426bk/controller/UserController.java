package edu.ban7.estiam426bk.controller;

import edu.ban7.estiam426bk.dao.AppUserDao;
import edu.ban7.estiam426bk.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    protected final AppUserDao appUserDao;

    @GetMapping("/all")
    public List<AppUser> all() {

        return appUserDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> read(@PathVariable int id) {

        Optional<AppUser> appUserDb =  appUserDao.findById(id);

        if(appUserDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(appUserDb.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppUser> create(@RequestBody AppUser newUser) {

        appUserDao.save(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> update(
            @PathVariable int id,
            @RequestBody AppUser alteredUser) {

        Optional<AppUser> appUserDb =  appUserDao.findById(id);

        if(appUserDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        alteredUser.setId(id);
        appUserDao.save(alteredUser);

        return new ResponseEntity<>(alteredUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<AppUser> appUserDb =  appUserDao.findById(id);

        if(appUserDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        appUserDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
