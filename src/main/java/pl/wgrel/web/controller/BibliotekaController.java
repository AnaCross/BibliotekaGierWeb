package pl.wgrel.web.controller;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wgrel.entities.Gra;
import pl.wgrel.entities.Status;
import pl.wgrel.services.BibliotekaServices;
import pl.wgrel.services.NotificationService;
import pl.wgrel.services.NotificationServiceImpl;

@Controller
public class BibliotekaController {
	@Autowired
	private BibliotekaServices bibliotekaService;
	
	@Autowired
    private NotificationService notificationService;// = new NotificationServiceImpl();
	
	@ModelAttribute("statusyAll")
    public List<Status> populateStatusy() {
        return Arrays.asList(Status.ALL);
    }

    @ModelAttribute("gamesAll")
    public List<Gra> populateGames() {
        return this.bibliotekaService.findAll();
    }

    @ModelAttribute("gamesToSell")
    public List<Gra> populateGamesToSell() {
        List<Gra> result = this.bibliotekaService.findAllToSell();
        if(result == null)
        	System.out.println("NULL");
        else
        {
        	System.out.println("List size: "+result.size());
        	for(Gra gra : result)
        		System.out.println("nrkat: "+gra.getNumerKatalogowy());
        }
        return result;
    }
    
    @ModelAttribute("gamesDouble")
    public List<Gra> populateGamesDouble() {
        return this.bibliotekaService.findAllDoublet();
    }
	
	@RequestMapping({ "/", "/index.html" })
    public String index(Model model) {
        return "index";
    }
	
	@RequestMapping("/tosell")
    public String showToSellPage() {
        return "tosell";
    }
    
//    @RequestMapping("/gry")
//    public String showLibraryPage() {
//        return "biblioteka";
//    }
     @RequestMapping(value = "/gry", method = RequestMethod.GET)
     public String showMainPage(Model model) {
        model.addAttribute("MyMessages",  notificationService.getNotificationMessages());
        return "biblioteka";
     }
    @RequestMapping("/double")
    public String showDoublePage() {
        return "double";
    }
}
