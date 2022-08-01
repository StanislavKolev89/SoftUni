package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.CommentCreationDTO;
import bg.softuni.personalproject.model.dto.CommentDTO;

import bg.softuni.personalproject.model.entity.CommentEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepository, UserService userService, ProductService productService, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    public CommentDTO createComment(CommentCreationDTO commentCreationDTO) {
        UserEntity author = userService.findByName(commentCreationDTO.getUsername());
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCreatedAt(LocalDateTime.now());
        commentEntity.setAuthor(author);
        commentEntity.setProduct(productService.returnProduct(commentCreationDTO.getProductId()));
        commentEntity.setContent(commentCreationDTO.getContent());

        CommentEntity newAddedComment = commentRepository.save(commentEntity);
        CommentDTO commentDTO = modelMapper.map(newAddedComment, CommentDTO.class);
        commentDTO.setCommentCreator(newAddedComment.getAuthor().getUsername());
        return commentDTO;
    }

    public List<CommentDTO> getAllCommentsOfCurrentProduct(Long productId) {
        List<CommentDTO> commentDTOS = commentRepository.findAllByProductId(productId).stream()
                .map(commentEntity -> {
                    CommentDTO commentDTO = modelMapper.map(commentEntity, CommentDTO.class);
                    commentDTO.setCommentCreator(commentEntity.getAuthor().getUsername());
                    return commentDTO;
                })
                .collect(Collectors.toList());

        return commentDTOS;

    }
}
