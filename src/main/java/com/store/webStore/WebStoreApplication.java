package com.store.webStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.beans.Customizer;
import java.util.List;

@SpringBootApplication
public class WebStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStoreApplication.class, args);
	}

}
