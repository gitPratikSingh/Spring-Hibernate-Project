package spring.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {
	private Long id;
	private String first_name;
	private String last_name;
	private Date birth_date;
	private int version;
	
	private Set<Album> albums = new HashSet<>();
	
	private Set<Instrument> instruments = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="singer_instrument", joinColumns=@JoinColumn(name="singer_id"), inverseJoinColumns=@JoinColumn(name="instrument_id"))
	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	@OneToMany(mappedBy="singer", cascade=CascadeType.ALL, orphanRemoval=true)
	public Set<Album> getAlbums() {
		return albums;
	}
	
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="first_name")
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name="last_name")
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
	@Version
	@Column(name="version")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String toString() {
		return "Singer - Id: " + id + ", First name: " + first_name
				+ ", Last name: " + last_name + ", Birthday: " + birth_date;
		}
	
}
