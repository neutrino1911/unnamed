package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.*;
import ru.security59.unnamed.service.AbstractEntityService;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

public abstract class AbstractEntityController<T> {

    private final AbstractEntityService<T> entityService;

    AbstractEntityController(AbstractEntityService<T> entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable Long id) {
        return entityService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<T> getAll() {
        return entityService.getAll();
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public List<T> getList(@RequestBody Map<Object, Object> params) {
        return entityService.getList(params);
    }

    @RequestMapping(method = RequestMethod.POST)
    public T add(@RequestBody T t) {
        entityService.add(t);
        return t;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public T update(@RequestBody T t) {
        return entityService.update(t);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        entityService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public Response handleAllException(Exception ex) {
        return Response.serverError().entity(ex).build();
    }

}
