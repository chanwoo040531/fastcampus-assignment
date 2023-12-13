delete from stores where id in (1);

insert into stores (id, name, location, balance, created_at, updated_at)
VALUES (1, '십원집', '서울특별시 관악구 봉천동 521 십원집 1층', 0, current_timestamp(6), current_timestamp(6));