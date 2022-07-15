window.onload = function(){
    /*--------------------START後台首頁navbar的USER姓名-------------------*/
    let navbarMiName = document.getElementById("navbarMiName");  // 首頁顯示的姓名
    let navbarMiName1 = document.getElementById("navbarMiName1");  // 大頭貼位置下拉選單的姓名
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        // alert(xhr.responseText + ", readyState=" + xhr.readyState);
        if (xhr.readyState === 4 && xhr.status === 200) {
            navbarMiName.innerHTML = xhr.responseText ;
            navbarMiName1.innerHTML = xhr.responseText ;
        }
    }
    xhr.open("GET", "/Lung/memberInfo/getCurrentUserMiNameString", true);
    xhr.send();
    /*--------------------END後台首頁navbar的USER姓名-------------------*/


}
