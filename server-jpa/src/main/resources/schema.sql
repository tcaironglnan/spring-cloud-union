drop table if exists user;
create table user(
    id bigint primary key not null auto_increment,
    username varchar(40),
    name varchar(20),
    age int(3),
    balance decimal(10,2)
);

insert into user(id,username,name,age,balance)values (
1,'tom1','allen1',20,100.00
);

insert into user(id,username,name,age,balance)values (
2,'tom2','allen2',30,200.00
);

insert into user(id,username,name,age,balance)values (
3,'tom3','allen3',40,300.00
);

insert into user(id,username,name,age,balance)values (
4,'tom4','allen4',50,400.00
);