/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Raul
 */
public class UploadDocument {
    
  private String boundary;
  private static final String LINE_FEED = "\r\n";
  private HttpURLConnection httpConn;
  private String charset;
  private OutputStream outputStream;
  private PrintWriter writer;
  
  public void enviarArchivo(Work work){
      try {
          Connector connection = new Connector();
          connection.conectar();
          Connection con = connection.getConexion();
          crearWriter();
          User author = work.getAuthor();
          File file = work.getFile();
          addFilePart("file", file);
          List<String> response = finish();
          
          String cons = "INSERT INTO trabajo (ID_USER, TITLE, NAME_FILE, DESCRIPTION, ESTADO) VALUES (?,?,?,?,?)";
 
            PreparedStatement st = con.prepareStatement(cons);
            st.setInt(1,author.getId());
            st.setString(2, work.getTitle());
            st.setString(3, file.getName());
            st.setString(4, "");
            st.setString(5, "");

            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("agregado correctamente");
                connection.desconectar();
            }
      } catch (Exception e) {
          System.out.println(e.toString());
      }         
}
  
public void crearWriter()throws IOException {
        // creates a unique boundary based on time stamp
        boundary = "===" + System.currentTimeMillis() + "===";
         
        URL url = new URL("http://localhost/investigaciones/subir.php");
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setDoInput(true);
        httpConn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
        httpConn.setRequestProperty("User-Agent", "CodeJava Agent");
        httpConn.setRequestProperty("Test", "Bonjour");
        outputStream = httpConn.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"),true);
  }
 
 public void addFilePart(String fieldName, File uploadFile)throws IOException {
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
        writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
        writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();
 
        FileInputStream inputStream = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        inputStream.close();
         
        writer.append(LINE_FEED);
        writer.flush();    
    }
  public List<String> finish() throws IOException {
        List<String> response = new ArrayList<String>();
 
        writer.append(LINE_FEED).flush();
        writer.append("--" + boundary + "--").append(LINE_FEED);
        writer.close();
 
        // checks server's status code first
        int status = httpConn.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
            httpConn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                response.add(line);
            }
            reader.close();
            httpConn.disconnect();
        } else {
            throw new IOException("Server status: " + status);
        }
 
        return response;
    }
     
     
}
