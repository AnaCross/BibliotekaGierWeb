package pl.wgrel.services;

import java.util.List;
import java.util.Optional;

import pl.wgrel.entities.Gra;

public interface BibliotekaServices {
	List<Gra> findAll();
	
	List<Gra> findAllDoublet();

    List<Gra> findAllToSell();

    Optional<Gra> findById(int id);

    Optional<Gra> create(Gra gra);

    Optional<Gra> edit(Gra gra);

    Optional<Boolean> deleteById(Long id);

    List<Gra> findLatest3();
}
