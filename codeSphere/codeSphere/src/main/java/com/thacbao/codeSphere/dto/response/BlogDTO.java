package com.thacbao.codeSphere.dto.response;

import com.thacbao.codeSphere.entity.Blog;
import com.thacbao.codeSphere.entity.Reaction;
import com.thacbao.codeSphere.enums.BlogStatus;
import com.thacbao.codeSphere.enums.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Integer id;
    private String title;
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String excerpt;

    private String featuredImage;
    private BlogStatus status;
    private boolean isFeatured;
    private int viewCount;
    private LocalDateTime publishedAt;
    private UserDTO author;

    private Set<String> tags;

    private long commentCount;

    private Map<ReactionType, Long> reactionCounts;


    public BlogDTO(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.excerpt = blog.getExcerpt();
        this.content = blog.getContent();
        this.featuredImage = blog.getFeaturedImage();
        this.author = new UserDTO(blog.getAuthor());
        this.tags = blog.getTags().stream().map(rs -> rs.getName()).collect(Collectors.toSet());
        this.status = blog.getStatus();
        this.isFeatured = blog.isFeatured();
        this.viewCount = blog.getViewCount();
        this.publishedAt = blog.getPublishedAt();
        this.createdAt = blog.getCreatedAt();
        this.updatedAt = blog.getUpdatedAt();
        this.commentCount = blog.getComments().size();
        this.reactionCounts = calculateReactionCounts(blog.getReactions());
    }
    private Map<ReactionType, Long> calculateReactionCounts(List<Reaction> reactions) {
        return reactions.stream()
                .collect(Collectors.groupingBy(
                        Reaction::getReactionType,
                        Collectors.counting()
                ));
    }
}
