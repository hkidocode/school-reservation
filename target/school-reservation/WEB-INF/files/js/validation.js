const signupForm = document.querySelector('#createAccount');
const fullName = signupForm.querySelector("input[name='f-name']");
const phone = signupForm.querySelector("input[name='phone']");
const email = signupForm.querySelector("input[name='email']");
const password = signupForm.querySelector("input[name='password']");
const confirmPassword = document.querySelector("input[name='pass-confirm']");

console.log("Yeep");

// Check full name if contains letters in a-z in lowercase
function isValidName(fullName) {
    const regex = /^[a-zA-Z ]+$/;
    if (!regex.test(fullName.value)) {
        setErrorFor(fullName, "Enter a valid name");
        return false;
    } else {
        removeErrorFor(fullName);
        return true;
    }
}

// Check email adress
function isValidEmail(email) {
    const regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regex.test(email.value)) {
        setErrorFor(email, "Enter a valid email");
        return false;
    } else {
        removeErrorFor(email);
        return true;
    }
}

// Check phone number
function isValidPhoneNumber(phone) {
    const regex = /(\+212|0)([ \-_/]*)(\d[ \-_/]*){9}/;
    if (!regex.test(phone.value)) {
        setErrorFor(phone, "Enter a valid phone number");
        return false;
    } else {
        removeErrorFor(phone);
        return true;
    }
}

// Check password
function isValidPassword(password) {
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,30}$/;
    if (!regex.test(password.value)) {
        setErrorFor(password, `Enter 6 to 30 characters:<br>1.at least one numeric digit<br>2.one uppercase and one lowercase`);
        return false;
    } else {
        removeErrorFor(password);
        return true;
    }
}

// Check password and confirm password are matched
function isConfirmedPassword(password, confirmPassword) {
    if(password.value !== confirmPassword.value) {
        setErrorFor(password, `Passwords doesn't match`);
        setErrorFor(confirmPassword, `Passwords doesn't match`);
        return false;
    } else {
        removeErrorFor(password);
        removeErrorFor(confirmPassword);
        return true;
    }
}

// Display error message if the input does not match the existing regular expression
function setErrorFor(input, message) {
    input.classList.add('input-error');
    const errorMsg = input.nextElementSibling;
    errorMsg.innerHTML = message;
}

// Remove error message if the input does not match the existing regular expression
function removeErrorFor(input) {
    input.classList.remove('input-error');
    const errorMsg = input.nextElementSibling;
    errorMsg.innerHTML = "";
}

signupForm.addEventListener('submit', e => {
    fullName.addEventListener('blur', function () {
        isValidName(this);
    });
    phone.addEventListener('blur', function () {
        isValidPhoneNumber(this);
    });
    email.addEventListener('blur', function () {
        isValidEmail(this);
    });
    password.addEventListener('blur', function () {
        isValidPassword(this);
    });
    // confirmPassword.addEventListener('blur', function () {
    //     isConfirmedPassword(password, this);
    // });



    if (isValidName(fullName) === false || isValidPhoneNumber(phone) === false || isValidEmail(email) === false
        || isValidPassword(password) === false) {
        e.preventDefault();
    }

});