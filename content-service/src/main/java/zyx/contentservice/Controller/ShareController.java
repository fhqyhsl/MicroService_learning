package zyx.contentservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zyx.contentservice.Service.ShareService;
import zyx.contentservice.Vo.ShareVO;

@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public ShareVO getShareById(@PathVariable Integer id) {
        return shareService.getShareByIdWithUserInfo(id);
    }
}