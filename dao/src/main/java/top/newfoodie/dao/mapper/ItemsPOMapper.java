package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.ItemsPO;
import top.newfoodie.domain.po.ItemsPOExample;

public interface ItemsPOMapper {
    int countByExample(ItemsPOExample example);

    int deleteByExample(ItemsPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ItemsPO record);

    int insertSelective(ItemsPO record);

    List<ItemsPO> selectByExampleWithBLOBs(ItemsPOExample example);

    List<ItemsPO> selectByExample(ItemsPOExample example);

    ItemsPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ItemsPO record, @Param("example") ItemsPOExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemsPO record, @Param("example") ItemsPOExample example);

    int updateByExample(@Param("record") ItemsPO record, @Param("example") ItemsPOExample example);

    int updateByPrimaryKeySelective(ItemsPO record);

    int updateByPrimaryKeyWithBLOBs(ItemsPO record);

    int updateByPrimaryKey(ItemsPO record);
}