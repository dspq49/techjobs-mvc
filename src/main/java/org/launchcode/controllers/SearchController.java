package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";


    }

    // TODO #1 - Create handler to process search request and display results


    @RequestMapping(value = "results")
    public String newSearch(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {


        //newSearch(search.html.newSearch.render("values", search());
        //String name = request.getParameter("searchTerm");
        ArrayList<HashMap<String, String>> newSearch;

        if (searchType.equals("all")){
            newSearch = JobData.findByValue(searchTerm);
            model.addAttribute("jobs", newSearch);
            return "search";

//pass something in search and pass something to list-jobs
// ask what we need to pass to, look at techjobs-console
        } else {
            newSearch = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("jobs", newSearch);
            return "search";


        }
    }
}

//needs page and search type