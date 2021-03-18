<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/contact.css">
    <title>Gestion d'accès à Youcode - Contact Us</title>
</head>

<body>
<header>
    <nav>
        <ul>
            <li><a href="#">À propos</a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/files/img/logo.png" alt="logo" class="logo"></a></li>
            <li><a href="#">Contactez nous</a></li>
        </ul>
    </nav>
</header>
<main>x
    <section>
        <form action="" method="get" class="form-signin">
            <h2 class="form-title">Contactez nous</h2>
            <p class="form-desc">Envoyez-nous un message et nous vous répondrons dès que possible</p>
            <div class="form-group">
                <input type="text" name="f-name" placeholder="Nom Complet" class="input">
            </div>
            <div class="form-group">
                <input type="text" name="email" placeholder="Email" class="input">
            </div>
            <div class="form-group">
                <textarea style="resize: none;" name="message" class="input" cols="30" rows="4" placeholder="Votre message"></textarea>
            </div>
            <input type="submit" value="Submit" class="submit-btn">
        </form>
        <div class="global-img">
            <img src="${pageContext.request.contextPath}/files/img/contact-us.svg" alt="">
        </div>
    </section>
</main>
</body>

</html>