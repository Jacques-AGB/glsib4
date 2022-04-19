package com.example.tp1.service;

import com.example.tp1.modele.Client;
import com.example.tp1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    //Enregistrer un client
    public void SaveClient(Client client){
        clientRepository.save(client);
    }

    //Lister les clients
    public List<Client> showClient(){
        return clientRepository.findAll();
    }

    //Trouver un client
    public Client showOneClient(int id){
        return clientRepository.findById(id).get();
    }

    //Supprimer un client
    public void deleteClient(int id){
        if(showOneClient(id)!=null) {
            clientRepository.deleteById(id);
        }
    }
}
