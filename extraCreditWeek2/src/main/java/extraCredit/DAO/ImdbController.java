package extraCredit.DAO;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import extraCredit.domain.Artist;
import extraCredit.domain.Movie;


@Controller
public class ImdbController {

	@Resource
	private ArtistDao artistDao;

	@Resource
	private MovieDao movieDao;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "movieList";
	}
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public String getAll(Model model){
		model.addAttribute("movies", movieDao.getAll());
		return "movieList";
	}
	
	@RequestMapping(value="/addMovie", method = RequestMethod.GET)
	public String addMovie(@ModelAttribute Movie m) {
        return "addMovie";
    }
	@RequestMapping(value="/addArtist", method = RequestMethod.GET)
	public String addArtist(@ModelAttribute Artist a) {
        return "addArtist";
    }
	
    @RequestMapping(value = "/artist/delete", method = RequestMethod.POST)
	public String delete(Artist a) {
        artistDao.delete(a);
        return "redirect:/artists";
    }


	
	
	
}
