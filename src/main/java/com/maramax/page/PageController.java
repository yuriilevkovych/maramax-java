package com.maramax.page;

import com.maramax.callback.Callback;
import com.maramax.service.YearsLeadingCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Year;

@Controller
public class PageController {
    @Autowired
    private PageRepository pageRepository;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("callback", new Callback());
    }

    @GetMapping("/page/{name}")
    public String page(@PathVariable(value = "name") String name, Model model) {
        if (!pageRepository.existsByName(name)) {
            return "redirect:/";
        }

        Page page = this.pageRepository.findByName(name);

        model.addAttribute("page", page);
        model.addAttribute("title", page.getTitle());
        model.addAttribute("style", page.getCss_file());
        model.addAttribute("script", page.getJs_file());
        model.addAttribute("yearsLeading", YearsLeadingCalculator.calculate());

        return name;
    }
}
