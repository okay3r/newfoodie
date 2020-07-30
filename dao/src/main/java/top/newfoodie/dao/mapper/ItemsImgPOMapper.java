package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.ItemsImgPO;
import top.newfoodie.domain.po.ItemsImgPOExample;

public interface ItemsImgPOMapper {
    int countByExample(ItemsImgPOExample example);

    int deleteByExample(ItemsImgPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ItemsImgPO record);

    int insertSelective(ItemsImgPO record);

    List<ItemsImgPO> selectByExample(ItemsImgPOExample example);

    ItemsImgPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ItemsImgPO record, @Param("example") ItemsImgPOExample example);

    int updateByExample(@Param("record") ItemsImgPO record, @Param("example") ItemsImgPOExample example);

    int updateByPrimaryKeySelective(ItemsImgPO record);

    int updateByPrimaryKey(ItemsImgPO record);
}