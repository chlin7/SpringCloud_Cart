package com.gensoft.order.repository;

import com.gensoft.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 15:35 2019/6/10
 */
public interface IOrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
