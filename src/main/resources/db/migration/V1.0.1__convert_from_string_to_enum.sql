alter table payments modify status enum('PENDING', 'APPROVED', 'DENIED');

alter table transactions modify status enum('SUCCESS', 'FAIL');