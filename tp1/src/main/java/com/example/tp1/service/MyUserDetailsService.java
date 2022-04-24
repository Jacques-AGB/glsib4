package com.example.tp1.service;

import com.example.tp1.Authentication.MyUserDetails;
import com.example.tp1.modele.Categorie;
import com.example.tp1.modele.User;
import com.example.tp1.repository.CategorieRepository;
import com.example.tp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserRepository categorieRepository;

    //enregistrer une categorie
    public void saveUser(User user){
        userRepository.save(user);
    }

    //afficher liste de categorie
    public List<User> showUser(){
        return userRepository.findAll();
    }

    //trouver une categorie spécifique
    public User showOneUser(int id){
        return userRepository.findById(id).get();
    }

    //supprimer une categorie
    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }
}
