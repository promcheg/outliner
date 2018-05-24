package promcheg.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author waldemar
 *
 */
public class Utils {
	
	
	/**
	 * 
	 * @param filename
	 * @param clazz
	 * @return
	 */
	public static <T> T readEntity(String filename, Class<T> clazz) {
		if(filename == null) {
			return null;
		}
		
		String json = "";
		
		if((json = Utils.readFile(filename)) == null) {
			return null;
		}
		
		Gson gson = (new GsonBuilder()).create();
		T result = gson.fromJson(json, clazz);
		return result;
	}
	
	/**
	 * 
	 * @param filename
	 * @param clazz
	 */
	public static <T> void writeEntity(String filename, T entity, Class<T> clazz) {
		Gson gson = (new GsonBuilder()).create();
		String json = gson.toJson(entity, clazz);
		Utils.writeFile(new File(filename), json);
	}
	
	/**
	 * 
	 * @param file
	 */
	public static void writeFile(File file, String json) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Utils.close(writer);
		}
	}

	/**
	 * 
	 * @param writer
	 */
	public static void close(Writer writer) {
		if(writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	public static String readFile(File file) {
		StringBuffer result = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				result.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Utils.close(reader);
		}
		
		return result.toString();		
	}
	
	/**
	 * 
	 * @param reader
	 */
	private static void close(Reader reader) {
		try {
			if(reader != null) {
				reader.close();
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static String readFile(String filename) {
		File file = new File(filename);
		if(file.exists() && file.isFile()) {
			return readFile(new File(filename));	
		}
		
		return null;
	}
}
