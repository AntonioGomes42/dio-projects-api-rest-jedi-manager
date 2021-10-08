package br.com.globallabs.springwebmvc.rest;

import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/jedi")
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping
    public List<Jedi> getAllJedi(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jedi> getJediById(@PathVariable("id") int id){
        final Jedi jedi = service.getJediById(id);
        return ResponseEntity.ok(jedi);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){
        return service.addJedi(jedi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jedi> updateJediById(@PathVariable("id") int id, @Valid @RequestBody Jedi dto){
        final Jedi jedi = service.updateJediById(id, dto);
        return  ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJediById(@PathVariable int id){
        service.deleteJediById(id);
    }
}
