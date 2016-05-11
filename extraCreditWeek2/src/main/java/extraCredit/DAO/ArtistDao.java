package extraCredit.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import extraCredit.domain.Actor;
import extraCredit.domain.Artist;
import extraCredit.domain.Director;

@Transactional
@Service
public class ArtistDao {
	
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public ArtistDao(){
	
	}
	
	/*public void add(Artist a) {
		sf.getCurrentSession().persist(a);
		//artists.add(a);
	}*/
	

	public List<Artist> getAll() { //Getting all artists
		Query q = sf.getCurrentSession().createQuery("from Artist");
		List<Artist> artists = q.list();
		return artists;
	}

	public List<Artist> getAllActors() { //Getting all Actors
		Query q =sf.getCurrentSession().getNamedQuery("searchActors");
		List<Artist> actors = q.list();
		return actors;
	}
	
	public List<Artist> getAllDirectors() { //Getting all Directors
		Query q =sf.getCurrentSession().getNamedQuery("searchDirectors");
		List<Artist> directors = q.list();
		return directors;
	}
	
	public Artist getArtistById(long id){
		return (Artist) sf.getCurrentSession().get(Artist.class,id);
	}

	public void update(Artist artist) {
		sf.getCurrentSession().saveOrUpdate(artist);
	}


	public void delete(Artist artist) {
		sf.getCurrentSession().delete(artist);
	}
}
