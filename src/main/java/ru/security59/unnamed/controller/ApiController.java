package ru.security59.unnamed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.VendorService;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path = "/api")
public class ApiController {

    @Autowired
    private VendorService vendorService;

    @RequestMapping(path = "/vendor/{id}", method = RequestMethod.GET)
    public Vendor getVendorById(@PathVariable Integer id) {
        return vendorService.getVendorById(id);
    }

    @RequestMapping(path = "/vendor/new", method = RequestMethod.POST)
    public Vendor addVendor(@RequestBody Vendor vendor) {
        vendorService.addVendor(vendor);
        return vendor;
    }

    @RequestMapping(path = "/vendor", method = RequestMethod.POST)
    public Vendor updateVendor(@RequestBody Vendor vendor) {
        return vendorService.updateVendor(vendor);
    }

    @RequestMapping(path = "/vendor/{id}", method = RequestMethod.DELETE)
    public Response deleteVendor(@PathVariable Integer id) {
        vendorService.deleteVendorById(id);
        return Response.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public Response handleAllException(Exception ex) {
        return Response.serverError().entity(ex).build();
    }
}
