package rumm.springframework.services;

import java.util.Set;

import rumm.springframework.model.Vet;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
