package top.newfoodie.provider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.newfoodie.common.api.CommonResponse;
import top.newfoodie.common.api.ResponseFactory;
import top.newfoodie.common.enums.FoodieCodesEnum;
import top.newfoodie.common.exception.FoodieCoreException;
import top.newfoodie.dao.mapper.UserPOMapper;
import top.newfoodie.domain.po.UserPO;
import top.newfoodie.domain.po.UserPOExample;
import top.newfoodie.domain.vo.req.CheckDBReq;

import javax.validation.Valid;
import java.util.List;

@Api(description = "测试接口")
@RequestMapping("/health")
@RestController
public class HealthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    @Autowired
    private UserPOMapper userPOMapper;

    @ApiOperation(value = "测试连接", httpMethod = "GET")
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public CommonResponse checkHealth() {
        LOGGER.info("new-foodie check health!");
        throw new FoodieCoreException(FoodieCodesEnum.INTERNAL_ERROR);
    }

    @ApiOperation(value = "查询用户", httpMethod = "GET")
    @RequestMapping(value = "checkdb", method = RequestMethod.GET)
    public CommonResponse<List<UserPO>> checkDB(@Valid @ModelAttribute CheckDBReq req, BindingResult bindingResult) {
        UserPOExample example = new UserPOExample();
        example.createCriteria().andIdEqualTo(req.getId());
        List<UserPO> userPOS = this.userPOMapper.selectByExample(example);
        return ResponseFactory.buildCommonResponse(userPOS);
    }
}
