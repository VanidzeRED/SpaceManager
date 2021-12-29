package com.Ivan.Pomelnikov.TP.SpaceManager;

import com.Ivan.Pomelnikov.TP.SpaceManager.GUI.Index;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpaceManagerApplication {

	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpaceManagerApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
		new Index(context);
	}
}
