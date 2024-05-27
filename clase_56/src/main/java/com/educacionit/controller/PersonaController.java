package com.educacionit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.educacionit.entidad.Persona;

import jakarta.servlet.http.HttpSession;

@Controller
public class PersonaController {

    public PersonaController() {
        super();
    }

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        List<Persona> personas = (List<Persona>) session.getAttribute("personas");
        if (personas == null) {
            personas = new ArrayList<>();
            session.setAttribute("personas", personas);
        }

        if (personas.isEmpty()) {
            personas.add(new Persona("Alejandro", 10));
            personas.add(new Persona("Alejandro1", 50));
        }

        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("persona") Persona persona, HttpSession session) {
        List<Persona> personas = (List<Persona>) session.getAttribute("personas");
        if (personas == null) {
            personas = new ArrayList<>();
            session.setAttribute("personas", personas);
        }
        personas.add(persona);
        return "redirect:/";
    }

    @GetMapping("/delete/{indice}")
    public String delete(@PathVariable("indice") Integer indice, HttpSession session) {
        List<Persona> personas = (List<Persona>) session.getAttribute("personas");
        if (personas != null && indice >= 0 && indice < personas.size()) {
            personas.remove((int) indice);
        }
        return "redirect:/"; // Redirige a la página principal después de eliminar
    }
}
