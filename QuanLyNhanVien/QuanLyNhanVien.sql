create table NhanSu(
maNhanSu varchar(50) primary key,
hoVaTen nvarchar(255),
gioiTinh bit,
ngaySinh date,
sdt varchar(20),
luong float
);
create table Account (
userName varchar(50) primary key,
[passWord] varchar(255),
maNhanSu varchar(50), 
foreign key (maNhanSu) references NhanSu(maNhanSu)
);


select * from NhanSu
select * from Account