package pl.wgrel.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.wgrel.entities.Gra;
import pl.wgrel.repository.GraAlreadyExistsException;
import pl.wgrel.repository.GraRepository;
import pl.wgrel.repository.NoSuchGraException;

@Service
@Qualifier("lista")
public class BibliotekaServiceImpl implements BibliotekaServices {

	@Autowired
    @Qualifier("lista")
	private GraRepository bazaDanych;
	
	@Override
	public List<Gra> findAll() {
		return bazaDanych.findAll();
	}
	
	@Override
	public List<Gra> findAllDoublet() {
		return bazaDanych.findAllDoublet();
	}
	
	@Override
	public List<Gra> findAllToSell() {
		return bazaDanych.findAllToSell();
	}

	@Override
	public Optional<Gra> findById(int id) {
		try {
            return Optional.of(bazaDanych.readById(id));
        } catch (NoSuchGraException e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<Gra> create(Gra gra) {
		try {
            return Optional.of(bazaDanych.create(gra));
        } catch (GraAlreadyExistsException e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<Gra> edit(Gra gra) {
		try {
            return Optional.of(bazaDanych.update(gra));
        } catch (NoSuchGraException e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<Boolean> deleteById(Long id) {
		try {
            bazaDanych.deleteById(id);
            return Optional.of(Boolean.TRUE);
        } catch (NoSuchGraException e) {
            return Optional.of(Boolean.FALSE);
        }
	}

	@Override
	public List<Gra> findLatest3() {
		return Collections.emptyList();
	}

}
