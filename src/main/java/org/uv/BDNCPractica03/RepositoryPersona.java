package org.uv.BDNCPractica03;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryPersona extends MongoRepository<Persona, String> {
    
}
