/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Raul
 */
public class Work {
    private String title;
    private User author;
    private File file;
    private ArrayList<Commentary> comments;
    private Date sendDate;

    public Work(String title, User author, File file, Date sendDate) {
        this.title = title;
        this.author = author;
        this.file = file;
        this.sendDate = sendDate;
        this.comments = new ArrayList<>();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public File getFile() {
        return file;
    }

    public void setFile() {
        Document fil = new Document();
        this.file = fil.getDocument();
    }

    public ArrayList<Commentary> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Commentary> comments) {
        this.comments = comments;
    }
    
    public void addCommentary(Commentary comt){
        comments.add(comt);
    }
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    
    
}
