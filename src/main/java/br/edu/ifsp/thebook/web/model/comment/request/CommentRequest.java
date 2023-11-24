package br.edu.ifsp.thebook.web.model.comment.request;

import br.edu.ifsp.thebook.domain.comment.Comment;

import java.util.UUID;

public class CommentRequest {
    private String text;

    public CommentRequest(String text) {
        this.text = text;
    }

    public CommentRequest() {
    }

    public Comment toComment(){
        return Comment.createWithOnlyText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
