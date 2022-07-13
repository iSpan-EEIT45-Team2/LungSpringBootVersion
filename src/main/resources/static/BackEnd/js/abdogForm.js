const form = document.getElementById("form");
const form_button_submit = document.getElementById('form_button_submit');
const Click1 = document.getElementById('Click1');

const ab_type = document.getElementById('ab_type');
const ab_variety = document.getElementById('ab_variety');
const ab_sex = document.getElementById('ab_sex');
const ab_phonto = document.getElementById('ab_phonto');
const ab_area = document.getElementById('ab_area');
const ab_name = document.getElementById('ab_name');
const ab_phone = document.getElementById('ab_phone');
const ab_email = document.getElementById('ab_email');
const ab_date = document.getElementById('ab_date');
const ab_remark = document.getElementById('ab_remark');
const ab_audit = document.getElementById('ab_audit');
const ab_remark = document.getElementById('ab_remark');


// trim to remove the whitespaces

/*一鍵輸入*/
Click1.addEventListener('click', e => {
	e.preventDefault();
	Click();
});

 /* 執行一鍵輸入*/
function Click(){
	/* 取消變顏色*/
	let errorNodes = document.getElementsByClassName('form-group error');
	let successNodes = document.getElementsByClassName('form-group success');
	for(let i = 0 ; i<errorNodes.length ; i++){
		errorNodes[i].className = 'form-group'
	}
	for(let i = 0 ; i<successNodes.length ; i++){
		successNodes[i].className = 'form-group'
	}
	/*塞入值到input框*/
	// mi_account.value = randomAccount();
	// mi_password.value = randomPassword();
	// mi_name.value = randomName();
	// mi_id.value = randomId();
	ab_area.value = '基隆市';
	ab_name.value = '基隆市福樂寵物收容所';
	ab_phone.value = '0987993557';
	ab_email.value = 'email@mail.com';
	// for (let i = 0; i < 50000000000; i++) {}
	ab_date.value = randomBirth();
	ab_remark.value = '喜歡吃雞胸肉,普通的飼料拒絕';
	
	/* 重新把success加上去 */
	let nodes = document.getElementsByClassName('form-group');
	for(let i = 0 ; i<nodes.length ; i++){
		nodes[i].className = 'form-group success'
	}
	
}
 
 /*產生隨機帳號*/
 function randomAccount(){
	let code="";
	let codeLength = Math.floor(Math.random()*6)+8;//隨機產生驗證碼的長度0-5碼再加8 -> 產生8-13碼	
	let random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//隨機數 
	for(let i = 0; i < codeLength; i++  ) {//迴圈操作 
		let index = Math.floor(Math.random()*36);//取得隨機數的索引（0~35） 
		code  += random[index];//根據索引取得隨機數加到code上 
	} 
	return code;
}

/*產生隨機帳號*/
function randomPassword(){
	let code="";
	let codeLength = Math.floor(Math.random()*6)+5;//隨機產生驗證碼的長度0-5碼再加8 -> 產生5-10碼
	let randomNumber = '0123456789';
	let randomLower = 'abcdefghijklmnopqrstuvwxyz';
	let randomUpper = randomLower.toUpperCase();
	let randomAll = randomNumber + randomLower + randomUpper;

	let resultNumber = randomNumber[Math.floor(Math.random()*10)]; //randomNumber[index]
	let resultLower = randomLower[Math.floor(Math.random()*26)];  //randomLower[index]
	let resultUpper = randomUpper[Math.floor(Math.random()*26)];  //randomUpper[index]

	for(let i = 0; i < codeLength; i++  ) {//迴圈操作
		code  += randomAll[Math.floor(Math.random()*62)]; //隨機從62位數中取得 //根據索引取得隨機數加到code上
	}
	code += resultNumber + resultLower + resultUpper;
	return code;
}


/*產生隨機姓名*/
function randomName(){
	let familyNames = new Array(
	"沈", "陳",  "林", "許", "張" , "蔡", "李", "黃", "吳", "蔡",
	"鄭", "楊", "劉" , "郭", "許", "洪", "邱", "曾", "周", "謝"
	);
	
	let givenNames = new Array(
	"家豪", "志明", "俊傑", "冠宇", "承翰", "志偉", "志成", "國華", "冠霖", "宇翔",
	 "淑娟", "淑芬", "美玲", "雅婷", "美惠", "麗華", "怡君", "美玉", "麗美", "秀玲"
	);
	let i = Math.floor(Math.random()*12); //隨機在0-12中選一個數
	let familyName = familyNames[i];
	let givenName = givenNames[i];
	let name = familyName + givenName;
	return name
}

/*隨機產生身分證*/
function randomId(){
	let city = new Array(
         1,10,19,28,37,46,55,64,39,73,82, 2,11,
        20,48,29,38,47,56,65,74,83,21, 3,12,30
    )
    //建立隨機身份證碼
    let id = new Array();
    id[0] = String.fromCharCode(Math.floor(Math.random() * (26)) + 65);
    id[1] = Math.floor(Math.random() * (2)) + 1;
    for(let i=2; i<9; i++){
        id[i] = Math.floor(Math.random() * (9)) + 0;
    }
    //計算總分
    let total = city[id[0].charCodeAt(0)-65];
    for(let i=1; i<=8; i++){
        total += eval(id[i]) * (9 - i);
    }
    //計算最尾碼
    let total_arr = (total+'').split('');
    let lastChar = eval(10-total_arr[total_arr.length-1]);
    let lastChar_arr = (lastChar+'').split('');
    //補上最後檢查碼
    id[id.length++] = lastChar_arr[lastChar_arr.length-1];
    //回傳結果
    return id.join('');
}

/*隨機產生生日*/
function randomBirth(){
	let code="";
	// 年
	let randomYear = new Array('1971','1973','1975','1977','1979','1981','1983','1985','1987','1989',
		'1991','1993','1995','1997','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008',
		'2009','2010','2011','2012','2013','2014','2015','2016','2017','2018','2019','2020');//隨機月份
	let indexYear = Math.floor(Math.random()*35);//陣列中有35個數 //取得隨機數的索引（0-34）
	code  += randomYear[indexYear];//根據索引取得隨機數加到code上
	// 月
	let randomMonth = new Array('01','02','03','04','05','06','07','08','09','10','11','12');//隨機月份
	let indexMonth = Math.floor(Math.random()*12);//取得隨機數的索引（0-11）
	code  += ("-" + randomMonth[indexMonth]);//根據索引取得隨機數加到code上
	// 日
	let randomDay = new Array('01','02','03','04','05','06','07','08','09','10','11','12',
		'13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31');//隨機日期
	let indexDay = Math.floor(Math.random()*31);//取得隨機數的索引（0-30）
	code  += ( "-" + randomDay[indexDay]);//根據索引取得隨機數加到code上

	return code;
}


/* 只有ADMIN權限的人可以新增/修改他人成為ADMIN */
// document.querySelectorAll("#type option").forEach(opt => {
//
// 	if (opt.value == "ADMIN") {
// 		opt.disabled = true;
// 	}
// });


//返回會員系統
// function back(){
//  		history.back()
// 	}
