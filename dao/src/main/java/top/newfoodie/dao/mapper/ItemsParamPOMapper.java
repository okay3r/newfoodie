package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.ItemsParamPO;
import top.newfoodie.domain.po.ItemsParamPOExample;

public interface ItemsParamPOMapper {
    int countByExample(ItemsParamPOExample example);

    int deleteByExample(ItemsParamPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ItemsParamPO record);

    int insertSelective(ItemsParamPO record);

    List<ItemsParamPO> selectByExample(ItemsParamPOExample example);

    ItemsParamPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ItemsParamPO record, @Param("example") ItemsParamPOExample example);

    int updateByExample(@Param("record") ItemsParamPO record, @Param("example") ItemsParamPOExample example);

    int updateByPrimaryKeySelective(ItemsParamPO record);

    int updateByPrimaryKey(ItemsParamPO record);
}