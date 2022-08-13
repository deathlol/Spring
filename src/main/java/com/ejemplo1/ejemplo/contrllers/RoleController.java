package com.ejemplo1.ejemplo.contrllers;

import com.ejemplo1.ejemplo.models.Role;
import com.ejemplo1.ejemplo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService rolService;

    //Trae todos los roles
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll() {
        return rolService.getAll();
    }

    //Trae un role
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role getIdRole(@PathVariable long id) {
        return  rolService.getIdRole(id);
    }

    //Inserta un role
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role register(@RequestBody Role role) {
        return rolService.register(role);
    }

    //Actualiza un role
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Role update(@RequestBody Role role) {
        return rolService.update(role);
    }

    //Elimina un role
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        rolService.delete(id);
    }
}
