<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/dashboard.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Gestion d'accès à Youcode - Tableau de board</title>
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

<main>
    <aside class="tabs-sidebar">
        <button class="tabs-btn tabs-btn-active" data-for-tab="1">Tab 1</button>
        <button class="tabs-btn" data-for-tab="2">Tab 2</button>
        <button class="tabs-btn" data-for-tab="3">Tab 3</button>
    </aside>
    <section class="tabs-content tabs-content-active" data-tab="1">
        <table class="content-table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Email</th>
                <th>Télephone</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <c:url var="accept" value="/dashboard/accept">
                    <c:param name="userId" value="${user.idUser}"/>
                </c:url>
                <c:url var="delete" value="/dashboard/delete">
                    <c:param name="userId" value="${user.idUser}"/>
                </c:url>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td class="btns">
                        <a href="${accept}"><ion-icon name="checkmark-done-sharp" class="accept"></ion-icon></a>
                        <a href="${delete}" onclick="if (!(confirm('Voulez-vous vraiment supprimer cet utilisateur?'))) return false"><ion-icon name="trash" class="delete"></ion-icon></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
    <section class="tabs-content" data-tab="2">
        <h2>Tab 2</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Non porro vitae quaerat ad similique
            necessitatibus, quisquam eaque quidem eveniet recusandae repudiandae iusto cupiditate eligendi odit enim
            provident amet ea eius.</p>
    </section>
    <section class="tabs-content" data-tab="3">
        <h2>Tab 3</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Non porro vitae quaerat ad similique
            necessitatibus, quisquam eaque quidem eveniet recusandae repudiandae iusto cupiditate eligendi odit enim
            provident amet ea eius.</p>
    </section>
    <!-- Add Modal HTML -->
    <div id="addRoomModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="insert" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Add User</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>First Name</label>
                            <input type="text" name="first-name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Last Name</label>
                            <input type="text" name="last-name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
<script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
<script src="${pageContext.request.contextPath}/files/js/dashboard.js"></script>
</body>

</html>
