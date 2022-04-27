package com.pitchbull.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitchbull.Entity.Server;

public interface IServerRepo extends JpaRepository<Server, Integer>{
	
	Server findByIp(String ip);

}
