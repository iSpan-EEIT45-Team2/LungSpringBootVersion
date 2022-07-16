window.onload = function() {
    //先不show取消按鈕
    let account_form_cancel = document.getElementById('account_form_cancel');
    account_form_cancel.style.display = 'none';

    /*--------------------START塞value到會員表單中-------------------*/
    let miName = document.getElementById('miName');
    let miAccount = document.getElementById('miAccount');
    let miGender = document.getElementById('miGender');
    let miBirth = document.getElementById('miBirth');
    let miId = document.getElementById('miId');
    let miPhone = document.getElementById('miPhone');
    let miEmail = document.getElementById('miEmail');
    let miCity = document.getElementById('miCity');
    let miDistrict = document.getElementById('miDistrict');
    let miAddress = document.getElementById('miAddress');

        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let result = JSON.parse(xhr.responseText);
                console.log(result);
                miName.value = result.miName;
                miAccount.value = result.miAccount;
                miGender.value = result.miGender;
                miBirth.value = result.miBirth;
                miId.value = result.miId;
                miPhone.value = result.miPhone;
                miEmail.value = result.miEmail;
                miCity.value = result.miCity;
                miDistrict.value = result.miDistrict;
                miAddress.value = result.miAddress;

            }
        };
        xhr.open("GET", "/Lung/Front/getMemberforUpdate", false);
        xhr.send();

    /*--------------------END塞value到會員表單中-------------------*/

}





document.getElementById('account_form_button').addEventListener('click', function () {
    document.getElementById('miName').disabled = false;
    document.getElementById('miAccount').disabled = false;
    document.getElementById('miGender').disabled = false;
    document.getElementById('miBirth').disabled = false;
    document.getElementById('miId').disabled = false;
    document.getElementById('miPhone').disabled = false;
    document.getElementById('miEmail').disabled = false;
    document.getElementById('miCity').disabled = false;
    document.getElementById('miDistrict').disabled = false;
    document.getElementById('miAddress').disabled = false;

    document.getElementById('account_form_button').innerText = "儲存";

    let account_form_cancel = document.getElementById('account_form_cancel');
    account_form_cancel.style.display = '';

});
