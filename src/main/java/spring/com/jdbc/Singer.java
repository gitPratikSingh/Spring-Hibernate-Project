package spring.com.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

public class Singer implements Serializable{
	private Long id;
	private String lastName;
	private String firstName;
	private Date birthDate;
	
	@Override
	public String toString() {
		return "Id: "+id +", firstName: "+ firstName+", lastName: "+ lastName+", birthDate: "+ birthDate; 
	} 
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date date) {
		this.birthDate = date;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	private List<Album> albums;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean addAlbum(Album album) {
		
		if(albums==null) {
			albums = new ArrayList<>();
		}
		
		if(albums.contains(album)) {
			return false;
		}else {
			albums.add(album);
		}
		
		return true;
	}
}
