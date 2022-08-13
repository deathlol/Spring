package com.ejemplo1.ejemplo.contrllers;

import com.ejemplo1.ejemplo.models.Permiso;
import com.ejemplo1.ejemplo.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    //Trae todos los permiso
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll() {
        return permisoService.getAll();
    }

    //Trae un permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso getIdPermiso(@PathVariable long id) {
        return  permisoService.getIdPermiso(id);
    }

    //Inserta un permiso
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso) {
        return permisoService.register(permiso);
    }

    //Actualiza un permiso
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Permiso update(@RequestBody Permiso permiso) {
        return permisoService.update(permiso);
    }

    //Elimina un permiso
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        permisoService.delete(id);
    }

}
