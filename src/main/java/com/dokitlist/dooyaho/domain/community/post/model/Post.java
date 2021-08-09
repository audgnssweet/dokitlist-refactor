package com.dokitlist.dooyaho.domain.community.post.model;

import com.dokitlist.dooyaho.common.model.BaseTimeEntity;
import com.dokitlist.dooyaho.domain.community.comment.model.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "POST")
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

}