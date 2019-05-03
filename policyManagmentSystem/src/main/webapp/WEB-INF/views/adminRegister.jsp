<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        

        <!------ Include the above in your HEAD tag ---------->
    <title>Registration</title>

    <link rel="stylesheet" href="C:\Users\768762\Desktop\registration.css" />
   
    <style>
    body {
    background: url("https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/backgroung.jpg?alt=media&token=9ae8da86-0d80-481a-b7c5-21c63af3b215");
  }
  form {
    width: 80%;
    margin: 60px auto;
    background: #efefef;
    padding: 60px 70px 60px 70px;
    text-align: center;
    -webkit-box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
    box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
  }
  label {
    display: block;
    position: relative;
    margin: 40px 0px 1px;
  }
  .nav-item-active{
    float:right;
  }
  .navbar{
      height: 90px;
  }
  .navbar-header{
    width:100%;
  }
  .label-txt {
    position: absolute;
    top: -1.6em;
    padding: 2px;
    font-family: sans-serif;
    font-size: .9em;
    letter-spacing: 1px;
    color: rgb(120,120,120);
    transition: ease .3s;
  }
  .input {
    width: 95%;
    padding: 1px;
    background: transparent;
    border: none;
    outline: none;
  }
  
  .line-box {
    position: relative;
    width: 100%;
    height: 2px;
    top: 1px;
    bottom: 2px;
    background: #BCBCBC;
  }
  
  .line {
    position: absolute;
    width: 0%;
    height: 1px;   
    left: 50%;
    transform: translateX(-50%);
    background: rgb(255, 132, 132);
    transition: ease .6s;
  }
  
  .input:focus + .line-box .line {
    width: 100%;
  }
  
  .label-active {
    top: -3em;
  }
  
  button {
    align-self:center;
    display: inline-block;
    padding: 12px 36px;
    background: rgb(220,220,220);
    font-weight: bold;
    color: rgb(120,120,120);
    border: none;
    outline: none;
    border-radius: 3px;
    cursor: pointer;
    transition: ease .3s;
  }
  
  button:hover {
    background: #8BC34A;
    color: #ffffff;
  }
  .btnn{
      padding: 0px 5px;
  }
    
.input::-webkit-inner-spin-button, 
.input::-webkit-outer-spin-button { 
  -webkit-appearance: none; 
  margin: 0; 
} 
 
  
    </style>
    <script>
    
    function myFunction() {
      alert("1. Atleast 1 Lower Case \n2. Atleast 1 Upper Case \n3.Atleast 1 special character \n4. Atleast 8 character");
    }
   
    $(document).ready(function(){
        $('.input').focus(function(){
          $(this).parent().find(".label-txt").addClass('label-active');
        });
      
        $(".input").focusout(function(){
          if ($(this).val() == '') {
            $(this).parent().find(".label-txt").removeClass('label-active');
          };
        });
      
      });
    
    function deleteAllHistory() {
    	window.history.go(1);
    	window.history.go(-1);
    	window.history.go(0);
    	}
    </script>
    
  </head>

  <body>


        <nav class="navbar navbar-light bg-light">
               <a href="adminlog.html"> <img src="https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/logo.png?alt=media&token=3f99482f-6af5-477e-9e56-2e55de640f3c" style="width:170px;height:75px;"></img></a>
               <ul class="navbar-nav ml-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="#"><span class="fa fa-bell"></span></a>
                   </li>
                   <li class="nav-item">
                       <span class="navbar-text">
      
                       </span>
                   </li>
                   </ul>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <form class="btnn">
                                <a href="adminlog.html" class="btn btn-secondary  form-rounded" >Login</a>
                            </form>
                        </li>
                    </ul>
                        
            </nav>


<form action="registration.html"  method="POST">
        <h1><p><u>NEW REGISTER</u></p></h1>

    <div class="row">
        <div class="col-sm-6">
        <label>
          <p class="label-txt">USER ID</p>
          <input type="text" class="input" name="userId" required>
          <div class="line-box">
            <div class="line"></div>
          </div>
        </label>
        </div>
        <br>

        <div class="col-sm-6">
        <label>
          <p class="label-txt">FIRST NAME</p>
          <input type="text" class="input" name="firstName" required>
          <div class="line-box">
            <div class="line"></div>
          </div>
        </label>
        </div>
        <br>

        <div class="col-sm-6">
        <label>
          <p class="label-txt">Last Name:</p>
          <input type="text" class="input" name="lastName" required>
          <div class="line-box">
            <div class="line"></div>
          </div>
        </label>
        </div>
        <br>

        <div class="col-sm-6">
        <label>
                <p class="label-txt">DOB (MM/DD/YYYY) :</p>
                <input type="date" class="input" name="DOB" required>
                <div class="line-box">
                  <div class="line"></div>
                </div>
        </label>
    </div>
        <br>

        <div class="col-sm-6">
        <label>
                <p class="label-txt">Gender</p>
                 <select name="gender" class="input">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                                                    
                </select>
                <div class="line-box">
                  <div class="line"></div>
                </div>
        </label>
    </div>
       <br>

       <div class="col-sm-6">
        <label>
                <p class="label-txt">Contact No:</p>
                <input type="text" class="input" name="contactNo" size="10" maxlength="10"  pattern="[789][0-9]{9}" required>
                <div class="line-box">
                  <div class="line"></div>
                </div>
              </label>
            </div>
              <br>

              <div class="col-sm-6">
              <label>
                    <p class="label-txt">Address:</p>
                    <input type="text" class="input" name="address" required>
                    <div class="line-box">
                      <div class="line"></div>
                    </div>
                  </label>
                </div>
                  <br>

                  <div class="col-sm-6">
                  <label>
                        <p class="label-txt">Email Id:</p>
                        <input type="email" class="input" name="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
                        <div class="line-box">
                          <div class="line"></div>
                        </div>
                      </label>
                    </div>
                      <br>

                      <div class="col-sm-6">
                      <label>
                            <p class="label-txt">Qualification:</p>
                            <input type="text" class="input" name="qualification" required>
                            <div class="line-box">
                              <div class="line"></div>
                            </div>
                          </label>
                        </div>
                          <br>

                          <div class="col-sm-6">
                          <label>
                                <p class="label-txt">Salary Per Month:</p>
                                <input type="number" class="input" name="salary" required>
                                <div class="line-box">
                                  <div class="line"></div>
                                </div>
                              </label>
                            </div>
                              <br>

                              <div class="col-sm-6">
                              <label>
                                    <p class="label-txt">PAN No:</p>
                                    <input type="text" class="input" name="PAN" maxlength="10" required>
                                    <div class="line-box">
                                      <div class="line"></div>
                                    </div>
                                  </label>
                                </div>
                                    <br>
                                    
                                    <div class="col-sm-6">
                                  <label>
                                        <p class="label-txt">Employer Type:</p>
                                        <input type="text" class="input" name="employerType" required>
                                        <div class="line-box">
                                          <div class="line"></div>
                                        </div>
                                      </label>
                                    </div>
                                      <br>

                                      <div class="col-sm-6">
                                      <label>
                                            <p class="label-txt">Employer:</p>
                                            <input type="text" class="input" name="employer" required>
                                            <div class="line-box">
                                              <div class="line"></div>
                                            </div>
                                          </label>
                                        </div>
                                          <br>

                                          <div class="col-sm-6">
                                          <label>
                                                <p class="label-txt">Hint Question:</p>
                                                <select name="hintQuestion" class="input">
                                                    <option value="Who is your childhood sports hero">Who is your childhood sports hero?</option>
                                                    <option value="What was your childhood nickname?">What was your childhood nickname?</option>
                                                    <option value="What is your favorite team?">What is your favorite team?</option>
                                                    <option value="What is your favorite movie?">What is your favorite movie?</option>
                                                  </select>
                                                <div class="line-box">
                                                  <div class="line"></div>
                                                </div>
                                              </label>
                                            </div>
                                            <br>
                                            <div class="col-sm-6">
                                              <label>
                                                    <p class="label-txt">Hint Answer:</p>
                                                    <input type="text" class="input" name="hintAnswer" required>
                                                    <div class="line-box">
                                                      <div class="line"></div>
                                                    </div>
                                                  </label>
                                                </div>
                                                  <br>

                                                  <div class="col-sm-6">
                                                  <label>
                                                        <p class="label-txt">Password:<img src="https://firebasestorage.googleapis.com/v0/b/grizzly-5a659.appspot.com/o/36601.png?alt=media&token=925db137-c3d5-4532-af35-4f0a4d6b57fa " width=15px height=15px onmousedown="myFunction()"></p>
                                                        <input type="password" class="input"   name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                                                        <div class="line-box">
                                                          <div class="line"></div>
                                                        </div>
                                                      </label>
                                                    </div>
                                                    <br>
        
            <br>
            <br>
            <br>
            <br>
            <br>
            &nbsp;&nbsp;&nbsp;
        <button type="submit" onClick="deleteAllHistory()">submit</button>
        
      </form>
    </div>
      
    <script src="C:\Users\768762\Desktop\registration.js"></script>
  </body>
</html>