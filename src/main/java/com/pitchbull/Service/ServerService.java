package com.pitchbull.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitchbull.Entity.Server;
import com.pitchbull.Repository.IServerRepo;


@Service
@Transactional
public class ServerService {

	@Autowired
	private IServerRepo repository;
	@Transactional
	public Server createServer(Server server) {
		Server rest = repository.findByIp(server.getIp());
		if(rest!=null){
			return null;
		}
		else{
		return repository.save(server);
		}
	}
	@Transactional
	public Server updateServer(String ip, Server newServer) {
		Server rest = repository.findByIp(ip);
		if(rest!=null){
		rest.setId(newServer.getId() !=null ? newServer.getId() : rest.getId());
		rest.setIp(newServer.getIp() !=null ? newServer.getIp() : rest.getIp());
		rest.setStatus(newServer.getStatus() != null ? newServer.getStatus()  : rest.getStatus());
		return repository.save(rest);
		}
		return null;
	}

	
	public Server findByIp(String ip) {
		return repository.findByIp(ip);
	}
	
	public Optional<Server> findById(Integer id) {
		return repository.findById(id);
	}


	void updateServive(Server service) {
		
	}
}
