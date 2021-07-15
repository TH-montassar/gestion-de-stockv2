package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stock.mvc.entites.Client;
import com.stock.mvc.services.IClientService;
import com.stock.mvc.services.IFlickrService;

@Controller
@RequestMapping(value ="/client")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	@Autowired
	private IFlickrService flickrService;
	
	@RequestMapping(value="/")
	public String client(Model model) {
		List<Client> clients =clientService.selectAll();
		if(clients ==null) {
			
			clients =new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		
		return "client/client";
	}

	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
    public String ajouterClient(Model model) {
    	Client client =new Client();
 
        model.addAttribute("client",client);
    	return "client/ajouterClient";
    }
	@RequestMapping(value = "/enregistrer")
	public String enregistrerClient(@Valid Client client, Model model,  MultipartFile file,RedirectAttributes redirectAttrs,BindingResult bindingResult) {
		String photoUrl = null;
		if (client != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, client.getNom());
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			    client.setPhoto(photoUrl);
				clientService.save(client);
			}
		
		return "redirect:/client/";
	}
}
