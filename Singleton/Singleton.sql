USE [Singleton]
GO
/****** Object:  Table [dbo].[Nganh]    Script Date: 3/5/2025 4:57:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Nganh](
	[maNganh] [varchar](20) NOT NULL,
	[tenNganhDaoTao] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNganh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 3/5/2025 4:57:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SinhVien](
	[maSinhVien] [varchar](20) NOT NULL,
	[hoTen] [varchar](100) NULL,
	[maNganh] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[maSinhVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Nganh] ([maNganh], [tenNganhDaoTao]) VALUES (N'T102', N'Bao chi va truyen thong')
INSERT [dbo].[Nganh] ([maNganh], [tenNganhDaoTao]) VALUES (N'T103', N'IT')
INSERT [dbo].[Nganh] ([maNganh], [tenNganhDaoTao]) VALUES (N'T104', N'Tien')
INSERT [dbo].[Nganh] ([maNganh], [tenNganhDaoTao]) VALUES (N'T105', N'PP')
INSERT [dbo].[SinhVien] ([maSinhVien], [hoTen], [maNganh]) VALUES (N'SV001', N'Hac Tan Co', N'T103')
INSERT [dbo].[SinhVien] ([maSinhVien], [hoTen], [maNganh]) VALUES (N'SV002', N'Nguyen Van A', N'T102')
INSERT [dbo].[SinhVien] ([maSinhVien], [hoTen], [maNganh]) VALUES (N'SV003', N'Nguyen Van B', N'T105')
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD FOREIGN KEY([maNganh])
REFERENCES [dbo].[Nganh] ([maNganh])
GO
