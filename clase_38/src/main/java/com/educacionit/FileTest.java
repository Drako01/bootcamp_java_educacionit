package com.educacionit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {

		String rutaArchivio = "c:\\Imaganes\\imagen.jpg";
		
		File file = new File(rutaArchivio);
		
		file.isFile();
		file.canRead();
		
		System.out.println("Tamano de la imagen: " + file.length());
		
		FileInputStream reader = new FileInputStream(file);
		byte[] bytesImagen = new byte[(int)file.length()];
		
		// Leo la totalidad de la imagen!
		reader.read(bytesImagen);
		
		// BD - Binary
		//preparedStatement.setBytes(posicion, bytesImagen);
		
		
		
		
	}

}
