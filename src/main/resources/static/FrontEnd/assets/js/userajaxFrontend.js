    /*--------------------START前台首頁navbar會員頭貼下的三個btn-------------------*/
    document.getElementById('navbarHeadshot').addEventListener('mouseover', function () {
        let navbarLoginBtn = document.getElementById("navbarLoginBtn");
        let navbarMemberCenterBtn = document.getElementById("navbarMemberCenterBtn");
        let navbarLogoutBtn = document.getElementById("navbarLogoutBtn");

        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                if (xhr.responseText === "Y") { // user有login
                    navbarLoginBtn.style.display = 'none';
                    navbarMemberCenterBtn.style.display = '';
                    navbarLogoutBtn.style.display = '';
                } else {  // user沒有login
                    navbarLoginBtn.style.display = '';
                    navbarMemberCenterBtn.style.display = 'none';
                    navbarLogoutBtn.style.display = 'none';
                }
            }
        };
        xhr.open("GET", "/Lung/memberInfo/checkUserLogin", true);
        xhr.send();
    });
    /*--------------------END前台首頁navbar會員頭貼下的三個btn-------------------*/














