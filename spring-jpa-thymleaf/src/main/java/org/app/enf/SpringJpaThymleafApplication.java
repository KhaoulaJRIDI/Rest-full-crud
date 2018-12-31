package org.app.enf;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.app.enf.dao.ClientRepository;
import org.app.enf.entities.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class SpringJpaThymleafApplication {

	public static void main(String[] args) throws ParseException {
	ApplicationContext context=	SpringApplication.run(SpringJpaThymleafApplication.class, args);
	ClientRepository clientRepository = context.getBean(ClientRepository.class)	;
	
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
	clientRepository.save(
			new Client("mohamed", df.parse("2000-10-25"), "mohamed@gmail.com"));	
	
	clientRepository.save(
			new Client("alia", df.parse("1985-11-19"), "ali@gmail.com"));
	
	clientRepository.save(
			new Client("nadia", df.parse("1970-08-10"), "mohamed@gmail.com"));
	
	
	Page<Client>clients = clientRepository.chercherClient("%N%", PageRequest.of(0, 3));
	
	//Page<Client> clients = clientRepository.findAll(new PageRequest(0, 3));
	clients.forEach(c->System.out.println(c.getNom()));
	}

}

