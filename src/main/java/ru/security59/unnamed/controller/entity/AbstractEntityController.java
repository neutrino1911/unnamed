package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.*;
import ru.security59.unnamed.service.AbstractEntityService;

import javax.ws.rs.core.Response;
import java.util.List;

public abstract class AbstractEntityController<T> {

    private final AbstractEntityService<T> entityService;

    AbstractEntityController(AbstractEntityService<T> entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<T> getAll() {
        return entityService.getAll();
    }

    @RequestMapping(path = "/list/{page}/{count}", method = RequestMethod.GET)
    public List<T> getList(
            @PathVariable Integer page,
            @PathVariable Integer count) {
        return entityService.getList(page, count);
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
    public void delete(@PathVariable Integer id) {
        entityService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public Response handleAllException(Exception ex) {
        return Response.serverError().entity(ex).build();
    }

}
