package cct.longdaoyun02.mapper;

import cct.longdaoyun02.entity.Cargo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CargoMapper {
    List<Cargo> findAllByStatus(Integer cargoStatus1,Integer cargoStatus2);
    List<Cargo> findAllByCargo(@Param("cargoTimeBegin") Date cargoTimeBegin,
                               @Param("cargoTimeEnd") Date cargoTimeEnd,
                               @Param("orderName")String orderName,
                               @Param("cargoNumber")String cargoNumber,
                               @Param("buyerName")String buyerName,
                               @Param("cargoStatus1")Integer cargoStatus1,
                               @Param("cargoStatus2")Integer cargoStatus2,
                               @Param("cargoStatus")Integer cargoStatus);

}