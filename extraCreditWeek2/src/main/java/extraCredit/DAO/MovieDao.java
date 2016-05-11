package extraCredit.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import extraCredit.domain.Actor;
import extraCredit.domain.Artist;
import extraCredit.domain.Director;
import extraCredit.domain.Genre;
import extraCredit.domain.Movie;
import extraCredit.domain.Rating;



@Transactional
@Service
public class MovieDao {

	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public MovieDao() throws ParseException{
		Movie m1 = new Movie("pay it forward",2000,"Based on true story", Rating.Excellent, Genre.Drama);
		Movie m2 = new Movie("Beautiful mind",2001,"Story of Mathematician", Rating.Excellent, Genre.Drama);
		m1.addComments("Loved this movie");
		m1.addComments("Best movie i have ever seen");
		m2.addComments("Such an inspirational movie");
		
		Artist actor1 = new Actor("Tony","Tom Hanks","Iowa",sdf.parse("10/20/1965"));
		Artist director1 = new Director("James Cameroon","Chicago",sdf.parse("11/15/1970"));
		Artist actor2 = new Actor("David","Russel Crow","NewYork",sdf.parse("10/01/1960"));
		Artist director2 = new Director("Cambridge","Louisianna",sdf.parse("11/23/1975"));
		
		m1.addArtists(actor1);
		m1.addArtists(director1);
		
		m2.addArtists(actor2);
		m2.addArtists(director2);
		
		add(m1);
		add(m2);
		
	}
	
	public void add(Movie m) {
		sf.getCurrentSession().persist(m);
	}
	
	public List<Artist> getAll() { //Getting all artists
		Query q = sf.getCurrentSession().createQuery("from Movie");
		List<Artist> artists = q.list();
		return artists;
	}
}
