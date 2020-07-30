package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.OrderStatusPO;
import top.newfoodie.domain.po.OrderStatusPOExample;

public interface OrderStatusPOMapper {
    int countByExample(OrderStatusPOExample example);

    int deleteByExample(OrderStatusPOExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderStatusPO record);

    int insertSelective(OrderStatusPO record);

    List<OrderStatusPO> selectByExample(OrderStatusPOExample example);

    OrderStatusPO selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderStatusPO record, @Param("example") OrderStatusPOExample example);

    int updateByExample(@Param("record") OrderStatusPO record, @Param("example") OrderStatusPOExample example);

    int updateByPrimaryKeySelective(OrderStatusPO record);

    int updateByPrimaryKey(OrderStatusPO record);
}