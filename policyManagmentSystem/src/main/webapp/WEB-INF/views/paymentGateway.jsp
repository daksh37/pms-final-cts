<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
       <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
        crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <title>Payment Gateway Page</title>
    <style>
        html {
            height: 100%;
        }
        body {
            background: url("https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/backgroung.jpg?alt=media&token=9ae8da86-0d80-481a-b7c5-21c63af3b215");
            height: 100%;
            width: 100%;
            font-family: 'Raleway', sans-serif;
        }
        #billContainer {
            height: 540px;
            background: rgba(255, 255, 255, 0.8);
        }
        @media screen and (max-width: 992px) {
            #billContainer {
                height: 700px;
            }
        }
        @media screen and (max-width: 600px) {
            #billContainer {
                height: 750px;
            }
        }
    </style>
    
</head>

<body>

    <!--Nav Bar-->
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand font-weight-bold" href="policy.html?id=${user.userId}">Policy Tracker</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="redirectToHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="logout.html">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!--Content-->
    <div class="container" id="billContainer">
    <form action="paymentSuccess.html" method="POST">
      <div class="row">
            <div class="display-4 pt-3 ml-3">Payment Success</div>
        </div>
        <hr>
        <div class="row p-1">
            <div class="col-md-6 col-lg-7">
            <span>Payment Method: ${paymentMethod}</span><br><br>
                <input type="submit" value="Get Receipt" class="btn btn-primary p-2 m-1">
            </div>
         </div>
            
        
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>