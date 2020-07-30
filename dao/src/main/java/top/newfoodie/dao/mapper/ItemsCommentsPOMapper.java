package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.ItemsCommentsPO;
import top.newfoodie.domain.po.ItemsCommentsPOExample;

public interface ItemsCommentsPOMapper {
    int countByExample(ItemsCommentsPOExample example);

    int deleteByExample(ItemsCommentsPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ItemsCommentsPO record);

    int insertSelective(ItemsCommentsPO record);

    List<ItemsCommentsPO> selectByExample(ItemsCommentsPOExample example);

    ItemsCommentsPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ItemsCommentsPO record, @Param("example") ItemsCommentsPOExample example);

    int updateByExample(@Param("record") ItemsCommentsPO record, @Param("example") ItemsCommentsPOExample example);

    int updateByPrimaryKeySelective(ItemsCommentsPO record);

    int updateByPrimaryKey(ItemsCommentsPO record);
}