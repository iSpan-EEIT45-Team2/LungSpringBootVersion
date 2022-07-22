--新增會員資料

-- DELETE FROM MemberTable WHERE miAccount = 'admin';
-- DELETE FROM MemberTable WHERE miAccount = 'employee';
-- DELETE FROM MemberTable WHERE miAccount = 'active';
-- DELETE FROM MemberTable WHERE miAccount = 'user';

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress, localfileName) values
    ('管理者-魯夫','C248835717',cast('1999/01/23' as date),'0962594416','abc10@mail.com','admin','$2a$10$0zynuTZo0/NVJlTz5WFAHeRU0EuoUWuCrCSXbUiJv.GPBbcrvUE3y','USER;ACTIVE;EMPLOYEE;ADMIN', '女', 'Y', '臺北市', '中正區', '思源街1號', 'luffy.jpg' );

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress, localfileName) values
    ('員工-娜美','O241686379',cast('1987/12/01' as date),'0926287495','abc20@mail.com','employee','$2a$10$CC006YClBxiYQDhfiIKsyeDgruLWMTQjURSSXAzudRtbuzNidLWMC','USER;ACTIVE;EMPLOYEE', '男', 'Y', '台南市', '安平區', '漁光路114號', 'nami.jpg' );

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress, localfileName) values
    ('驗證會員-喬巴','X181771234',cast('2005/03/16' as date),'0930152563','abc30@mail.com','active','$2a$10$k8K5wToDodcpTs1Phu97S.sZ7n5geCGabJf.z/QjuQ38pzO35A8oq','USER;ACTIVE', '男', 'Y', '屏東縣', '恆春鎮', '大光路79號', 'choppa.jpg' );

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress, localfileName) values
    ('會員-香吉士','W143802241',cast('1996/06/30' as date),'0956410662','abc40@mail.com','user','$2a$10$Zy.cMMbYSb6x0PS5WYVDwOEokd0bMkAjpw/W9jyBmIuijkAulJ6Ee','USER', '不公開', 'Y', '花蓮縣', '壽豐鄉', '中華路20號', 'sanji.jpg');

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress, localfileName) values
    ('金金','W143802241',cast('1996/06/30' as date),'0956410662','kiki19990204@gmail.com','jin','$2a$10$O8Jt62LuimioJ29CBhAAgeTXlkqDWPkOJK.qRaEa9SSp8.l3h1S6.','USER;ACTIVE;EMPLOYEE;ADMIN', '女', 'Y', '新北市', '三峽區', '民族路50號', 'ace.jpg');
--新增公告資料
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';

insert into ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate ) values
    ('dog3.jpg','浪犬入侵騷擾遊客頻傳,花蓮婦幼親創園區架驅狗器' , '花蓮婦幼親創園區於去底揭牌啟用後，由於鄰近環境多有草叢林木容易有遊蕩犬隻出沒，縣府農業處及社會處合作，在圍牆旁設置了10支驅狗器，避免因為遊蕩犬而導致人犬衝突。' ,'新聞' , '毓蓉',cast('2022/06/01' as date) );

insert into ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) values
    ('cat1.jpg','終養不棄養','毛孩飼養數已高過嬰兒出生率，不當棄養情形日漸衍生', '教育', '亭妤', cast('2022/06/08' as date) );

insert into ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) values
    ('cat8.jpg','推動大規模犬貓絕育計畫', '透過推動大規模犬貓絕育行動，並搭配教育推廣及政策倡議，達到遊蕩犬貓族群控制的效果。台灣之心行動足跡遍布全台，深入到動物醫療資源缺乏的偏區及離島，為的就是解決這些地方的犬貓不斷繁殖生育的問題。', '教育','鄭漢', cast('2022/06/10' as date) );

insert into ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) values
    ('cat9.jpg','免費犬貓三合一','新竹縣免費犬貓三合一列車抵達芎林村活動中心，為毛小孩們絕育(結紮)、登記植入晶片及注射狂犬病疫苗', '新聞', '容緯', cast('2022/06/20' as date) );

insert into ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) values
    ('dog5.jpg','離島遊蕩犬絕育計畫奏效!', '2020年8月前往馬祖列島的西莒島進行一個月的「遊蕩母犬駐點絕育任務」（以下簡稱駐紮任務）。在一個月內將島上所有母犬進行捕捉、絕育，最終為15隻遊蕩母犬進行絕育。時隔一年，於2021年底接獲當地志工回報，這一年來，西莒島上已經沒有再增加任何新生幼犬。本次駐紮任務解決了當地長久以來的困擾，此一成果令人相當振奮。', '新聞', '鴻明', cast('2022/06/30' as date) );

insert into ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) values
    ('dog7.jpg','晶片寵登立大功！ 走失米克斯犬找到家', '日前於台中潭子舉辦下鄉犬貓絕育活動時，民眾帶來一隻剛拾獲的母犬，經協會掃描晶片時發現牠原本就有飼主、疑似走失。原飼主接獲通知時欣喜若狂，表示狗狗不見多日，全家非常心急卻遍尋不著，飼主慶幸當初有替寵物植入晶片，才能重新找回毛小孩。協會呼籲，為寵物植入晶片為落實飼主責任不可或缺的動作。','新聞', '奕成', cast('2022/07/15' as date) );

--商品資料

insert into Product_Table ( localfileName, pd_amount, pd_content, pd_items, pd_product_name, pd_quantity, pd_specification) values
 ('1657910934743_6-5.png', 50, '《Daily Delight 爵士貓吧》真愛鮮肉餐主食罐使用新鮮海鮮、雞肉、蔬果，100%人類級食材', '食品', '《爵士貓吧》鮮肉餐主食罐(鰹魚+雞肉+南瓜)80g｜高適口性', 100, '罐頭');
insert into Product_Table ( localfileName, pd_amount, pd_content, pd_items, pd_product_name, pd_quantity, pd_specification) values
 ('1657910988415_羅浮大餐犬罐雞肉起司.jpg', 720, '【產品規格】 ■ 重量：400g ■ 產地：泰國 ■ 適用對象：犬', '食品', '《亞米亞米YAMIYAMI》亞米羅浮大餐(雞肉+起司 )400g│24罐組│', 100, '罐頭');

--訂單資料
insert into Orders ( address, name, orderDate, orderNo, orderStatus, payDate, payType, phone, shipDate, totalPrice, trackingNumber, miNo) values ( '臺北市中正區思源街1號', 'ADMIN魯夫', '2022-07-17 18:10:43.6260000', '202207171810434', '待收貨', '2022-07-17 18:11:27.2920000', 0, 962594416, '2022-07-17 18:13:28.8130000', 770, '123456789', 1);
insert into Orders ( address, name, orderDate, orderNo, orderStatus, payDate, payType, phone, shipDate, totalPrice, trackingNumber, miNo) values ( '臺北市中正區思源街1號', 'ADMIN魯夫', '2022-07-17 18:11:34.9870000', '202207171811343', '待收貨', '2022-07-17 18:11:46.7830000', 1, 962594416, '2022-07-17 18:13:33.2210000', 3900, '456789123', 1);
insert into Orders ( address, name, orderDate, orderNo, orderStatus, payDate, payType, phone, shipDate, totalPrice, trackingNumber, miNo) values ( '臺北市中正區思源街1號', 'ADMIN魯夫', '2022-07-17 18:12:06.8640000', '202207171812063', '待出貨', '2022-07-17 18:12:48.9230000', 0, 962594416, null, 2560, null, 1);
insert into Orders ( address, name, orderDate, orderNo, orderStatus, payDate, payType, phone, shipDate, totalPrice, trackingNumber, miNo) values ( '臺北市中正區思源街1號', 'ADMIN魯夫', '2022-07-17 18:13:03.5250000', '2022071718130318', '待出貨', '2022-07-17 18:13:15.9900000', 1, 962594416, null, 3130, null, 1);

insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 50, 'P1', '《爵士貓吧》鮮肉餐主食罐(鰹魚+雞肉+南瓜)80g｜高適口性', 1, 50, 1);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 720, 'P2', '《亞米亞米YAMIYAMI》亞米羅浮大餐(雞肉+起司 )400g│24罐組│', 1, 720, 1);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 50, 'P1', '《爵士貓吧》鮮肉餐主食罐(鰹魚+雞肉+南瓜)80g｜高適口性', 6, 300, 2);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 720, 'P2', '《亞米亞米YAMIYAMI》亞米羅浮大餐(雞肉+起司 )400g│24罐組│', 5, 3600, 2);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 50, 'P1', '《爵士貓吧》鮮肉餐主食罐(鰹魚+雞肉+南瓜)80g｜高適口性', 8, 400, 3);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 720, 'P2', '《亞米亞米YAMIYAMI》亞米羅浮大餐(雞肉+起司 )400g│24罐組│', 3, 2160, 3);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 50, 'P1', '《爵士貓吧》鮮肉餐主食罐(鰹魚+雞肉+南瓜)80g｜高適口性', 5, 250, 4);
insert into OrderItem ( price, productId, productName, qty, subTotal, orderId) values ( 720, 'P2', '《亞米亞米YAMIYAMI》亞米羅浮大餐(雞肉+起司 )400g│24罐組│', 4, 2880, 4);




INSERT INTO Product_Table ( localfileName, pd_amount, pd_content, pd_items, pd_product_name, pd_quantity, pd_specification) VALUES
 ('1657910988415_羅浮大餐犬罐雞肉起司.jpg', 720, '【產品規格】 ■ 重量：400g ■ 產地：泰國 ■ 適用對象：犬', '食品', '《亞米亞米YAMIYAMI》亞米羅浮大餐(雞肉+起司 )400g│24罐組│', 100, '罐頭');
INSERT INTO Product_Table ( localfileName, pd_amount, pd_content, pd_items, pd_product_name, pd_quantity, pd_specification) VALUES
 ('200739_3_1.jpeg', 157,' ★ 納豆菌維持消化道機能。

 ★ 絲蘭萃取物減少便臭。


★ 有機礦物質鋅幫助毛髮亮麗。
◆ 原物料與成品十大檢驗指標：定期檢驗十大指標，包含物性查核、營養成分、有毒物質、安定性、病原微生物、動物用藥殘留、重金屬、雜質、保存劑、農藥殘留，嚴格要求品質安全，為愛犬健康層層把關。
◆ 經由AAFCO的動物餵食試驗標準，可提供成犬完善、均衡的營養。
◆「圓顆粒」設計：適合台灣一般體型成犬叼咬，幫助增加咀嚼，促進腸胃道消化與吸收。','食品','寶多福美食犬餐牛肉口味包2kg', 200, '包');

--志工活動資料
INSERT INTO Activity_Table ( ac_name, ac_date, ac_participant, ac_venue, ac_quota, ac_waitlist_quota, ac_fee, ac_organizer, type, localFileName) VALUES
('台中市動物保護志工招募', CAST('2022/07/29' AS DATE) , '關心動物保護議題，卻不知如何投入動物保護第一線嗎？台中動保處今年的志工招募活動開跑了!台中的朋友們可別錯過這個機會，服務內容包含推廣動物保護觀念、協助追蹤動保案件，以及照顧、陪伴園區內的犬貓，服務內容為協助動保處進行動物保護宣導活動、動保案件稽查，動物之家園區介紹導覽、照顧園內犬貓、推廣認領養等等。多元的服務內容，能讓大家發揮所長一同為動物盡一份力量！', '408台中市南屯區萬和路一段28-18號', 50, 10, 50, '台中市世界聯合保護動物協會', 0, '可愛貓貓.jpg');
INSERT INTO Activity_Table ( ac_name, ac_date, ac_participant, ac_venue, ac_quota, ac_waitlist_quota, ac_fee, ac_organizer, type, localFileName) VALUES
('家訪志工招募說明會', CAST('2022/7/22' AS DATE) , '#家戶訪查 #志工招募 #全面絕育計畫 春天來臨時，也是狗狗們爭先恐後的來到這個世界上的熱門時間！夥伴們總心想：他們會不會好好地長大呢？未來是不是又會有更多狗狗出生在危機滿滿的街頭上呢？✨全面絕育計畫✨透過大規模的地毯式家戶訪查，把有生育可能性的母犬快速找出來，阻止春後的嬰兒潮。如果您喜歡與人溝通，也想要幫助流浪犬，快來加入我們的尋狗之旅吧！', '43648台中市清水區建國路90號1樓', 50, 10, 50, '社團法人台灣之心愛護動物協會', 0, '逗貓貓.jpg');
INSERT INTO Activity_Table ( ac_name, ac_date, ac_participant, ac_venue, ac_quota, ac_waitlist_quota, ac_fee, ac_organizer, type, localFileName) VALUES
('717帶著毛孩一起FUN幸福', CAST('2022/07/17' AS DATE) , '#活動內容#免費狂犬病疫苗注射/寵物登記(限量100劑/組)#推廣臺北市狗運動公園與狗活動區及動物保護觀念#寵物飾品手作活動(限量60名)#萌寵走秀競賽活動(提供30名飼主報名)----#️本次活動還有邀請到公益大使喔!#️蕭秉治 、周予天 、鄭心慈、夏沐及唐仲彣歡迎毛媽們在假日午後帶著毛小孩一起到活動現場認識臺北市動物友善空間及設施喔!🎵', '紫陽綠地公園', 50, 10, 50, '臺北市九重葛協會', 0, '717帶著毛孩一起FUN幸福.jpg');
INSERT INTO Activity_Table ( ac_name, ac_date, ac_participant, ac_venue, ac_quota, ac_waitlist_quota, ac_fee, ac_organizer, type, localFileName) VALUES
('苗栗場下鄉志工招募說明會', CAST('2022/07/10' AS DATE) , '成為下鄉志工隊的一員，首先需要先參與協會不定期辦理的下鄉志工招募說明會。在說明會中，我們會與您分享台灣流浪犬貓現況、介紹下鄉絕育行動及下鄉志工的工作。參與過下鄉志工招募說明會後，就可以參加下鄉活動囉！下鄉志工隊有專屬的寶藍色志工服，在參與5場下鄉絕育活動後，再參與1場動保講座暨志工提昇班，就可以獲得寶藍色的下鄉志工志工服，成為正式的下鄉志工！', '苗栗縣生態保育教育中心', 50, 10, 50, '苗栗縣動物收容協會', 0, '忠誠狗勾2.jpg');

--動物資料for LineBot
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('貓', '暹羅貓', '母', 'https://i.imgur.com/gHRDOxY.jpg', '花花', '新竹縣竹北市縣政五街192號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('貓', '折耳貓', '公', 'https://i.imgur.com/cGzTPR8.jpg', '餅乾', '新北市八里區長坑里6鄰長坑道路36號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('貓', '布偶貓', '母', 'https://i.imgur.com/Ou7WGms.jpg', '瑪莉', '新北市新店區安泰路235號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('貓', '混種貓', '母', 'https://i.imgur.com/sx8dR0P.jpg', '無', '彰化縣流浪狗中途之家');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('狗', '柴犬', '母', 'https://i.imgur.com/JYkdCH0.jpg', 'Oreo', '基隆市七堵區大華三路45-12號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('狗', '黃金獵犬', '公', 'https://i.imgur.com/FK7F5VD.jpg', '嘟嘟', '嘉義市彌陀路31號旁');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('狗', '貴賓犬', '公', 'https://i.imgur.com/QI0rvj4.jpg', 'Pen', '嘉義縣大林鎮中坑里中興2-6號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('狗', '混種狗', '公', 'https://i.imgur.com/R4nIzrP.jpg', '黃金', '臺北市動物之家');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('鼠', '黃金鼠', '公', 'https://i.imgur.com/rdgnbTb.jpg', 'Vicky', '臺中市南屯區中台路601號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('鼠', '一線鼠', '母', 'https://i.imgur.com/FEGMObW.jpg', '小咪', '新北市新店區安泰路235號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('鼠', '倉鼠', '公', 'https://i.imgur.com/71ONTSJ.jpg', '發財', '臺中市南屯區中台路601號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('兔', '荷蘭兔', '公', 'https://i.imgur.com/AONk0nw.jpg', '飛飛', '新竹縣竹北市縣政五街192號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('兔', '荷蘭侏儒兔', '公', 'https://i.imgur.com/Infk7OE.jpg', '小兵', '新竹縣竹北市縣政五街192號');
INSERT INTO LineAnimalTable (amlType, amlSpecies, amlSex, amlImage, amlName, amlAddress ) VALUES ('兔', '荷蘭兔', '母', 'https://i.imgur.com/oFGGSaa.jpg', '妹妹', '新竹縣竹北市縣政五街192號');


insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '混種貓', '公', 'cat1.jpg', 'admin', '台北市大安收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '緬因貓', '母', 'cat2.jpg', 'admin', '台中市中華收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '金絲貓', '公', 'cat8.jpg', 'admin', '台南市政權收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '折耳貓', '母', 'cat9.jpg', 'admin', '台中市新生路寵物中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);

insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '混種貓', '公', 'cat10.jpg', 'active', '台中市新生路寵物中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '緬因貓', '母', 'cat12.jpg', 'active', '台南市政權收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '金絲貓', '公', 'cat13.jpg', 'active', '台中市中華收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '折耳貓', '母', '1_2.jpg', 'active', '台北市大安收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);



insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '混種貓', '公', 'cat10.jpg', 'active', '台中市新生路寵物中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '緬因貓', '母', 'cat12.jpg', 'active', '台南市政權收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '金絲貓', '公', 'cat13.jpg', 'active', '台中市中華收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '貓', '折耳貓', '母', '1_2.jpg', 'active', '台北市大安收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);

insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '狗', '哈士奇', '公', 'dog3.jpg', 'active', '台中市新生路寵物中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '狗', '米格魯', '母', 'dog4.jpg', 'active', '台南市政權收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '狗', '高山犬', '公', 'dog5.jpg', 'active', '台中市中華收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '狗', '柯基', '母', 'dog7.jpg', 'admin', '台北市大安收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);
insert into abdog_table ( abtype, abvariety, absex, abphonto, abarea, abname, abphone, abemail, abdate, abremark, abaudit) values ( '狗', '混種狗', '母', 'dog11.jpg', 'admin', '台北市大安收養中心',' 0962594416', 'shen775207@gmail.com', '2022-07-17', '有一雙圓圓的眼睛,小小的手掌', 0);

