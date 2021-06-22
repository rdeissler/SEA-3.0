package de.telekom.sea3.webserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   // entspricht der "Zeile" in der Datenbanktabelle
@Table(name="persons")

public class Person {

	@Id
	private Long id;
	@Column
	private String anrede;
	@Column
	private String vorname;
	@Column
	private String nachname;
	@Column
	private String str;
	@Column
	private String hausNr;
	@Column	
	private String plz;
	@Column
	private String ort;
	@Column
	private String email;

	public Person(Long id, String anrede, String vorname, String nachname, String str, String hausNr, String plz,
			String ort, String email) {
		this.id = id;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.str = str;
		this.hausNr = hausNr;
		this.plz = plz;
		this.ort = ort;
		this.email = email;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getHausNr() {
		return hausNr;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
