package com.ajax.prueba;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ajax.documents.Rol;
import com.ajax.documents.Usuario;
import com.ajax.services.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		 String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/cargar" , method= RequestMethod.POST)
	public String cargar(@RequestParam MultipartFile file){
		if(!file.isEmpty()){
			try {
				byte[] archivo = file.getBytes();
				
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("/home/erik/imagen.png")));
				out.write(archivo);
				out.close();
				System.out.println("El archivo a sido subido");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("El Archivo no ha sido subido");
			}
		}
		return "home";
	}
	

	@RequestMapping(value="/otro")
	public @ResponseBody String respuesta(@RequestParam String nombre){
		nombre = nombre + " gran marica";
		System.out.println("nombre: "+ nombre);
		usuarioServicio.delete();
		return nombre;
	}
	
	
	@Autowired
	UsuarioService usuarioServicio;
	
	
	@RequestMapping(value="/resultado")
	public @ResponseBody List<Usuario> respuesta(@RequestParam String username , @RequestParam String password , @RequestParam String role){
		
		System.out.println("usuerio : "+ username + " clave: " + password + " rol:" + role);
		
		Usuario usuario = new Usuario();
		usuario.setClave(password);
		usuario.setUsuario(username);
		Rol rol = new Rol();
		rol.setId(UUID.randomUUID().toString());
		rol.setRol(Integer.parseInt(role));
		usuario.setRol(rol);
		
		usuarioServicio.createUsuario(usuario);
		
		return usuarioServicio.readUsuarios();
	}
	
	@RequestMapping(value="/cargar")
	public @ResponseBody List<Usuario> cargar(){
		return usuarioServicio.readUsuarios();
	}
}
