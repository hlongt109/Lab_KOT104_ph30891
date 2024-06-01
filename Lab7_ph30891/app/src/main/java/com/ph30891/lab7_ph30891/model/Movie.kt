package com.ph30891.lab7_ph30891.model

data class Movie(
    val title: String,
    val year: String,
    val time: String,
    val type: String,
    val posterUrl: String,
    val summary: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie("Chiến Binh Ngầm", "Feb. 22, 2024","01:31:19","Phim Kịch Tính, Phim Tâm Lý", "https://image.tmdb.org/t/p/w185/usDIBB0hOqLM8wMSGistfqxjukZ.jpg","Một cựu quân nhân trôi dạt trở thành chiến binh ngầm với sự giúp đỡ của một cựu tù nhân vừa được thả, đẩy anh ta chống lại cảnh sát tham nhũng và những kẻ giết người được thuê hiện đang truy lùng anh ta và tất cả những người anh ta quan tâm."),
            Movie("Bá Chủ Bầu Trời","Feb. 22, 2024","01:59:00","Phim Kịch Tính, Phim Hành Động","https://image.tmdb.org/t/p/w185/2jDDBvllcb4Uscm5XmgQRTwzDUG.jpg","Trong Thế chiến II, các phi công mạo hiểm mạng sống gia nhập Nhóm Ném Bom 100, tình anh em được hun đúc bởi lòng dũng cảm, sự mất mát và chiến thắng."),
            Movie("Bùa Hình Nhân","Dec. 31, 2023","01:49:17","Phim Kinh Dị, Phim Kịch Tính","https://phimmoiiii.net/wp-content/uploads/2023/04/Bua-Hinh-Nhan.jpg","Bùa Hình Nhân – Hoon Payon (2023) được lấy cảm hứng từ loại bùa hình nhân hộ mệnh nổi tiếng ở Thái Lan, phim theo chân Tham trong hành trình đến một hòn đảo hẻo lánh để tìm người anh trai của mình đang tu hành ở đó. Tham phát hiện ra anh trai đã bị sát hại sau khi bị buộc tội giết người và trộm cắp. Quyết tâm ở lại hòn đảo để điều tra cũng như minh oan cho anh trai nhưng Tham lại vô tình khám phá ra nhiều cái chết bí ẩn khác tại ngôi làng bên cạnh."),
            Movie("Hồn Ma Không Đầu","Dec. 31, 2023","01:43:54","Phim Kinh Dị, Phim Kịch Tính","https://phimmoiiii.net/wp-content/uploads/2022/07/hon-ma-khong-dau.jpg","Hồn Ma Không Đầu – Ivanna (2022) nói về Ambar cô gái sở hữu đôi mắt âm dương cùng người em Dika đến ở tại một viện dưỡng lão. Tại đây, họ đã phát hiện ra sự thật kinh hoàng về hồn ma không đầu Ivanna và một phần lịch sử thảm khốc của nước nhà."),
            Movie("Ma Sơ Trục Quỷ","Dec. 31, 2023","01:50:15","Phim Kinh Dị, Phim Kịch Tính","https://phimmoiiii.net/wp-content/uploads/2022/11/ma-so-truc-quy.jpg","Ma Sơ Trục Quỷ – La Exorcista (2023) Ofelia là một nữ tu trẻ vừa đặt chân đến thị trấn San Ramon đã bị ép phải thực hiện buổi lễ trừ tà cho một phụ nữ đang mang thai. Tưởng chừng buổi trục quỷ đã hoàn tất, Ofelia bàng hoàng nhận ra hiện thân quỷ dữ chưa từng biến mất."),
            Movie("Kiến Quái","Nov. 19, 2023","01:20:01","Phim Hành Động, Phim Kịch Tính","https://phimmoiiii.net/wp-content/uploads/2023/07/Kien-Quai.jpg","Kiến Quái – Detrimental (2023) năm 2070, một công nhân mù mắc kẹt trên hòn đảo bị bão tàn phá. Vậy là anh phải một mình sống sót và trốn tránh đám quái vật ẩn nấp trong bóng tối."),
            Movie("Độc Chiến 2","Nov. 18, 2023","01:57:14","Phim Hành Động, Phim Hình Sự","https://phimmoiiii.net/wp-content/uploads/2023/10/Doc-Chien-2.jpg","Độc Chiến 2 – Believer 2 (2023) một thanh tra kiên định tiếp tục tìm kiếm sự thật đằng sau tổ chức ma túy lớn nhất châu Á và ông trùm giấu mặt – kẻ vẫn còn ân oán dang dở với anh."),
            Movie("Chó Săn Địa Ngục","Feb. 14, 2024","01:44:26","Phim Hành Động, Phim Hình Sự","https://image.tmdb.org/t/p/w185/f9hkaCIha8hIhRo0XXShhcosrPH.jpg","Câu chuyện xoay quanh một sát thủ sắp nghỉ hưu. Nhân vật chính, sau khi nhận được yêu cầu từ một người quen cũ, thực hiện công việc cuối cùng, mở đầu cho cốt truyện của phim. Phim có sự tham gia của các diễn viên như Louis Mandylor, Ron Smoorenburg, Panya Yimmumphai, Vithaya Pansringarm. Đạo diễn Joshua Dixon"),
        )
    }
}