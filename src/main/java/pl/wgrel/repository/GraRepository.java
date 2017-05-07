package pl.wgrel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Objects;

import pl.wgrel.entities.Gra;
import pl.wgrel.entities.Status;

@Service
@Qualifier("lista")
public class GraRepository implements GryRepository {

	private List<Gra> gry = new ArrayList<Gra>(){
		{
			add(Gra.produceGra(1L, "Agricola", "Wersja rodzinna dla 1-4 graczy", "Lacerta", new BigDecimal("99.00"), new Date(), "Uwe Rosenberg", Status.NOWA));
			add(Gra.produceGra(2L, "Labirynth", "Wersja z promkami", "Let's Play", new BigDecimal("99.00"), new Date(), "Kamil Matuszak", Status.DO_SPRZEDANIA));
			add(Gra.produceGra(3L, "Mistfall", "Polska edycja, wspieram.to z dodatkiem Vasskyr", "Games Publishing", new BigDecimal("170.00"), new Date(), "Błażej Kubacki", Status.DO_SPRZEDANIA));
			add(Gra.produceGra(4L, "Pandemic Iberia", "Limitowana edycja", "Z-Man Games", new BigDecimal("180.00"), new Date(), "Matt Leacock", Status.DUBLET));
			add(Gra.produceGra(5L, "Wsiąść do Pociągu: USA", "Nagroda Spiel des Jahres", "Rebel", new BigDecimal("120.00"), new Date(), "Alan R. Moon", Status.DUBLET));
			add(Gra.produceGra(6L, "Dominion", "Z 5 dodatkami (max 6 graczy)", "Games Factory", new BigDecimal("130.00"), new Date(), "Donald X. Vaccarino", Status.DUBLET));
			add(Gra.produceGra(7L, "Patchwork", "Pierwsze wydanie Rebel", "Rebel/Lacerta", new BigDecimal("50.00"), new Date(), "Uwe Rosenberg", Status.NOWA));
			add(Gra.produceGra(8L, "Ghost Stories", "Trudna kooperacja", "Repos", new BigDecimal("120.00"), new Date(), "Antoine Bauza", Status.NOWA));
			add(Gra.produceGra(9L, "7 Cudów Świata: Pojedynek", "Tylko dla 2 graczy", "Repos/Rebel", new BigDecimal("79.00"), new Date(), "Antoine Bauza", Status.NOWA));
			add(Gra.produceGra(10L, "7 Samurajów", "Kooperacyjna gra logiczna", "Rebel", new BigDecimal("50.00"), new Date(), "Antoine Bauza", Status.NOWA));
			add(Gra.produceGra(11L, "Posiadłość Szaleństwa Druga Edycja", "♥ ♥ ♥", "Galakta/FFG", new BigDecimal("350.00"), new Date(), "Uwe Rosenberg", Status.NOWA));
		}
	};
	
	@Override
	public Gra create(Gra gra) throws GraAlreadyExistsException {
		if (!gry.isEmpty()) {
            gra.setNumerKatalogowy(
                    this.gry.stream().mapToLong(p -> p.getNumerKatalogowy()).max().getAsLong() + 1);
        } else {
            gra.setNumerKatalogowy(1L);
        }
        this.gry.add(gra);
        return gra;
	}

	@Override
	public Gra readById(Long id) throws NoSuchGraException {
		return this.gry.stream().filter(p -> Objects.equals(p.getNumerKatalogowy(), id)).findFirst().orElseThrow(NoSuchGraException::new);
	}

	@Override
	public Gra update(Gra gra) throws NoSuchGraException {
		for (int i = 0; i < this.gry.size(); i++) {
            if (Objects.equals(this.gry.get(i).getNumerKatalogowy(), gra.getNumerKatalogowy())) {
                this.gry.set(i, gra);
                return gra;
            }
        }
        throw new NoSuchGraException("Nie ma takiej gry: " + gra.getNumerKatalogowy());
	}

	@Override
	public void deleteById(Long id) throws NoSuchGraException {
		for (int i = 0; i < this.gry.size(); i++) {
            if (Objects.equals(this.gry.get(i).getNumerKatalogowy(), id)) {
                this.gry.remove(i);
            }
        }
        throw new NoSuchGraException("Nie ma takiej gry: " + id);
		
	}

	@Override
	public List<Gra> findAll() {
		return gry;
	}
	@Override
	public List<Gra> findAllToSell(){
		List<Gra> tosell = new ArrayList<Gra>();
		for(Gra gra : gry){
			if(gra.getStatus() == Status.DO_SPRZEDANIA){
				tosell.add(gra);
			}
		}
		return tosell;
	}
	@Override
	public List<Gra> findAllDoublet(){
		List<Gra> dubel = new ArrayList<Gra>();
		for(Gra gra : gry){
			if(gra.getStatus() == Status.DUBLET){
				dubel.add(gra);
			}
		}
		return dubel;
	}

}
