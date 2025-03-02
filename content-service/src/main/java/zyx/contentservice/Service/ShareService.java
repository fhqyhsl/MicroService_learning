package zyx.contentservice.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import zyx.contentservice.Vo.ShareVO;
import zyx.contentservice.entity.Share;

public interface ShareService extends IService<Share> {
    ShareVO getShareByIdWithUserInfo(Integer id);
}

