# 用户表
create table 'user'(
    'id' bigint(20) NOT NULL AUTO_INCREMEN COMMENT '用户ID',
    'user_name' varchar(64) DEFAULT NULL COMMENT '用户登录名',
    'password' varchar(20) NOT NULL COMMENT '登陆密码',
    'name' varchar(100) DEFAULT NULL COMMENT '姓名',
    'id_card_no' varchar(50) DEFAULT NULL COMMENT '身份证号',
    'mobile' char(20) DEFAULT NULL COMMENT '手机号码',
    'nick_name' varchar(64) DEFAULT NULL COMMENT '用户昵称',
    'bank_card_no'varchar(50) DEFAULT NULL COMMENT '银行卡号',
    'status' tinyint(4) DEFAULT '0' COMMENT '用户状态',
    'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    'modify_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 商品表
create table 'goods'(
    'id' bigint(20) NOT NULL AUTO_INCREMEN COMMENT '商品ID',
    'goods_name' varchar(64) DEFAULT NULL COMMENT '商品名称',
    'price' decimal(10 ,2) DEFAULT 0 COMMENT '商品单价',
    'desc' text DEFAULT NULL COMMENT '描述',
    'classify' varchar(20) DEFAULT NULL COMMENT '分类',
    'status' tinyint(4) DEFAULT '0' COMMENT '商品状态',
    'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    'modify_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 订单表
create table 'orders'(
    'id' bigint(20) NOT NULL AUTO_INCREMEN COMMENT '订单ID',
    'user_id' bigint(20) NOT NULL COMMENT '用户ID',
    'amount' decimal(10 ,2) NOT NULL COMMENT '总金额',
    'status' tinyint(4) DEFAULT '0' COMMENT '商品状态',
    'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    'modify_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 订单详情
create table 'orders_details'(
    'id' bigint(20) NOT NULL AUTO_INCREMEN COMMENT '订单详情ID',
    'orders_id' bigint(20) NOT NULL COMMENT '订单ID',
    'goods_id' bigint(20) NOT NULL COMMENT '商品ID',
    'total' bigint(10) NOT NULL COMMENT '商品数量',
    'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    'modify_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 购物车
create table 'cart'(
    'id' bigint(20) NOT NULL AUTO_INCREMEN COMMENT '购物车ID',
    'user_id' bigint(20) NOT NULL COMMENT '用户ID',
    'amount' decimal(10 ,2) NOT NULL COMMENT '总金额',
    'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    'modify_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 购物车详情
create table 'cart_detail'(
    'id' bigint(20) NOT NULL AUTO_INCREMEN COMMENT '购物车ID',
    'cart_id' bigint(20) NOT NULL COMMENT '购物车ID',
    'goods_id' bigint(20) NOT NULL COMMENT '商品ID',
    'total' bigint(20) NOT NULL COMMENT '商品数量',
    'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    'modify_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;