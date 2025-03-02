package zyx.contentservice.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyx.contentservice.Mapper.ShareMapper;
import zyx.contentservice.OpenFeign.User;
import zyx.contentservice.OpenFeign.UserFeignClient;
import zyx.contentservice.Service.ShareService;
import zyx.contentservice.Vo.ShareVO;
import zyx.contentservice.entity.Share;

@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public ShareVO getShareByIdWithUserInfo(Integer id) {
        Share share = this.getById(id);
        if (share == null) return null;

        // 通过 Feign 调用 user-service 获取作者信息
        User author = userFeignClient.getUserById(share.getUserId());

        ShareVO shareVO = new ShareVO();
        BeanUtils.copyProperties(share, shareVO);
        shareVO.setAuthorId(author.getId());
        shareVO.setAuthorName(author.getUserName());
        shareVO.setAuthorAvatar(author.getAvatarUrl());

        return shareVO;
    }
}
