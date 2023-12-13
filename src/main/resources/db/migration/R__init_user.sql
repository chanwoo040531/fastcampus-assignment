delete from customers where id in (1);

insert into customers (id, name, balance, created_at, updated_at)
VALUES (1, '정철희', 15000, current_timestamp(6), current_timestamp(6));