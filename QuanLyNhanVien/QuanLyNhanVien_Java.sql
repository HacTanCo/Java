USE [QuanLyNhanSu_Java]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/9/2025 9:38:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[userName] [varchar](50) NOT NULL,
	[passWord] [varchar](255) NULL,
	[maNhanSu] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanSu]    Script Date: 3/9/2025 9:38:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanSu](
	[maNhanSu] [varchar](50) NOT NULL,
	[hoVaTen] [nvarchar](255) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[sdt] [varchar](20) NULL,
	[luong] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanSu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([userName], [passWord], [maNhanSu]) VALUES (N'hactanco', N'12', N'QL1')
INSERT [dbo].[Account] ([userName], [passWord], [maNhanSu]) VALUES (N'hoangvananh', N'123', N'QL2')
INSERT [dbo].[Account] ([userName], [passWord], [maNhanSu]) VALUES (N'nguyenvanan', N'123', N'NV1')
INSERT [dbo].[NhanSu] ([maNhanSu], [hoVaTen], [gioiTinh], [ngaySinh], [sdt], [luong]) VALUES (N'NV1', N'Nguyen Van An', 0, CAST(N'2004-02-02' AS Date), N'0123654789', 999999)
INSERT [dbo].[NhanSu] ([maNhanSu], [hoVaTen], [gioiTinh], [ngaySinh], [sdt], [luong]) VALUES (N'QL1', N'Hắc Tấn Có', 1, CAST(N'2004-04-24' AS Date), N'0825315414', 1000000000)
INSERT [dbo].[NhanSu] ([maNhanSu], [hoVaTen], [gioiTinh], [ngaySinh], [sdt], [luong]) VALUES (N'QL2', N'Hoang Van Anh', 0, CAST(N'0001-01-01' AS Date), N'01236549879', 100000)
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([maNhanSu])
REFERENCES [dbo].[NhanSu] ([maNhanSu])
GO
