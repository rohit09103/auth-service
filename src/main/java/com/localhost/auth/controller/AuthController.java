/**
 * 
 */
package com.localhost.auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base Controller
 */
@RestController
@CrossOrigin(methods = { RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.HEAD,
		RequestMethod.DELETE, RequestMethod.PATCH,
		RequestMethod.PUT }, origins = { "http://127.0.0.1:5500" }, allowedHeaders = "*")
public interface AuthController {

}
