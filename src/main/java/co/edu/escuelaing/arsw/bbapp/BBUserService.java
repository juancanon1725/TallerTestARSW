package co.edu.escuelaing.arsw.bbapp;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.escuelaing.arsw.bbapp.BBUser;

public interface BBUserService extends MongoRepository<BBUser, String>{
    public BBUser findByName(String name);
}
