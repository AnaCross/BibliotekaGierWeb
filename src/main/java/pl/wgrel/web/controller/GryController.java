package pl.wgrel.web.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wgrel.entities.Gra;
import pl.wgrel.entities.Status;
import pl.wgrel.services.BibliotekaServices;
import pl.wgrel.services.NotificationService;
import pl.wgrel.services.NotificationServiceImpl;

@Controller
public class GryController {
	@Autowired
    private BibliotekaServices bibliotekaService;

	@Autowired
    private NotificationService notificationService;

    @ModelAttribute("statusyAll")
    public List<Status> populateStatusy() {
        return Arrays.asList(Status.ALL);
    }

    @RequestMapping(value = "/gry/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, final ModelMap model) {
        Optional<Gra> result;
        result = bibliotekaService.findById(id);
        if (result.isPresent()) {
            Gra gra = result.get();
            model.addAttribute("gra", gra);
            return "gra";
        } else {
        	notificationService.addErrorMessage("Cannot find gra #" + id);
            model.clear();
            return "redirect:/gry";
        }
    }

    @RequestMapping(value = "/gry/{id}/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Gra> viewAsJson(@PathVariable("id") Long id, final ModelMap model) {
        Optional<Gra> result;
        result = bibliotekaService.findById(id);
        if (result.isPresent()) {
            Gra gra = result.get();
            return new ResponseEntity<Gra>(gra, HttpStatus.OK);
        } else {
        	notificationService.addErrorMessage("Cannot find gra #" + id);
            model.clear();
            return new ResponseEntity<Gra>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/gry", params = { "save" }, method = RequestMethod.POST)
    public String saveGra(Gra gra, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
        	notificationService.addErrorMessage("Please fill the form correctly!");
            return "gra";
        }
        Optional<Gra> result = bibliotekaService.edit(gra);
        if (result.isPresent())
        	notificationService.addInfoMessage("Zapis udany");
        else
        	notificationService.addErrorMessage("Zapis NIE udany");
        model.clear();
        return "redirect:/gry";
    }

    @RequestMapping(value = "/gry", params = { "create" }, method = RequestMethod.POST)
    public String createGra(Gra gra, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
        	notificationService.addErrorMessage("Please fill the form correctly!");
            return "gra";
        }
        bibliotekaService.create(gra);
        model.clear();
        notificationService.addInfoMessage("Zapis nowej gry udany");
        return "redirect:/gry";
    }

    @RequestMapping(value = "/gry", params = { "remove" }, method = RequestMethod.POST)
    public String removeRow(final Gra gra, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("remove"));
        Optional<Boolean> result = bibliotekaService.deleteById(rowId.longValue());
        return "redirect:/gry";
    }

    @RequestMapping(value = "/gry/create", method = RequestMethod.GET)
    public String showMainPages(final Gra gra) {
       gra.setDataNabycia(Calendar.getInstance().getTime());
        return "gra";
    }
}
