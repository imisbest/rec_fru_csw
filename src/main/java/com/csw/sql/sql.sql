
drop table user;
create table user(
id varchar(99),
name varchar(99),
password varchar(99)
);
insert into user values('1','qqq','qqq');

drop table admin;
create table admin(
id varchar(99),
name varchar(99),
password varchar(99)
);
insert into admin values('1','admin','admin');

drop table list;
create table list(
id varchar(99),
name varchar(99),
price varchar(99),
count int(99),
pic varchar(99),
category varchar(99),
path varchar(99),
nname varchar(99)
);

drop table rec;
create table rec(
id varchar(99),
name varchar(99),
ccc int(99),
uid varchar(99)
);

drop table cate1;
create table cate1(
id varchar(99),
name varchar(99)
);
insert into cate1 values('1','生鲜水果');
insert into cate1 values('2','数码产品');
insert into cate1 values('3','精选服装');

drop table cate2;
create table cate2(
id varchar(99),
name varchar(99),
cid varchar(99)
);
insert into cate2 values('1','生鲜','1');
insert into cate2 values('2','水果','1');
insert into cate2 values('3','手机','2');
insert into cate2 values('4','电脑','2');
insert into cate2 values('5','女装','3');
insert into cate2 values('6','男装','3');

