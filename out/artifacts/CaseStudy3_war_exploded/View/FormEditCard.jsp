<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/9/2020
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
        .mytable{
            margin-top: 30px;
            margin-left: 20px;

        }
        tr, td{
            margin: 5px;
            padding: 5px;
        }
        .col-sm-3 img{
            width: 100%;
            height: 280px;
            margin-top: 30px;
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
    <title>Title</title>
</head>
<body>
<div class = "container" style="height: auto">
    <div class = "ontop_header">
        <div class = "allCenter">
            <div class = "pull-left">
                <p style="margin: 0;">Địa chỉ:&nbsp;<strong>15 Bùi Ngọc Dương,Hai Bà Trưng,Hà Nội</strong></p>
            </div>
            <div class="pull-right">
                <form method="post" action="/login">
                    <ul class="language_user" style="margin-left: 30px; display: inline">
                        <li><a href="">Đăng Xuất</a></li>
                        <li>|</li>
                        <li><a href="./login">Xin chào</a></li>
                    </ul>
                </form>
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
                        <a class="dropdown-item" href="./administrator" style="color: #ff000b">Administrator</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <div class="row">
        <div class="col-sm-3">
        </div>
        <div class="col-sm-9">
            <form method="post">
                   <div class="row">
                      <div class="col-sm-6"  >
                          <table class="mytable">
                              <c:if test="${card != null}">
                                  <input type="hidden" name="id" value="<c:out value='${card.id}' />"/>
                              </c:if>
                              <tr>
                                  <td>New name</td>
                                  <td><input type="text" name = "newName" value = '<c:out value="${card.name}"/>'></td>
                              </tr>
                              <tr>
                                  <td>New price</td>
                                  <td><input type="text" name = "newPrice" value = '<c:out value="${card.price}"/>'></td>
                              </tr>
                              <tr>
                                  <td>New quantity</td>
                                  <td><input type="text" name = "newQuantity" value = '<c:out value="${card.quantity}"/>'></td>
                              </tr>
                              <tr>
                                  <td>New image</td>
                                  <td><input type="text" name = "newImage" value = '<c:out value="${card.image}"/>'></td>
                              </tr>
                              <tr>
                              </tr>
                              <tr>
                                  <td colspan="2" align="right"><button>Save Change</button></td>
                              </tr>
                          </table>
                      </div>
                       <div class="col-sm-3">
                           <img src="${card.image}" alt="" width=100%, height=100px/>
                       </div>
                   </div>
            </form>
        </div>
    </div>
    <footer>
        <div class="card-heading text-center">
            <p>Dueling Shop &copy; 2020</p>
        </div>
    </footer>
</div>
<%--<a href="myCard?action=sdfgdsgdg">Back</a>--%>
<%--<br>--%>

</body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
