package com.ejemplo1.ejemplo.contrllers;

import com.ejemplo1.ejemplo.models.User;
import com.ejemplo1.ejemplo.services.UserService;
import com.ejemplo1.ejemplo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTUtil jwtUtil;

    //Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.getAll();
    }

    //Trae un usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getIdUser(@PathVariable long id) {
        return  userService.getIdUser(id);
    }

    //Inserta un usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    void register(@RequestBody User user) {
        userService.register(user);
    }

    //Actualiza un usuario
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    User update(@RequestBody User user) {
        return userService.update(user);
    }

    //Elimina un usuario
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dto){
        User user = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if (user != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return  result;
    }
}
