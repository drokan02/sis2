/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import modelo.VO.Documento;

/**
 *
 * @author Hp
 */
public class Work {

    private String title;
    private String autor;
    private Documento file;
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    public Work() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Documento getFile() {
        return file;
    }

    public void setFile(Documento file) {
        this.file = file;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }
    private Date dateUpload;

}
