<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Offre" %> 

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Offre Admin</title>
    <base href="/">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/offreAdmin.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header class="container-fluid">
    <div class="row align-items-center">
        <div class="col-md-auto">
            <a href="#" class="logo">Flex <span class="green-span">Gym</span></a>
        </div>
        <div class="col-md">
            <nav class="text-center">
                <ul class="nav-links">
                    <li><a href="#">Courses</a></li>
                    <li><a href="#">Courses</a></li>
                    <li><a href="#">Courses</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-auto">
            <a class="sign-in" href="#">
                <button class="btn" style="color:#000;background-color:#E7FE58" >Sign Out </button>
                <button class="btn" style="color:#000;background-color:#E7FE58" >User</button>
            </a>
        </div>
    </div>
</header>
<div class="text-center table-title">
    <h1>Liste des offres</h1>
</div>
<div class="table-container">
    <table class="striped-table">
        <thead>
            <tr>
                <th scope="col">offreID</th>
                <th scope="col">offreNom</th>
                <th scope="col">Detailoffre</th>
                <th scope="col">Cours</th>
                <th scope="col">Prixoffre</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<Offre> offres = (List<Offre>) request.getAttribute("offres");
            if (offres != null) {
                for (Offre offre : offres) {
            %>
            <tr>
                <td><%= offre.getOffreId() %></td>
                <td><%= offre.getOffreNom() %></td>
                <td><%= offre.getOffreDetail() %></td>
                <td><%= offre.getCour().getCourNom() %></td>
                <td><%= offre.getOffrePrix() %></td>
                <td>Actions</td>
            </tr>
            <% 
                }
            }
            %>
        </tbody>
    </table>
</div>
</body>
</html>
