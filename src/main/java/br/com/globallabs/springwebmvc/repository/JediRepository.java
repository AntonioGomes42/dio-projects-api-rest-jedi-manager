package br.com.globallabs.springwebmvc.repository;

import br.com.globallabs.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JediRepository {

    private List<Jedi> jediList;

    public JediRepository() {
        jediList = new ArrayList<>();
        jediList.add(new Jedi("Luke", "Skywalker"));
        jediList.add(new Jedi("Obi-Wan", "Kenobi"));
        jediList.add(new Jedi("Qui-Gon", "Jinn"));
    }

    public List<Jedi> getAll() {
        return jediList;
    }

    public Optional<Jedi> getJediById(int id){
        try{
            final Jedi returnedJedi = jediList.get(id);
            return Optional.of(returnedJedi);
        }catch (Exception exception){
            exception.getStackTrace();
        }
        return Optional.empty();
    }

    public Jedi addJedi(final Jedi jedi) {
       this.jediList.add(jedi);
       return jedi;
    }

    public Jedi updateJediById(int id,Jedi jedi){
        jediList.set(id, jedi);
        return jedi;
    }

    public void deleteJediById(int id){
        jediList.remove(id);
    }
}
