package br.edu.ifsp.thebook.usecases.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.usecases.comment.gateway.CommentDAO;
import br.edu.ifsp.thebook.web.model.comment.request.CommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentCRUDImpl implements CommentCRUD {
    private final CommentDAO commentDAO;

    public CommentCRUDImpl(CommentDAO commentDAO){ this.commentDAO =commentDAO;
    }
    @Override
    public Comment registerNewComment(UUID userId, UUID chatroomId, CommentRequest request){
        System.out.println(request.getText());
        Comment comment = request.toComment();
        System.out.println(comment.getText());
        comment.setIdUser(userId);
        comment.setIdChatroom(chatroomId);
        return commentDAO.addNewComment(comment);
    }

    @Override
    public List<Comment> getAll(){
        List<Comment> comments = commentDAO.findAll();
        return comments;
    }

    @Override
    public List<Comment> getAllByChatroomId(UUID chatroomId) {
        return commentDAO.findAllByIdChatroom(chatroomId);
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
    public Comment delete(CommentRequest request, UUID commentId){ return null;}


}
