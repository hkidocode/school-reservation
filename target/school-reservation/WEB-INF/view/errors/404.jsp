<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/404.css">
    <title>Page Not Found</title>
</head>

<body>
<header>
    <nav>
        <ul>
            <li><a href="#"><img src="${pageContext.request.contextPath}/files/img/logo.png" alt="logo" class="logo"></a></li>
            <li>
                <div class="flex">
                    <a href="#addRoomModal" data-toggle="modal" class="add-rsv">Ajouter un room</a>
                    <a href="#" class="link">Déconnexion</a>
                </div>
            </li>
        </ul>
    </nav>
</header>
<div class="picture">
    <img src="${pageContext.request.contextPath}/files/img/404.svg" alt="404 error">
</div>
<p class="ln1">Ooops!!</p>
<p class="ln2">Page not found</p>
<p class="ln3">La page que vous recherchez a peut-être été supprimée, son formulaire de changement de nom est temporairement indisponible.</p>
</body>
</html>
