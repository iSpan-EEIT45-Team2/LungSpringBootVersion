--新增會員資料

-- DELETE FROM MemberTable WHERE miAccount = 'admin';
-- DELETE FROM MemberTable WHERE miAccount = 'employee';
-- DELETE FROM MemberTable WHERE miAccount = 'active';
-- DELETE FROM MemberTable WHERE miAccount = 'user';

INSERT INTO MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) VALUES
    ('ADMIN魯夫','C248835717',CAST('1999/01/23' AS DATE),'0962594416','abc10@mail.com','admin','$2a$10$0zynuTZo0/NVJlTz5WFAHeRU0EuoUWuCrCSXbUiJv.GPBbcrvUE3y','USER;ACTIVE;EMPLOYEE;ADMIN', '女', 'Y', '臺北市', '中正區', '思源街1號' );

INSERT INTO MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) VALUES
    ('EMPLOYEE娜美','O241686379',CAST('1987/12/01' AS DATE),'0926287495','abc20@mail.com','employee','$2a$10$CC006YClBxiYQDhfiIKsyeDgruLWMTQjURSSXAzudRtbuzNidLWMC','USER;ACTIVE;EMPLOYEE', '男', 'Y', '台南市', '安平區', '漁光路114號' );

INSERT INTO MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) VALUES
    ('ACTIVE喬巴','X181771234',CAST('2005/03/16' AS DATE),'0930152563','abc30@mail.com','active','$2a$10$aBcQul7PMtaZLRanssgOTeO3r2n3sIy1S9YkUyWdPFbDB3iYc7XX6','USER;ACTIVE', '男', 'Y', '屏東縣', '恆春鎮', '大光路79號' );

INSERT INTO MemberTable ( miName, miId, miBirth, miPhone, miEmail, miAccount, miPassword, miRole, miGender, miActive, miCity, miDistrict, miAddress) VALUES
    ('USER香吉士','W143802241',CAST('1996/06/30' AS DATE),'0956410662','abc40@mail.com','user','$2a$10$Zy.cMMbYSb6x0PS5WYVDwOEokd0bMkAjpw/W9jyBmIuijkAulJ6Ee','USER', '不公開', 'Y', '花蓮縣', '壽豐鄉', '189號');

--新增公告資料
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';
-- DELETE FROM ANNOUNCE_Table WHERE anNo = '';

INSERT INTO ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate ) VALUES
    ('dog3.jpg','浪犬入侵騷擾遊客頻傳,花蓮婦幼親創園區架驅狗器' , '花蓮婦幼親創園區於去底揭牌啟用後，由於鄰近環境多有草叢林木容易有遊蕩犬隻出沒，縣府農業處及社會處合作，在圍牆旁設置了10支驅狗器，避免因為遊蕩犬而導致人犬衝突。' ,'新聞' , '毓蓉',CAST('2022/06/01' AS DATE) );

INSERT INTO ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) VALUES
    ('cat1.jpg','終養不棄養','毛孩飼養數已高過嬰兒出生率，不當棄養情形日漸衍生', '教育', '亭妤', CAST('2022/06/08' AS DATE) );

INSERT INTO ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) VALUES
    ('cat8.jpg','推動大規模犬貓絕育計畫', '透過推動大規模犬貓絕育行動，並搭配教育推廣及政策倡議，達到遊蕩犬貓族群控制的效果。台灣之心行動足跡遍布全台，深入到動物醫療資源缺乏的偏區及離島，為的就是解決這些地方的犬貓不斷繁殖生育的問題。', '教育','鄭漢', CAST('2022/06/10' AS DATE) );

INSERT INTO ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) VALUES
    ('cat9.jpg','免費犬貓三合一','新竹縣免費犬貓三合一列車抵達芎林村活動中心，為毛小孩們絕育(結紮)、登記植入晶片及注射狂犬病疫苗', '新聞', '容緯', CAST('2022/06/20' AS DATE) );

-- INSERT INTO ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) VALUES
--     ('dog5.jpg','離島遊蕩犬絕育計畫奏效!', '2020年8月前往馬祖列島的西莒島進行一個月的「遊蕩母犬駐點絕育任務」（以下簡稱駐紮任務）。在一個月內將島上所有母犬進行捕捉、絕育，最終為15隻遊蕩母犬進行絕育。時隔一年，於2021年底接獲當地志工回報，這一年來，西莒島上已經沒有再增加任何新生幼犬。本次駐紮任務解決了當地長久以來的困擾，此一成果令人相當振奮。', '新聞', '鴻明', CAST('2022/06/30' AS DATE) );

INSERT INTO ANNOUNCE_Table ( anPhoto,anTitle, anContent, anType, anEditor, anDate) VALUES
    ('dog7.jpg','晶片寵登立大功！ 走失米克斯犬找到家', '日前於台中潭子舉辦下鄉犬貓絕育活動時，民眾帶來一隻剛拾獲的母犬，經協會掃描晶片時發現牠原本就有飼主、疑似走失。原飼主接獲通知時欣喜若狂，表示狗狗不見多日，全家非常心急卻遍尋不著，飼主慶幸當初有替寵物植入晶片，才能重新找回毛小孩。協會呼籲，為寵物植入晶片為落實飼主責任不可或缺的動作。','新聞', '奕成', CAST('2022/07/15' AS DATE) );

