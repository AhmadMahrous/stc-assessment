CREATE TABLE USERS (
    USER_ID int IDENTITY(1,1) PRIMARY KEY,
    USER_NAME varchar(255)
    
);

insert into users values('John Doe')
insert into users values('Jane Don')
insert into users values('Alice Jones')
insert into users values('Lisa Romero')

CREATE TABLE Training_details (
    USER_TRAINING_ID int IDENTITY(1,1) PRIMARY KEY,
    USER_ID int ,
	TRAINING_ID int,
	TRAINING_DATE datetime
    
);

insert into Training_details values(1,1,'2015-08-02')
insert into Training_details values(2,1,'2015-08-03')
insert into Training_details values(3,2,'2015-08-02')
insert into Training_details values(4,2,'2015-08-04')
insert into Training_details values(2,2,'2015-08-03')
insert into Training_details values(1,1,'2015-08-02')
insert into Training_details values(3,2,'2015-08-04')
insert into Training_details values(4,3,'2015-08-03')
insert into Training_details values(1,4,'2015-08-03')
insert into Training_details values(3,1,'2015-08-02')
insert into Training_details values(4,2,'2015-08-04')
insert into Training_details values(3,2,'2015-08-02')
insert into Training_details values(1,1,'2015-08-02')
insert into Training_details values(4,3,'2015-08-03')

select  u.USER_ID,t.TRAINING_ID,t.TRAINING_DATE,count(t.TRAINING_ID) COUNTS from USERS u
inner join Training_details t on u.USER_ID = t.USER_ID
group by u.USER_ID,t.TRAINING_ID,t.TRAINING_DATE
Having count(t.training_id)>1
order by t.TRAINING_DATE desc

