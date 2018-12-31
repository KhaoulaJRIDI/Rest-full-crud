package org.app.enf.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.app.enf.dao.ClientRepository;
import org.app.enf.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/Client")
public class ClientController {
	
    @Autowired
	private ClientRepository clientRepository;
	
    @RequestMapping(value="/index")
    public String index(Model model,@RequestParam(name="page",defaultValue="0") int page,
    		
    		@RequestParam(name="motCle",defaultValue="") String mc	) {
    	
    	Page<Client> pageClients = clientRepository.
    			
    			chercherClient("%"+mc+"%",new PageRequest(page, 3));
    	int pageCount = pageClients.getTotalPages();
    	int[] pages = new int[pageCount];
    	for(int i=0;i<pageCount;i++) pages[i]=i;
    	model.addAttribute("pages",pages);
    	model.addAttribute("pageclients", pageClients);
    	
    	model.addAttribute("pagecourante",page);
    	model.addAttribute("motCle",mc);
    	
    	return "client";
    }
    
    @RequestMapping(value="form",method=RequestMethod.GET)
    public String formClient(Model model) {
    	model.addAttribute("client", new Client());
    	
    	return "FormClient";
    }
    
    @RequestMapping(value="delete",method=RequestMethod.GET)
    public String suppClientClient(Model model) {
    	model.addAttribute("client", new Client());
    	
    	return "SuppClient";
    }
    
    
    @RequestMapping(value="/SaveClient",method=RequestMethod.POST)
    public String save(@Valid Client cli, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		return "FormClient";
    	}
    	
    	clientRepository.save(cli);
    	
    	return "redirect:index";
    }
    
    

    
    
    @RequestMapping(value="/DeleteClient",method=RequestMethod.POST)
    public String delete(Long id) {
    	 
    	
    	clientRepository.deleteById(id);
    	
    	return "redirect:index";
    }
    
    
    

}
