--新增會員資料

-- DELETE FROM MemberTable WHERE miAccount = 'admin';
-- DELETE FROM MemberTable WHERE miAccount = 'employee';
-- DELETE FROM MemberTable WHERE miAccount = 'active';
-- DELETE FROM MemberTable WHERE miAccount = 'user';

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) values
    ('ADMIN魯夫','C248835717',cast('1999/01/23' as date),'0962594416','abc10@mail.com','admin','$2a$10$0zynuTZo0/NVJlTz5WFAHeRU0EuoUWuCrCSXbUiJv.GPBbcrvUE3y','USER;ACTIVE;EMPLOYEE;ADMIN', '女', 'Y', '臺北市', '中正區', '思源街1號' );

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) values
    ('EMPLOYEE娜美','O241686379',cast('1987/12/01' as date),'0926287495','abc20@mail.com','employee','$2a$10$CC006YClBxiYQDhfiIKsyeDgruLWMTQjURSSXAzudRtbuzNidLWMC','USER;ACTIVE;EMPLOYEE', '男', 'Y', '台南市', '安平區', '漁光路114號' );

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) values
    ('ACTIVE喬巴','X181771234',cast('2005/03/16' as date),'0930152563','abc30@mail.com','active','$2a$10$aBcQul7PMtaZLRanssTeO3r2n3sIy1S9YkUyWdPFbDB3iYc7XX6','USER;ACTIVE', '男', 'Y', '屏東縣', '恆春鎮', '大光路79號' );

insert into MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) values
    ('USER香吉士','W143802241',cast('1996/06/30' as date),'0956410662','abc40@mail.com','user','$2a$10$Zy.cMMbYSb6x0PS5WYVDwOEokd0bMkAjpw/W9jyBmIuijkAulJ6Ee','USER', '不公開', 'Y', '花蓮縣', '壽豐鄉', '189號');

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




