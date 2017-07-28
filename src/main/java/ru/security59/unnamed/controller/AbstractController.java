package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.*;
import ru.security59.unnamed.service.AbstractEntityService;

import javax.ws.rs.core.Response;
import java.util.Set;

public class AbstractController<T> {

    private final AbstractEntityService<T> entityService;

    AbstractController(AbstractEntityService<T> entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public Set<T> getAll() {
        return entityService.getAll();
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public T add(@RequestBody T t) {
        entityService.add(t);
        return t;
    }

    @RequestMapping(method = RequestMethod.POST)
    public T update(@RequestBody T t) {
        return entityService.update(t);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable Integer id) {
        entityService.delete(id);
        return Response.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public Response handleAllException(Exception ex) {
        return Response.serverError().entity(ex).build();
    }

}
