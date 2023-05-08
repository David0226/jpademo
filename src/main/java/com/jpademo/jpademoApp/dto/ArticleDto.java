package com.jpademo.jpademoApp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String title,
        String comment,
        String hashtag,
        LocalDateTime CreateAt
) implements Serializable {
}
