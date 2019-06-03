package cct.longdaoyun02.mapper;

import cct.longdaoyun02.entity.Transactions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionsMapper {
    List<Transactions> findByItemName(String keyword);
    List<Transactions> findByCompanyName(String keyword);
    List<Transactions> findByItemNumber(String keyword);
    List<Transactions> findByStatus(@Param("bidStatus1") Integer bidStatus1, @Param("bidStatus2") Integer bidStatus2);
    List<Transactions> findByTrans(@Param("keyword") String keyword,
                                   @Param("bidStatus") Integer bidStatus,
                                   @Param("bidStatus1") Integer bidStatus1,
                                   @Param("bidStatus2") Integer bidStatus2);


}