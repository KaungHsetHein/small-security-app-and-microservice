



create table address(
    id int not null auto_increment,
    street_name varchar(60),
    state varchar(60),
    city varchar(60),
    primary key (id)
);
insert into address(street_name,state,city)
values
    ('Dream Land','Myanmar','Yangon'),
    ('Love Lane','Myanmar','Mandalay'),
    ('Strand Road','Myanmar','Ygn'),
    ('79 Park Avenue','Myanmar','Yangon'),
    ('Creek Bridge Road','Myanmar','Yangon');








