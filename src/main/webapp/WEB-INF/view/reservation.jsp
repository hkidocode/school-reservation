<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/reservation.css">
    <title>Gestion d'accès à Youcode - Réservation Panel</title>
</head>

<body>
<header>
    <nav>
        <ul>
            <li><a href="#"><img src="${pageContext.request.contextPath}/files/img/logo.png" alt="logo" class="logo"></a></li>
            <li>
                <div class="flex">
                    <a href="#addReservationModal" data-toggle="modal" class="add-rsv">Ajouter une réservation</a>
                    <a href="#" class="link">Déconnexion</a>
                </div>
            </li>
        </ul>
    </nav>
</header>
<main>
    <section class="rsv-historique">
        <c:if test="${textMessage.equals('Les réservations ne sont pas encore ouvertes.')}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                Les réservations ne sont pas encore ouvertes.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${textMessage.equals('La date choisie est dépassé ou encore indisponible!')}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                La date choisie est dépassé ou encore indisponible!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${textMessage.equals('Vous avez passer la limite de présence par semaine!')}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Vous avez passer la limite de présence par semaine!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${textMessage.equals('Vous avez déja réserver cette journée!')}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Vous avez déja réserver cette journée!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${textMessage.equals('Les réservations sont saturés!')}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Les réservations sont saturés!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${textMessage.equals('Réservation réussie.')}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Réservation réussie.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <aside class="tabs-sidebar">
            <button class="tabs-btn tabs-btn-active btn-1" data-for-tab="1">Tous</button>
            <button class="tabs-btn" data-for-tab="2">Acceptés</button>
            <button class="tabs-btn btn-3" data-for-tab="3">Non acceptés</button>
        </aside>
        <section class="tabs-content tabs-content-active" data-tab="1">
            <table class="content-table">
                <thead>
                <tr>
                    <th>Date de réservation</th>
                    <th>Temps de réservation</th>
                    <th>Date de room</th>
                    <th>Nombre de réservations par room</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="allReservation" items="${allReservations}">
                    <tr>
                        <td>${allReservation.date}</td>
                        <td>${allReservation.reservationType.name}</td>
                        <td>${allReservation.room.date}</td>
                        <td>${allReservation.room.usersNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
        <section class="tabs-content" data-tab="2">
            <table class="content-table">
                <thead>
                <tr>
                    <th>Date de réservation</th>
                    <th>Temps de réservation</th>
                    <th>Date de room</th>
                    <th>Nombre de réservations par room</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="acceptedReservations" items="${acceptedReservations}">
                    <tr>
                        <td>${acceptedReservations.date}</td>
                        <td>${acceptedReservations.reservationType.name}</td>
                        <td>${acceptedReservations.room.date}</td>
                        <td>${acceptedReservations.room.usersNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
        <section class="tabs-content" data-tab="3">
            <table class="content-table">
                <thead>
                <tr>
                    <th>Date de réservation</th>
                    <th>Temps de réservation</th>
                    <th>Date de room</th>
                    <th>Nombre de réservations par room</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="nonAcceptedReservations" items="${nonAcceptedReservations}">
                    <tr>
                        <td>${nonAcceptedReservations.date}</td>
                        <td>${nonAcceptedReservations.reservationType.name}</td>
                        <td>${nonAcceptedReservations.room.date}</td>
                        <td>${nonAcceptedReservations.room.usersNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
    </section>
    <!-- Add Modal HTML -->
    <div id="addReservationModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="${pageContext.request.contextPath}/reservation/insert" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Ajouter Réservation</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Date de réservation</label>
                            <input type="date" name="date-rsv" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Temps de réservation</label>
                            <select class="form-control" name="rsvType">
                                <c:forEach var="reservationType" items="${reservationTypes}">
                                    <option value="${reservationType.idReservationType}">${reservationType.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler">
                        <input type="submit" class="btn btn-success" value="Ajouter">
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
<script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/files/js/app.js"></script>
</body>

</html>
