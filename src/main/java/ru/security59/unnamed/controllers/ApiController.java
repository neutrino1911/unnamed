package ru.security59.unnamed.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Vendor;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

@RestController
@PropertySource(value = {"classpath:config.properties"})
@RequestMapping(path = "/api", produces = "application/json;charset=UTF-8")
public class ApiController {

    private final EntityManager entityManager;

    private final Environment environment;

    @Autowired
    public ApiController(EntityManager entityManager, Environment environment) {
        this.entityManager = entityManager;
        this.environment = environment;
    }

    @RequestMapping(path = "/property", method = RequestMethod.POST)
    public Response getProperties() {
        Response r;
        try {
            r = Response.ok(environment.getProperty("export.path")).build();
        } catch (Exception e) {
            r = Response.serverError().build();
        }
        return r;
    }

    @Transactional
    @RequestMapping(path = "/vendor/new", method = RequestMethod.POST)
    public Response addVendor(@RequestBody Vendor vendor) {
        Response r;
        try {
            entityManager.persist(vendor);
            r = Response.ok(vendor).build();
        } catch (Exception e) {
            r = Response.ok(e).build();
        }
        return r;
    }

}
