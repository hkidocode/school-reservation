<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link href="${pageContext.request.contextPath}/files/css/home.css" rel="stylesheet">
    <title>Gestion d'accès à Youcode - Home</title>
</head>

<body>
<header>
    <nav>
        <ul>
            <li><a href="contact.jsp">À propos</a></li>
            <li><a href="${pageContext.request.contextPath}/signin"><img src="${pageContext.request.contextPath}/files/img/logo.png" alt="logo" class="logo"></a></li>
            <li><a href="${pageContext.request.contextPath}/contact">Contactez nous</a></li>
        </ul>
    </nav>
</header>
<main>
    <div class="heading-container">
        <h1>Pour une meilleure gestion des accès et maintenir des mesures préventives!</h1>
    </div>
    <div class="body-container">
        <div class="global-img">
            <img src="${pageContext.request.contextPath}/files/img/booking.svg" alt="booking Image">
        </div>
        <form action="${pageContext.request.contextPath}/register/processRegister" method="post" class="form-signin" id="createAccount">
            <h2 class="form-title">Créer une compte</h2>
            <!-- Check for registration error -->
            <c:if test="${registrationError != null}">
                <div class="form-message form-message-error">${registrationError}</div>
            </c:if>
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
                <a href="${pageContext.request.contextPath}/signin" class="form-link">Vous avez déjà un compte? Se connecter</a>
            </p>
        </form>
    </div>
</main>
<script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
<script src="${pageContext.request.contextPath}/files/js/validation.js"></script>
</body>

</html>