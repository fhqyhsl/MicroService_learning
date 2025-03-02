package zyx.contentservice.Vo;

import lombok.Data;
import zyx.contentservice.entity.Share;

@Data
public class ShareVO extends Share {
    private Integer authorId;
    private String authorName;
    private String authorAvatar;
}