<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/8/2020
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>

        .ontop_header{
            background-image: url('https://i.ytimg.com/vi/zKPtwXJlETI/maxresdefault.jpg');
            height: 100px;
            width: 100%;
            line-height: 40px;
            color: #fff;
        }
        *{
            box-sizing: border-box;
        }
        p{
            text-align: center;
        }
        .allcenter {
            *zoom: 1;
        }
        .pull-left {
            float: left;
        }
        .pull-right {
            float: right;
        }
        .language_user {
            list-style: none;
            float: left;
            margin: 0px;
            padding: 0px;
        }
        li{
            float: left;
            margin: 10px;
        }
        .col-sm-3 img{
            width: 100%;
            height: 280px;
            margin-top: 30px;
        }
        .card{
            position: relative;

        }
        .card_name{
            position: relative;
            text-align: center;
            height: 42px;
        }
        .card >.card_sell{
            visibility: hidden;
            position: absolute;
            width: 100%;
            bottom: 90px;
            text-align: center;
            color: white;
        }
        .card_sell:hover{
            visibility: visible;
            background-color: rgba(255,175,194,0.54);
        }
        .card_price{
            background-color: rgba(174,255,238,0.54);
            width: 100%;
            left: 0px;
            text-align: center;
        }
        .card_option{
            text-decoration: none;
            align-self: center;
            align-items: center;
            align-content: center;
        }
        .card_option>button{
            width: 71px;
            height: 32px;
            margin: 5px;
        }
        .poly-cart{
            margin-top: 28px;
        }
        .poly-cart ul {
            padding: 0px;
            margin: 0px;
            list-style: none;
            font-variant: small-caps;
        }
        .poly-cart .panel-heading strong {
            font-variant: small-caps;
            font-size: larger;
            text-shadow: 0 0 2px darkgray;
        }
        .poly-prod .panel-body img{
            height: 150px;
            max-width: 95%;
        }
        a.list-group-item, button.list-group-item {
            color: #555;
        }
        @media screen and (max-width: 1000px) {
            .col-sm-3 img {
                width: 50%;
            }
        }
        @media screen and (max-width: 500px) {
            .col-sm-3 img {
                width: 100%;
            }
        }
    </style>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
<body>
<div class = "container" style="height: auto">
    <div class = "ontop_header">
        <div class = "allCenter">
            <div class = "pull-left">
                <p style="margin: 0;">Địa chỉ:&nbsp;<strong>15 Bùi Ngọc Dương,Hai Bà Trưng,Hà Nội</strong></p>
            </div>
            <div class="pull-right">
                <ul class="language_user" style="margin-left: 30px; display: inline">
                    <li><a href="./myCard?action=home">Đăng xuất</a></li>
                    <li>|</li>
                    <li><b><p>Xin chào: ${nameUser}</p></b></li>
                </ul>
            </div>
        </div>
    </div>
    <header class="header">
        <div class="row">

        </div>
    </header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#"><i class="fas fa-home"></i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="./show">Sản phẩm Yugioh<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Cardfight Vanguard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Board games</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Đơn hàng</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tùy chọn
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Build Deck</a>
                        <a class="dropdown-item" href="#">Top meta</a>
                        <a class="dropdown-item" href="#">Top bán chạy</a>
                    </div>
                </li>
            </ul>
            <form action="./myCard?action=find" method="post" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" name = "cardName" type="search" placeholder="Search" aria-label="Search">
                <input type="hidden" name = "address" value="View/Customer.jsp" width="1px">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
            </form>
        </div>
    </nav>
    <div class="row">
        <div class="col-sm-3">
            <div class="poly-cart">
                <div class="card">
                    <div class="card-body">
                        <div class="row" style="align-content: center; align-items: center">
                            <img style="width: 50px; height: 50px; margin-top: 0px" class="col-sm-5" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Shopping_cart_icon.svg/1200px-Shopping_cart_icon.svg.png"/>
                            <ul class="col-sm-7">
                                <li><a href="./myUser?action=viewBill">Xem giỏ hàng</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-th-list"></span>
                    <strong>Tin tức</strong>
                </div>
                <div class="list-group">
                    <a href="#" class="list-group-item">Tin tức Yu-gi-oh</a>
                    <a href="#" class="list-group-item">Rank</a>
                    <a href="#" class="list-group-item">Hướng dẫn chơi Yu-gi-oh</a>
                    <a href="#" class="list-group-item">Liên hệ</a>
                </div>
            </div>
        </div>
        <div class="col-sm-9">
            <div class="row" >
                <c:forEach items="${myCardList}" var= "mycard">
                    <div class="col-sm-3">
                        <div class="card">
                            <img src=${mycard.image} alt="">
                            <div class="card_sell">
                                <b><p>Mua hàng</p></b>
                            </div>
                            <div class="card_price">
                                <b><p>Giá: ${mycard.price} VNĐ</p></b>
                            </div>
                            <div class="card_name">
                                <b><p>${mycard.name}</p></b>
                            </div>
                            <div class="card_option">
                                <button ><a href="./myUser?action=buy&id=${mycard.id}">Mua</a></button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <footer>
        <div class="card-heading text-center">
            <p>Dueling Shop &copy; 2020</p>
        </div>
    </footer>
</div>
</body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
