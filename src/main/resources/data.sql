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
    ('USER香吉士','W143802241',CAST('1996/06/30' AS DATE),'0956410662','abc40@mail.com','user','$2a$10$Zy.cMMbYSb6x0PS5WYVDwOEokd0bMkAjpw/W9jyBmIuijkAulJ6Ee','USER', '女', 'Y', '花蓮縣', '壽豐鄉', '189號');
