package ru.denfad.demo.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import ru.denfad.demo.dao.userDao;
import ru.denfad.demo.models.Post;
import ru.denfad.demo.models.Sight;
import ru.denfad.demo.models.User;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserController {

    private final userDao userDao;

    @PutMapping(path="/{id}",consumes = "application/json")
    public void addPost(@PathVariable(name="id") int id, @RequestBody Post p){
        User user = userDao.findById(id);
        user.addPost(p);
        userDao.update(user);
    }



    @PutMapping(path="/", consumes="application/json")
    public void updateUser(@RequestBody User u){
        userDao.update(u);
    }

    @DeleteMapping(path="/",consumes = "application/json")
    public void deleteUser(@RequestBody User u){
        userDao.delete(u);
    }


    @GetMapping(path="/{id}", produces="application/json" )
    public User getUser(@PathVariable(name="id") int id){
        return userDao.findById(id);
    }

    @PostMapping(path="/signup", consumes = "application/json", produces="application/json")
    public Boolean addUser(@RequestBody User u){
        if(userDao.checkUser(u)){
            //пользователь с таким именем уже есть
            return true;
        }
        //пользователь с таким именем ещн нет
        else{
            userDao.save(u);
            return  false;
        }

    }

}
