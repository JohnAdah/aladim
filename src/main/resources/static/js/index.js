const menuBtn = document.querySelector(".menu-icon span");
const searchBtn = document.querySelector(".search-icon");
const cancelBtn = document.querySelector(".cancel-icon");
const items = document.querySelector(".nav-items");
const form = document.querySelector("form");

menuBtn.onclick = ()=>{
    items.classList.add("active");
    menuBtn.classList.add("hide");
    searchBtn.classList.add("hide");
    cancelBtn.classList.add("show");
}


cancelBtn.onclick = ()=>{
    items.classList.remove("active");
    menuBtn.classList.remove("hide");
    searchBtn.classList.remove("hide");
    cancelBtn.classList.remove("show");
    form.classList.remove("active");
    cancelBtn.style.color = "#ff3d00";
}

searchBtn.onclick = ()=>{
    form.classList.add("active");
    searchBtn.classList.add("hide");
    cancelBtn.classList.add("show");
}

 var fname = document.getElementById("firstName");
var lname = document.getElementById("lastName");
var  uname = document.getElementById("userName");
var pword = document.getElementById("password");
var address1 = document.getElementById("addressLine1");
var address2 = document.getElementById("addressLine2");
var lga = document.getElementById("localGovArea");
var city = document.getElementById("city");
var soc = document.getElementById("stateOfCity");
var country = document.getElementById("country");
var postCode = document.getElementById("postalCode");
var emaill = document.getElementById("email");
var pnum = document.getElementById("phoneNumber");
var idNum = document.getElementById("idNumber");
var emptyError = document.getElementById("emptyError")

function validate(){
    if(fname.value.trim() == "" || lname.value.trim() == "" || uname.value.trim() == "" || pword.value.trim() == ""
    || address1.value.trim() || address2.value.trim() == "" || lga.value.trim() == "" || city.value.trim() ==""
    || soc.value.trim() == "" || country.value.trim() == ""|| postCode.value.trim() == "" || emaill.value.trim() ==""
    || pnum.value.trim() == ""|| idNum.value.trim() == ""){
        emptyError.style.visibility = "visible";
        if(pword.value.trim().length < 6){
            document.getElementById("pwordError").style.visibility = "visible";
        }
        if(pnum.value.trim().length != 11){
            document.getElementById("pnumError").style.visibility = "visible";
        }
    }else{
        return true;
    }
}