package com.dokitlist.dooyaho.domain.community.comment.model;

import com.dokitlist.dooyaho.common.model.BaseTimeEntity;
import com.dokitlist.dooyaho.domain.community.post.model.Post;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "POST")
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID", nullable = false, updatable = false)
    private Post post;

}
