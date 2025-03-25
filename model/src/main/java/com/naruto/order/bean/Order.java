package com.naruto.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 23189784902347589L;

    private Long orderId;
}
