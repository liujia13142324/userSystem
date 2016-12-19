
create table profile(
     id integer primary key,
     name varchar(20) not null, 
     birthday varchar(20)not null, 
     gender varchar(4), 
     career varchar(20), 
     address varchar(50), 
     mobile varchar(20)
);

select * from profile

delimiter $$
drop procedure if exists insertdata $$
create procedure insertdata()
begin
	declare init_data integer default 1;
    while init_data <= 1000 do
    insert into profile values(
    (select nextval('sq_usid')),
    random_str(20), 
    str_to_date(now(),'%Y-%m-%d %H:%i:%s'),
    case ceil(rand()*2) when 1 then '男' when 2 then '女'  end ,
	case ceil(rand()*6) when 1 then 'java工程师' when 2 then '数据管理员' when 3 then '数据挖掘师' when 4 then 'UI设计' when 5 then '嵌入式开发' when 6 then '算法师' end,
    case ceil(rand()*6) when 1 then '湖南' when 2 then '北京' when 3 then '上海' when 4 then '深圳' when 5 then '天津' when 6 then '重庆' end,
    '180'||ceil(floor(10000000+rand()*99999999))
    ) ;
    set init_data = init_data+1;
    end while;
end $$
delimiter;

call insertdata();

select random_str(20)

select * from sequence

alter table profile add picPath varchar(200);

select * from PROFILE;

alter table profile add privige smallint default 0 

update profile set privige=1 where id=1003;
