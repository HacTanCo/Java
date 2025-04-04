USE [22T1020557]
GO
/****** Object:  Table [dbo].[MTXachTay]    Script Date: 6/4/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MTXachTay](
	[mm] [nvarchar](50) NOT NULL,
	[tm] [nvarchar](50) NULL,
	[nnh] [date] NULL,
	[gia] [float] NULL,
	[sl] [int] NULL,
	[mau] [nvarchar](50) NULL,
	[kcmh] [float] NULL,
 CONSTRAINT [PK_MTXachTay] PRIMARY KEY CLUSTERED 
(
	[mm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[MTXachTay] ([mm], [tm], [nnh], [gia], [sl], [mau], [kcmh]) VALUES (N'MXT1', N'may d', CAST(N'2013-05-01' AS Date), 89099, 50, N'xanh', 16)
INSERT [dbo].[MTXachTay] ([mm], [tm], [nnh], [gia], [sl], [mau], [kcmh]) VALUES (N'MXT2', N'may e', CAST(N'2013-04-30' AS Date), 89099, 70, N'xanh', 14)
INSERT [dbo].[MTXachTay] ([mm], [tm], [nnh], [gia], [sl], [mau], [kcmh]) VALUES (N'MXT3', N'may f', CAST(N'2013-04-22' AS Date), 89099, 80, N'xanh', 16.5)
