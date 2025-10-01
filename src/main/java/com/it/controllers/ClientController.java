package com.it.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entities.Client;
import com.it.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController 
{
  @Autowired
  private ClientRepository clientRepository;
  
  //Get All Client
  @GetMapping()
  public List<Client> getAllClients()
  {
	  return clientRepository.findAll();
  }
  
  //Get Client By Id
  @GetMapping("/{id}")
  public Optional<Client> getClientById(@PathVariable Integer id)
  {
	  return clientRepository.findById(id);
  }
  
  //Add Client
  @PostMapping()
  public Client addClient(@RequestBody Client client)
  { 
	return clientRepository.save(client);  
  }
  
  //Update Client
  @PutMapping("/{id}")
  public Client updateClient(@RequestBody Client client, @PathVariable Integer id)
  {
	  Optional<Client> op = clientRepository.findById(id);
	  if(op.isPresent())
	  {
		  Client cl = op.get();
		  cl.setName(client.getName());
		  cl.setMobile(client.getMobile());
		  cl.setAddress(client.getAddress());
		  cl.setEmail(client.getEmail());
		  cl.setType(client.getType());
		  cl.setGstNumber(client.getGstNumber());
		  return clientRepository.save(cl);
	  }
	  else
	  {
		  return null;
	  }
  }
  
  //Delete Client
  @DeleteMapping("/{id}")
  public String deleteClient(@PathVariable Integer id)
  {
	  Optional<Client> op = clientRepository.findById(id);
	  if(op.isPresent())
	  {
		  clientRepository.deleteById(id);
		  return "Client deleted and its client id is " + id;
	  }
	  else
	  {
		  return "Client Not Found";
	  }
  }
}
