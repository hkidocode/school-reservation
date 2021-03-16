<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <style>
        *,
        *::before,
        *::after {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        html {
            font-size: 15px;
        }

        body {
            /* background: #F5F5F5; */
            background: #FFF;
            color: #252525;
            font-size: 1rem;
            font-weight: 400;
            font-family: 'Varela Round', sans-serif;
            line-height: 1.6;
        }

        header {
            background: #252525;
        }

        header nav ul {
            width: 65rem;
            margin: 0 auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1rem;
            list-style: none;
        }

        header nav ul li, a {
            text-decoration: none;
            font-weight: 600;
            text-transform: uppercase;
            color: #FAFAFA;
            transition: all .2s ease;
        }

        header nav ul a {
            color: #00B4FF;
        }

        header nav ul img {
            max-width: 100%;
            width: 9rem;
        }

        main {
            display: flex;
        }

        .tabs-sidebar {
            width: 6rem;
            height: calc(100vh - 54px);
            flex-shrink: 0;
            background: #CCCCCC;
        }

        .tabs-btn {
            cursor: pointer;
            display: block;
            padding: .7rem;
            background: #EEEEEE;
            outline: none;
            border: none;
            width: 100%;
        }

        .tabs-btn:active {
            background: #DDDDDD;
        }

        .tabs-btn:not(:last-of-type) {
            border-bottom: 1px solid #CCCCCC;
        }

        .tabs-btn-active {
            font-weight: bold;
            border-right: 2px solid #00B4FF;
            background: #DDDDDD;
        }

        .tabs-content {
            padding: 15px;
            font-size: .95rem;
            display: none;
            width: 100%;
        }

        .tabs-content-active {
            display: block;
        }

        .content-table {
            border-collapse: collapse;
            width: 90%;
            margin: 1.5rem auto;
            font-size: .85rem;
            min-width: 400px;
            border-radius: 4px 4px 0 0;
            overflow: hidden;
            box-shadow: 0 0 18px rgba(0, 0, 0, 0.1);
        }

        .content-table thead tr {
            background-color: #009bdd;
            color: #ffffff;
            font-weight: bold;
        }

        .content-table th,
        .content-table td {
            padding: 10px 12px;
            text-align: center;
        }

        .content-table tbody tr {
            border-bottom: 1px solid #dddddd;
        }

        .content-table tbody tr:nth-of-type(even) {
            background-color: #f3f3f3;
        }

        .content-table tbody tr:last-of-type {
            border-bottom: 2px solid #009bdd;
        }

        .content-table tbody tr:hover {
            font-weight: bold;
            color: #009bdd;
        }

        .btns {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        ion-icon {
            color: #252525;
            font-size: 1.43rem;
        }

        .accept {
            color: #66CD00;
            margin-right: 1rem;
        }

        .delete {
            color: #f44336;
        }

    </style>
    <title>Gestion d'accès à Youcode - Tableau de board</title>
</head>

<body>
<header>
    <nav>
        <ul>
            <li><a href="#"><img src="logo.png" alt="logo" class="logo"></a></li>
            <li>Mustapha Kadouri</li>
            <li><a href="#" class=".link">Déconnexion</a></li>
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
</main>
<script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
<script>
    function setupTabs() {
        document.querySelectorAll('.tabs-btn').forEach(btn => {
            btn.addEventListener('click', () => {
                const sidebar = btn.parentElement;
                const tabsContainer = sidebar.parentElement;
                const tabContentToActive = tabsContainer.querySelector(".tabs-content[data-tab='${btn.dataset.forTab}']");

                sidebar.querySelectorAll('.tabs-btn').forEach(btn => {
                    btn.classList.remove('tabs-btn-active');
                });

                tabsContainer.querySelectorAll('.tabs-content').forEach(tab => {
                    tab.classList.remove('tabs-content-active');
                });

                btn.classList.add('tabs-btn-active');
                tabContentToActive.classList.add('tabs-content-active');
            });
        });
    }

    document.addEventListener('DOMContentLoaded', () => {
        setupTabs();
    });

</script>
</body>

</html>
