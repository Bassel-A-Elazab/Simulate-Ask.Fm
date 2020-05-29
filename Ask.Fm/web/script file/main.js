//check first name
function validateFName() {
    var fname = document.create_form.fname.value;
    if (fname === "" || fname === null) {
        document.getElementById("name").innerHTML = "You can't leave this empty.";
        return false;
    } else {
        document.getElementById("name").innerHTML = "";
        return true;
    }
}
//check last name
function validateLName() {
    var lname = document.create_form.lname.value;
    if (lname === "" || lname === null) {
        document.getElementById("name").innerHTML = "You can't leave this empty.";
        return false;
    } else {
        document.getElementById("name").innerHTML = "";
        return true;
    }
}
//check your email
function validateEmail() {
    var x = document.create_form.cemail.value;
    var bool;
    var b = x.indexOf('.');
    if (x == null || x == "") {
        document.getElementById("email").innerHTML = "You can't leave this empty.";
        return false;
    } else if (x.length < 6 || x.length > 30) {
        document.getElementById("email").innerHTML = "Please use between 6 and 30 characters.";
        return false;
    } else if (x.charAt(0) == '.') {
        document.getElementById("email").innerHTML = "The first character of your username should be a letter (a-z) or number.";
        return false;
    } else if (x.charAt(x.length - 1) == '.') {
        document.getElementById("email").innerHTML = "The last character of your username should be a letter (a-z) or number.";
        return false;
    } else if (b) {
        if (x.charAt(b) == x.charAt(b + 1)) {
            document.getElementById("email").innerHTML = "A fan of punctuation! Alas, usernames can't have consecutive periods.";
            return false;
        } else {
            for (var i = 0; i < x.length; i++) {
                if ((x.charCodeAt(i) >= 65 && x.charCodeAt(i) <= 90) || (x.charCodeAt(i) >= 48 && x.charCodeAt(i) <= 57) || (x.charCodeAt(i) >= 97 && x.charCodeAt(i) <= 122) || x.charCodeAt(i) == 46) {
                    continue;
                } else {
                    bool = "true";
                    break;
                }
            }
            if (bool == "true") {
                document.getElementById("email").innerHTML = "Please use only letters (a-z), numbers, and periods.";
                return false;
            } else {
                document.getElementById("email").innerHTML = "";
                return true;
            }

        }

    }
}
//check password
function validatePass1() {
    var pass1 = document.create_form.pass1.value;
    if (pass1.length < 6) {
        document.getElementById("pass1").innerHTML = "Password must be at least 6 characters long.";
        return false;
    } else {
        document.getElementById("pass1").innerHTML = "";
        return true;
    }
}
//check re-enter password
function validatePass2() {
    var pass1 = document.create_form.pass1.value;
    var pass2 = document.create_form.pass2.value;
    if (pass1 != pass2 || pass2 === null || pass2 === "") {
        document.getElementById("pass2").innerHTML = "These passwords don't match. Try again?";
        return false;
    } else {
        document.getElementById("pass2").innerHTML = "";
        return true;
    }
}
function validateInput() {
    var isFormValid = true;
    isFormValid &= validateFName();
    isFormValid &= validateLName();
    isFormValid &= validateEmail();
    isFormValid &= validatePass1();
    isFormValid &= validatePass2();
    return isFormValid ? true : false;
}

function focusFName() {
    document.getElementById("name").innerHTML = "";
}
function focusLName() {
    document.getElementById("name").innerHTML = "";
}

function focusEmail() {
    document.getElementById("email").innerHTML = "";
}

function focusPass1() {
    document.getElementById("pass1").innerHTML = "";
}

function focusPass2() {
    document.getElementById("pass2").innerHTML = "";
}
function load() {
    var xhttp;
    var name = document.getElementById("cemail").value;
    urls = "checkEmail.jsp?cemail=" + name;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", urls, true);
    xhttp.send();
}
function return_checkEmail() {
    var x = document.getElementById("actual").value;
    if (x == "exsist") {
        return false;
    } else {
        return true;
    }
}

/*
function LoadPost() {
    var xhttp;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("loadpost").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", "getposts.jsp", true);
    xhttp.send();
}


function SetPost() {
    var xhttp;
    var getpostFromHtml = document.getElementById("getPost").value;
    var url = "setpost.jsp?setpost=" + getpostFromHtml;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("setpost").innerHTML = this.responseText;
            LoadPost();
        }
    };
    xhttp.open("POST", url, true);
    xhttp.send();
}
*/

//////////////////////////////////





