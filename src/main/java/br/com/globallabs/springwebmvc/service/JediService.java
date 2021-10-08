package br.com.globallabs.springwebmvc.service;

import br.com.globallabs.springwebmvc.exception.JediNotFoundException;
import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public List<Jedi> getAll() {
        return repository.getAll();
    }

    public Jedi getJediById(int id){
        final Optional<Jedi> optionalJedi = repository.getJediById(id);
        if(optionalJedi.isPresent()){
            return optionalJedi.get();
        }else{
            throw new JediNotFoundException();
        }
    }

    public Jedi addJedi(Jedi jedi) {
        return repository.addJedi(jedi);
    }

    public Jedi updateJediById(int id, Jedi jedi){
        Optional<Jedi> optionalJedi = this.repository.getJediById(id);
        if(optionalJedi.isPresent()){
            this.repository.updateJediById(id, jedi);
            return jedi;
        }else{
            throw new JediNotFoundException();
        }
    }

    public void deleteJediById(int id){
        this.getJediById(id);
        this.repository.deleteJediById(id);
    }

}
