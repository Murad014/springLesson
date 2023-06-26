package com.hibernate.hibernate.data.jdbcTemplate;

import com.hibernate.hibernate.entity.TacoOrder;

public interface TacoOrderRepository {
    TacoOrder save(TacoOrder tacoOrder);

}
