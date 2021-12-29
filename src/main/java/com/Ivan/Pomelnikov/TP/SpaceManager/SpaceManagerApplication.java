package com.Ivan.Pomelnikov.TP.SpaceManager;

import com.Ivan.Pomelnikov.TP.SpaceManager.GUI.Index;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpaceManagerApplication {

	public static void main(String[] args) {
		Index index = new Index();
		SpringApplication.run(SpaceManagerApplication.class, args);
	}
}
