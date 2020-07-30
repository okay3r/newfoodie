package top.newfoodie.provider.controller;

import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.newfoodie.dao.mapper.UserPOMapper;
import top.newfoodie.domain.po.UserPOExample;

@RequestMapping("/health")
@RestController
public class HealthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @Autowired
    private UserPOMapper userPOMapper;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String checkHealth() {
        LOGGER.info("new-foodie check health!");
        return "success";
    }

    @RequestMapping(value = "checkdb", method = RequestMethod.GET)
    public String checkDB(String id) {
        UserPOExample example = new UserPOExample();
        example.createCriteria().andIdEqualTo(id);
        return this.userPOMapper.selectByExample(example).toString();
    }
}
