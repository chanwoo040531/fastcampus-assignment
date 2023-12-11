drop table if exists customers;
drop table if exists stores;
drop table if exists payments;
drop table if exists transactions;

-- 고객(사용자) 테이블
create table customers(
    id          bigint auto_increment,
    name        varchar(255),
    balance     bigint,
    created_at  timestamp(6) default current_timestamp(6),
    updated_at  timestamp(6) default current_timestamp(6) on update current_timestamp(6),

    primary key (id)
);

-- 가맹점(매장) 테이블
create table stores(
    id          bigint auto_increment,
    name        varchar(255),
    location    varchar(255),
    created_at  timestamp(6) default current_timestamp(6),
    updated_at  timestamp(6) default current_timestamp(6) on update current_timestamp(6),

    primary key (id)
);

-- 결제 테이블
create table payments(
    id          bigint auto_increment,
    store_id    bigint not null,
    amount      bigint,
    status      varchar(31), -- PENDING | APPROVED | DENIED
    created_at  timestamp(6) default current_timestamp(6),
    updated_at  timestamp(6) default current_timestamp(6) on update current_timestamp(6),

    primary key (id),
    foreign key (store_id) references stores(id) -- n:1
);

-- 거래 테이블
create table transactions(
    id              bigint auto_increment,
    customer_id     bigint not null,
    payment_id      bigint not null,
    status          varchar(31), -- SUCCESS | FAIL
    created_at  timestamp(6) default current_timestamp(6),
    updated_at  timestamp(6) default current_timestamp(6) on update current_timestamp(6),

    primary key (id),
    foreign key (customer_id) references customers(id), -- n:1
    foreign key (payment_id) references payments(id) -- n:1
);