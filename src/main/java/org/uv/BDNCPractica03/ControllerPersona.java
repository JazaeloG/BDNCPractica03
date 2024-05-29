package org.uv.BDNCPractica03;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins= "*")
public class ControllerPersona {
    @Autowired
    private RepositoryPersona repositoryPersona;
    
    @GetMapping()
    public List<Persona> list() {
        return repositoryPersona.findAll();
    }
    
    @GetMapping("/{id}")
    public Persona get(@PathVariable String id) {
        Optional<Persona> optPersona = repositoryPersona.findById(id);
        if(optPersona.isPresent())
            return optPersona.get();
        else
            return null;
    }
    
    @PutMapping("/{id}")
    public Persona put(@PathVariable String id, @RequestBody Persona personaDetails) {
        Optional<Persona> optPersona = repositoryPersona.findById(id);
        if(optPersona.isPresent()){
            Persona persona = optPersona.get();
            persona.setNombre(personaDetails.getNombre());
            persona.setDireccion(personaDetails.getDireccion());
            persona.setTelefono(personaDetails.getTelefono());
            return repositoryPersona.save(persona);
        } else {
            return null; 
        }
    }
    
    @PostMapping
    public Persona post(@RequestBody Persona personaDetails) {
        return repositoryPersona.save(personaDetails);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repositoryPersona.deleteById(id);
    }
    
}
