package br.edu.ifsp.thebook.usecases.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.usecases.comment.gateway.CommentDAO;
import br.edu.ifsp.thebook.web.model.comment.request.CommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentCRUDlmpl implements CommentCRUD {
    private final CommentDAO commentDAO;

    public CommentCRUDlmpl(CommentDAO commentDAO){ this.commentDAO =commentDAO;
    }
    @Override
    public Comment registerNewComment(CommentRequest request){
        Comment comment = request.toComment();
        return commentDAO.addNewComment(comment);
    }

    @Override
    public List<Comment> getAll(){
        List<Comment> comments = commentDAO.findAll();
        return comments;
    }

    @Override
    public Comment getById(UUID id){
        Comment comment = commentDAO.findById(id).get();
        return comment;
    }

    @Override
    public Comment getByIdUser(UUID idUser){
        Comment comment = commentDAO.findByIdUser(idUser).get();
        return comment;
    }

    @Override
    public Comment getByIdBook(UUID idBook){
        Comment comment = commentDAO.findByIdBook(idBook).get();
        return comment;
    }

    @Override
    public Comment delete(CommentRequest request, UUID commentId){ return null;}

    @Override
    public Comment registerNewComment(UUID idUser, UUID idBook) {
        return null;
    }

    @Override
    public Comment findComment(UUID idUser, UUID idBook) {
        return null;
    }


}
