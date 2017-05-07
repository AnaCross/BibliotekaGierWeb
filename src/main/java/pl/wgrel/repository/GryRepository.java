package pl.wgrel.repository;

import java.util.List;

import pl.wgrel.entities.Gra;



public interface GryRepository {
	Gra create(Gra Gra) throws GraAlreadyExistsException;
    Gra update(Gra Gra) throws NoSuchGraException;
    void deleteById(Long id) throws NoSuchGraException;
    List<Gra> findAll();
    List<Gra> findAllToSell();
    List<Gra> findAllDoublet();
	Gra readById(Long id) throws NoSuchGraException;
}
