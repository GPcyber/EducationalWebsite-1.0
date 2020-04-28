package com.example.eventplanner;

import com.example.eventplanner.model.Role;
import com.example.eventplanner.model.User;
import com.example.eventplanner.repository.Rolerepository;
import com.example.eventplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class EventplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventplannerApplication.class, args);
	}

	@Component
	class rolecommandliner implements CommandLineRunner {

		@Autowired
		private Rolerepository rolerepository;


		@Override
		public void run(String... args) throws Exception {

			Role user = new Role();
			user.setRoleid(1);
			user.setDesignation("user");
			rolerepository.save(user);

			Role admin = new Role();
			admin.setRoleid(2);
			admin.setDesignation("admin");
			rolerepository.save(admin);
		}
		@Component
		class usercommandliner implements CommandLineRunner {

			@Autowired
			private UserRepository userrepository;

			@Override
			public void run(String... args) throws Exception {


				User user1=new User();
				user1.setUid(Long.parseLong("2"));
				user1.setUname("admin");
				user1.setUemail("admin@expertzlab");
				user1.setUpassword("1234");
				user1.setUmobilenumber("7897897897");

				userrepository.save(user1);

			}
	    }
	}
	}
