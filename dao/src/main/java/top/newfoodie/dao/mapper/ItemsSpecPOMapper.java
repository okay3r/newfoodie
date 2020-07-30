package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.ItemsSpecPO;
import top.newfoodie.domain.po.ItemsSpecPOExample;

public interface ItemsSpecPOMapper {
    int countByExample(ItemsSpecPOExample example);

    int deleteByExample(ItemsSpecPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ItemsSpecPO record);

    int insertSelective(ItemsSpecPO record);

    List<ItemsSpecPO> selectByExample(ItemsSpecPOExample example);

    ItemsSpecPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ItemsSpecPO record, @Param("example") ItemsSpecPOExample example);

    int updateByExample(@Param("record") ItemsSpecPO record, @Param("example") ItemsSpecPOExample example);

    int updateByPrimaryKeySelective(ItemsSpecPO record);

    int updateByPrimaryKey(ItemsSpecPO record);
}