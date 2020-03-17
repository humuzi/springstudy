package learning.com.Controller;

import learning.com.mybatis.mapper.UserRedPacketMapper;
import learning.com.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by HuQiuYue on 2019-11-19
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedpacketController {
    @Autowired private UserRedPacketService userRedPacketService;


    @RequestMapping(value = "/grapRedPacket")
    @ResponseBody
    public Map<String,Object> grapRedPacket(Long redPacketId,Long userId){
        int result = userRedPacketService.grapRedPacket(redPacketId,userId);

        Map<String,Object> redMap = new HashMap<>();
        boolean flag = result > 0;
        redMap.put("success",flag);
        redMap.put("message",flag ?"成功":"失败");
        return redMap;
    }

    @RequestMapping(value = "/grapRedPacketForVersion")
    @ResponseBody
    public Map<String,Object> grapRedPacketForVersion(Long redPacketId,Long userId){
        int result = userRedPacketService.grapRedPacketForVersion(redPacketId,userId);

        Map<String,Object> redMap = new HashMap<>();
        boolean flag = result >0;
        redMap.put("success",flag);
        redMap.put("message",flag?"成功":"失败");
        return redMap;
    }


}
