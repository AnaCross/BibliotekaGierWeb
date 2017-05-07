package pl.wgrel.entities;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Gra {
	private int numerKatalogowy;
	private String tytul;
	private String opis;
	private String wydawnictwo;
	private BigDecimal cenaNabycia;
	private Date dataNabycia;
	private String autor;
	private Status status;
	
	public static Gra produceGra(int numerKatalogowy, String tytul, String opis, String wydawnictwo, BigDecimal cenaNabycia, Date dataNabycia, String autor, Status status){
		Gra gra = new Gra();
		gra.numerKatalogowy = numerKatalogowy;
		gra.tytul = tytul;
		gra.opis = opis;
		gra.wydawnictwo = wydawnictwo;
		gra.cenaNabycia = cenaNabycia;
		gra.dataNabycia = dataNabycia;
		gra.autor = autor;
		gra.status = status;
		return gra;
	}

	public int getNumerKatalogowy() {
		return numerKatalogowy;
	}

	public void setNumerKatalogowy(int numerKatalogowy) {
		this.numerKatalogowy = numerKatalogowy;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getWydawnictwo() {
		return wydawnictwo;
	}

	public void setWydawnictwo(String wydawnictwo) {
		this.wydawnictwo = wydawnictwo;
	}

	public BigDecimal getCenaNabycia() {
		return cenaNabycia;
	}

	public void setCenaNabycia(BigDecimal cenaNabycia) {
		this.cenaNabycia = cenaNabycia;
	}

	public Date getDataNabycia() {
		return dataNabycia;
	}

	public void setDataNabycia(Date dataNabycia) {
		this.dataNabycia = dataNabycia;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((cenaNabycia == null) ? 0 : cenaNabycia.hashCode());
		result = prime * result + ((dataNabycia == null) ? 0 : dataNabycia.hashCode());
		result = prime * result + numerKatalogowy;
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tytul == null) ? 0 : tytul.hashCode());
		result = prime * result + ((wydawnictwo == null) ? 0 : wydawnictwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gra other = (Gra) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (cenaNabycia == null) {
			if (other.cenaNabycia != null)
				return false;
		} else if (!cenaNabycia.equals(other.cenaNabycia))
			return false;
		if (dataNabycia == null) {
			if (other.dataNabycia != null)
				return false;
		} else if (!dataNabycia.equals(other.dataNabycia))
			return false;
		if (numerKatalogowy != other.numerKatalogowy)
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (status != other.status)
			return false;
		if (tytul == null) {
			if (other.tytul != null)
				return false;
		} else if (!tytul.equals(other.tytul))
			return false;
		if (wydawnictwo == null) {
			if (other.wydawnictwo != null)
				return false;
		} else if (!wydawnictwo.equals(other.wydawnictwo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gra [numerKatalogowy=" + numerKatalogowy + ", tytul=" + tytul + ", opis=" + opis + ", wydawnictwo="
				+ wydawnictwo + ", cenaNabycia=" + cenaNabycia + ", dataNabycia=" + dataNabycia + ", autor=" + autor
				+ ", status=" + status + "]";
	}
	
	

}
