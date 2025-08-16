package com.projects.game.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NinjaController {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        model.addAttribute("gold", session.getAttribute("gold"));
        model.addAttribute("activities", session.getAttribute("activities"));
        return "index";
    }

    @PostMapping("/process")
    public String process(
            @RequestParam("place") String place,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        Random rand = new Random();
        int goldChange = 0;

        switch (place) {
            case "farm": goldChange = rand.nextInt(11) + 10; break; // 10-20
            case "cave": goldChange = rand.nextInt(6) + 5; break;  // 5-10
            case "house": goldChange = rand.nextInt(4) + 2; break; // 2-5
            case "quest": goldChange = rand.nextInt(101) - 50; break; // -50 to +50
            case "spa": goldChange = -(rand.nextInt(16) + 5); break; // -5 to -20
            case "reset":
                session.setAttribute("gold", 0);
                session.setAttribute("activities", new ArrayList<String>());
                return "redirect:/";
        }

        int currentGold = (int) session.getAttribute("gold") + goldChange;
        session.setAttribute("gold", currentGold);

        List<String> activities = (List<String>) session.getAttribute("activities");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String now = LocalDateTime.now().format(dtf);

        String activity = String.format("%s: Went to %s and %s %d gold",
                now, place, goldChange >= 0 ? "earned" : "lost", Math.abs(goldChange));
        activities.add(activity);

        session.setAttribute("activities", activities);

        if (currentGold < -50) {
            return "redirect:/prison";
        }

        return "redirect:/";
    }

    @GetMapping("/prison")
    public String prison(HttpSession session, Model model) {
        model.addAttribute("gold", session.getAttribute("gold"));
        return "prison";
    }
}
