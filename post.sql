use spring;

create table post (
	id int auto_increment primary key,
    title varchar(500) not null,
    content text not null,
    writer_id int not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    foreign key (writer_id) references member(id) on delete cascade
);

create table post_file (
	id int auto_increment primary key,
    post_id int not null,
    original_name varchar(255),
    saved_name varchar(255),
    thumbnail_name varchar(255),
    upload_path varchar(255),
    created_at timestamp default current_timestamp,
    foreign key (post_id) references post(id) on delete cascade
);


select * from member;
select * from post;
select * from post_file;