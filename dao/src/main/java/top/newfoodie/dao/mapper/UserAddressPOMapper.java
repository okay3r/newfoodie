package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.UserAddressPO;
import top.newfoodie.domain.po.UserAddressPOExample;

public interface UserAddressPOMapper {
    int countByExample(UserAddressPOExample example);

    int deleteByExample(UserAddressPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserAddressPO record);

    int insertSelective(UserAddressPO record);

    List<UserAddressPO> selectByExample(UserAddressPOExample example);

    UserAddressPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserAddressPO record, @Param("example") UserAddressPOExample example);

    int updateByExample(@Param("record") UserAddressPO record, @Param("example") UserAddressPOExample example);

    int updateByPrimaryKeySelective(UserAddressPO record);

    int updateByPrimaryKey(UserAddressPO record);
}