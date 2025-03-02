package zyx.contentservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_share")
public class Share {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    private String title;
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField("update_time")
    private LocalDateTime updateTime;
    @TableField("is_original")
    private Boolean isOriginal;
    private String author;
    private String cover;
    private String summary;
    private Integer price;
    @TableField("download_url")
    private String downloadUrl;
    @TableField("buy_count")
    private Integer buyCount;
    @TableField("show_flag")
    private Boolean showFlag;
    @TableField("audit_status")
    private String auditStatus;
    private String reason;
}