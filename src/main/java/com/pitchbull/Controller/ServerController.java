package com.pitchbull.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pitchbull.Entity.Server;
import com.pitchbull.Enum.Status;
import com.pitchbull.Service.ServerService;

@RestController
@RequestMapping("/server")
public class ServerController {
	@Autowired
	private ServerService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<Server> create(@RequestParam(required = true, name = "ip") String newIp,
			@RequestParam(required = true, name = "status") String newStatus) {
		Server response = service.createServer(new Server(null, newIp, Status.valueOf(newStatus).getStatus()));
		
		return new ResponseEntity<>(response, response==null ? HttpStatus.CONFLICT : HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateNoRequired/{ip}")
	public ResponseEntity<Server>  updateNoRequired(@PathVariable("ip") String ipServer,
			@RequestParam(required = true, name = "id") String newId,
			@RequestParam(required = true, name = "ip") String newIp,
			@RequestParam(required = true, name = "status") String newStatus) {
		Server response = service.updateServer(ipServer, new Server(null, newIp, Status.valueOf(newStatus).getStatus()));
	   
		return new ResponseEntity<>(response, response==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@PutMapping(value = "/updateRequired/{ip}")
	public ResponseEntity<Server> updateRequired(@PathVariable("ip") String ipServer,
			@RequestParam(required = true, name = "ip") String newIp,
			@RequestParam(required = true, name = "status") String newStatus) {
		Server response = service.updateServer(ipServer, new Server(null, newIp, Status.valueOf(newStatus).getStatus()));
		
		return new ResponseEntity<>(response, response==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
		
	}

}
