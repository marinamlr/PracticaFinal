<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>You looked for...</title>

  <!-- Bootstrap Core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/stylish-portfolio.min.css" rel="stylesheet">
  
  <style type="text/css">
	  h3{
	  	text-transform: uppercase;
	  }
  </style>

</head>

<body id="page-top">

  <!-- Navigation -->
  <a class="menu-toggle rounded" href="#">
    <i class="fas fa-bars"></i>
  </a>
  <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
      <li class="sidebar-brand">
        <a class="js-scroll-trigger" href="index.jsp">MAPP</a>
      </li>
      <li class="sidebar-nav-item">
        <a class="js-scroll-trigger" href="index.jsp#page-top">Inicio</a>
      </li>
      <li class="sidebar-nav-item">
        <a class="js-scroll-trigger" href="index.jsp#about">Sobre nosotros</a>
      </li>
      <li class="sidebar-nav-item">
        <a class="js-scroll-trigger" href="index.jsp#services">¿Cómo funciona?</a>
      </li>
      <li class="sidebar-nav-item">
        <a class="js-scroll-trigger" href="pag4.jsp">Búsqueda</a>
      </li>
    </ul>
  </nav>


  <!-- Callout -->
  <section class="callout">
    <div class="container text-center">
      <h3 class="mx-auto mb-5" id="esp">Has buscado:<%= request.getAttribute("esp") %>, un plato que encontrarás en un  <%=request.getAttribute("wat_esp") %></h3>
      <h3 class="mx-auto mb-5" style="visibility:hidden" id="eng">You looked for: <%= request.getAttribute("eng") %>. You can find this in <%=request.getAttribute("wat") %> restaurants</h3>
      <a href="#" onclick="ingles()">ENG | </a>
      <a href="#" onclick="espanol()">ESP</a>
    </div>
  </section>

  <!-- Call to Action -->
  <section class="content-section bg-primary text-white">
    <div class="container text-center">
    <% String val= (String) request.getAttribute("wat"); %>
     <form method="post" action="Controller2" >
      <input type="hidden" value="<%=val%>" name="respuesta" id="respuesta">
      <button class="btn btn-xl btn-light mr-4" type="submit">Ver recomendaciones</button>
      <a href="pag4.jsp" class="btn btn-xl btn-dark" >Nueva Búsqueda</a></form>
    </div>
  </section>
  

  <!-- Footer -->
  <footer class="footer text-center">
    <div class="container">
      <ul class="list-inline mb-5">
        <li class="list-inline-item">
          <a class="social-link rounded-circle text-white mr-3" href="#">
            <i class="icon-social-facebook"></i>
          </a>
        </li>
        <li class="list-inline-item">
          <a class="social-link rounded-circle text-white mr-3" href="#">
            <i class="icon-social-twitter"></i>
          </a>
        </li>
        <li class="list-inline-item">
          <a class="social-link rounded-circle text-white" href="#">
            <i class="icon-social-github"></i>
          </a>
        </li>
      </ul>
      <p class="text-muted small mb-0">Copyright &copy; Your Website 2019</p>
    </div>
  </footer>
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/stylish-portfolio.min.js"></script>
  
  <script type="text/javascript">
  	function ingles(){
  		document.getElementById("eng").style.visibility = "visible";
  		document.getElementById("esp").style.visibility = "hidden";
  	}
  	function espanol(){
  		document.getElementById("eng").style.visibility = "hidden";
  		document.getElementById("esp").style.visibility = "visible";
  	}
  </script>

</body>

</html>
