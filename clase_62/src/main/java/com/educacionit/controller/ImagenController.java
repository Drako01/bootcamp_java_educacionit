package com.educacionit.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.educacionit.entity.Imagen;
import com.educacionit.repository.ImagenRepository;

@Controller
public class ImagenController {
	
	@Autowired
	private ImagenRepository imagenRepository;
	

	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("imagen", new Imagen());
		return "formulario";
	}
	
	
	@PostMapping("/guardar")
	public String guardarImagen(/*@RequestParam("imagenCargada") MultipartFile imagenCargada, */@RequestParam("urlImagen") String urlImagen, Model model) throws IOException {
		Imagen imagen = new Imagen();
		
		imagen.setUrlImagen(urlImagen);
		//imagen.setImagenCargada(imagenCargada.getBytes());
		
		imagenRepository.save(imagen);
		
		return "redirect:/imagenes";
	}
	
	
	@GetMapping("/imagenes")
	public String mostrarImagenes(Model model) {
		
		List<Imagen> imagenes = imagenRepository.findAll();
		
		//List<String> imaganesBase64 = new ArrayList<>();
		
		/*for (Imagen imagen : imagenes) {
			String base64 = Base64.getEncoder().encodeToString(imagen.getImagenCargada());
			imaganesBase64.add(base64);
		}*/
		
		//model.addAttribute("imagenesBase64", imaganesBase64);
		model.addAttribute("imagenes", imagenes);
		
		return "imagenes";
	}
	
}
