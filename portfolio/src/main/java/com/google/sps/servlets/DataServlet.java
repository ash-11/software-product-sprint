// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

class Comment{

    private String name;
    private String commentText;

    public Comment(String name, String commentText){
        this.name = name;
        this.commentText = commentText;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCommentText(String commentText){
        this.commentText = commentText;
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

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/comments")
public class DataServlet extends HttpServlet {

    private final List<Comment> commentList = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String json = new Gson().toJson(commentList);
        response.getWriter().println(json);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");
        String commentText = request.getParameter("commentText");

        commentList.add(new Comment(name, commentText));
        response.sendRedirect("/index.html");
    }
}
