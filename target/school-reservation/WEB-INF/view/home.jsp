<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<%--    <link href="${pageContext.request.contextPath}/files/css/style.css" rel="stylesheet" type="text/css">--%>
    <title>Gestion d'accès à Youcode - Home</title>
</head>

<body>
<header>
    <nav>
        <ul>
            <li><a href="#">À propos</a></li>
            <li><a href="#"><img src="<c:url value="/files/img/logo.png"/>" alt="logo" class="logo"></a></li>
            <li><a href="#">Contactez nous</a></li>
        </ul>
    </nav>
</header>
<main>
    <div class="heading-container">
        <h1>Pour une meilleure gestion des accès et maintenir des mesures préventives!</h1>
    </div>
    <div class="body-container">
        <div class="global-img">
<%--            <img src="${pageContext.request.contextPath}/files/img/booking.svg" alt="booking Image">--%>
        </div>
        <form action="" method="post" class="form-signin" id="signin">
            <h2 class="form-title">Content de te revoir.</h2>
            <div class="form-message form-message-error" hidden>Email/Mot de passe incorrecte.</div>
            <div class="form-group">
                <input type="text" name="email" placeholder="Email" class="input" autofocus>
                <div class="form-input-error-message"></div>
            </div>
            <div class="form-group">
                <input type="password" name="password" class="input" placeholder="Mot de passe">
                <div class="form-input-error-message"></div>
            </div>
            <input type="submit" value="Sign in" class="submit-btn">
            <a href="" class="google-sign-in">
                <ion-icon name="logo-google"></ion-icon> Sign in avec Google
            </a>
            <p class="form-text">
                <a href="#" class="form-link">Mot de pass oublié?</a>
            </p>
            <p class="form-text">
                <a href="" id="linkCreateAccount" class="form-link">Vous n'avez pas de compte? Créer un compte</a>
            </p>
        </form>
        <form method="post" class="form-signin form-hidden" id="createAccount">
            <h2 class="form-title">Créer une compte</h2>
            <div class="form-message form-message-error" hidden>Email/Mot de passe incorrecte.</div>
            <div class="form-group">
                <input type="text" name="f-name" placeholder="Nom Complet" class="input">
                <div class="form-input-error-message"></div>
            </div>
            <div class="form-group">
                <input type="tel" name="phone" placeholder="Numéro de télephone" class="input">
                <div class="form-input-error-message"></div>
            </div>
            <div class="form-group">
                <input type="email" name="email" placeholder="Email" class="input">
                <div class="form-input-error-message"></div>
            </div>
            <div class="form-group">
                <input type="password" name="password" class="input" placeholder="Mot de passe">
                <div class="form-input-error-message"></div>
            </div>
<%--            <div class="form-group">--%>
<%--                <input type="password" name="pass-confirm" class="input" placeholder="Confirmer mot de passe">--%>
<%--                <div class="form-input-error-message"></div>--%>
<%--            </div>--%>
            <input type="submit" value="Sign up" class="submit-btn">
            <a href="" class="google-sign-in">
                <ion-icon name="logo-google"></ion-icon> Sign up avec Google
            </a>
            <p class="form-text">
                <a href="" id="linkLogin" class="form-link">Vous avez déjà un compte? Se connecter</a>
            </p>
        </form>
    </div>
</main>
<script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
<script>
    const loginForm = document.querySelector('#signin');
    const signupForm = document.querySelector('#createAccount');
    const fullName = signupForm.querySelector("input[name='f-name']");
    const phone = signupForm.querySelector("input[name='phone']");
    const email = signupForm.querySelector("input[name='email']");
    const password = signupForm.querySelector("input[name='password']");
    const confirmPassword = document.querySelector("input[name='pass-confirm']");

    document.addEventListener('DOMContentLoaded', () => {

        document.querySelector("#linkCreateAccount").addEventListener('click', (e) => {
            e.preventDefault();
            loginForm.classList.add('form-hidden');
            signupForm.classList.remove('form-hidden');
        });
        document.querySelector("#linkLogin").addEventListener('click', (e) => {
            e.preventDefault();
            loginForm.classList.remove('form-hidden');
            signupForm.classList.add('form-hidden')
        });

    });

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

    fullName.addEventListener('change', function () {
        isValidName(this);
    });
    phone.addEventListener('change', function () {
        isValidPhoneNumber(this);
    });
    email.addEventListener('change', function () {
        isValidEmail(this);
    });
    password.addEventListener('change', function () {
        isValidPassword(this);
    });

    signupForm.addEventListener('submit', e => {

        // confirmPassword.addEventListener('blur', function () {
        //     isConfirmedPassword(password, this);
        // });



        if (isValidName(fullName) === false || isValidPhoneNumber(phone) === false || isValidEmail(email) === false
            || isValidPassword(password) === false) {
            e.preventDefault();
        }

    });
</script>
</body>

</html>