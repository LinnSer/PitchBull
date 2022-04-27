package com.pitchbull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pitchbull.Entity.Server;
import com.pitchbull.Enum.Status;
import com.pitchbull.Service.ServerService;

@RunWith(SpringRunner.class)
@SpringBootTest()
class PitchbullTestApplicationTests {

	 @Autowired
		private ServerService service;

	 	public void createServer() {
	    	service.createServer(new Server(1, "172.0.0.0", Status.valueOf("STOP").getStatus()));
		}
	 	
	    @Test
	    public void concurrentCallsUpdate() {
	    	createServer();
	    	
	    	service.updateServer("172.0.0.0", new Server(1, "172.1.1.1", "STOP"));
	    	service.updateServer("172.0.0.1",new Server(1, "172.1.1.2", "STOP"));
	    	service.updateServer("172.0.0.2",new Server(1, "172.1.1.3", "STOP"));
	    	service.updateServer("172.0.0.3",new Server(1, "172.1.1.4", "STOP"));
	    	service.updateServer("172.0.0.0",new Server(1, "172.1.1.5", null));
	    	
	    	
	    }

}
