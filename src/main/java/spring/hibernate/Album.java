package spring.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="album")
public class Album implements Serializable{

	private Long id;
	private int version;
	private String title;
	private Date release_date;
	private Singer singer;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="singer_id")
	public Singer getSinger() {
		return singer;
	}
	
	
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
	@Column
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Temporal(TemporalType.DATE)
	@Column
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	@Override
	public String toString() {
		return "Album - Id: " + id + ", Title: " +
			title + ", Release Date: " + release_date;
	}
}
