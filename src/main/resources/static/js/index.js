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

const checkUser = form.elements["role1"];
const checkMerchant = form.elements["role2"];
const merchantField = form.elements["merchant-field"];
const submit = form.elements["submit-btn"];
const merchantSection = document.querySelector(".merchant-section");


checkUser.addEventListener("change", () => {
    submit.removeAttribute("disabled");
    //merchantField.style.display = "none";
    merchantSection.style.display = "none";
});

checkMerchant.addEventListener("change", () => {
    // merchantField.style.display = "block";
    merchantSection.style.display = "block";
    submit.removeAttribute("disabled");
});