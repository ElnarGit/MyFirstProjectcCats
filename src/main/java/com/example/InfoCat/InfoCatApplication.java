package com.example.InfoCat;

import com.example.InfoCat.service.CatService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoCatApplication {
	public static void main(String[] args) {
		var apx = SpringApplication.run(InfoCatApplication.class, args);

		CatService catService = apx.getBean(CatService.class);
		catService.infoCat();
	}

}
