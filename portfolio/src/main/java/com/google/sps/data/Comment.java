package com.google.sps.data;

public class Comment{

    private long id;
    private String name;
    private String commentText;

    public Comment(long id, String name, String commentText){
        this.id = id;
        this.name = name;
        this.commentText = commentText;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCommentText(String commentText){
        this.commentText = commentText;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCommentText(){
        return commentText;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;

        if(o == this) return true;

        if(!(o instanceof Comment)){
            return false;
        }

        Comment that = (Comment) o;

        if(this.name.equals(that.name) && this.commentText.equals(that.commentText)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
        result = 31 * result + (this.commentText != null ? this.commentText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return name + ": " + commentText;
    }

}