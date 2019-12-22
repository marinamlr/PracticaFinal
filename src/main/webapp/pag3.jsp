<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Recomendaciones</title>

  <!-- Bootstrap Core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/stylish-portfolio.min.css" rel="stylesheet">
	<style>
		ul.otra {
	  padding-left: 7em;
	  text-indent: -1em;
	}
	li.otra {
	  padding-left: 2em;
	  text-indent: -1em;
	  color: #1D809F;
	}
	li:nth-child(odd).otra { color: #ecb807; }
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



  <!-- Portfolio -->
  <section class="content-section" id="portfolio">
    <div class="container">
      <div class="content-section-heading text-center">
        <h3 class="text-secondary mb-0"><%= request.getAttribute("ciudad") %></h3>
        <h2 class="mb-5">¡Aquí tienes nuestras recomendaciones!</h2>
      </div>
      <div class="row no-gutters">

      <%
        ArrayList str = (ArrayList) request.getAttribute("tipo");
      %><ul class="otra">
        <% for(int i=0; i<str.size();i++) { %>
                <li class="otra"><h3>
                <%out.print(str.get(i)+"\n");%></h3>
 		<br/>
        <%}
      %></ul>
        
      </div>
    </div>
  </section>
 <div class="resrva" style="text-align:center">
 	<h5>¿Quieres reservar? Nosotros lo hacemos por ti.</h5>
     <a href="https://assistant-chat-eu-gb.watsonplatform.net/web/public/3b550de1-ad13-439c-928a-85063a2cbe44" class="btn btn-xl btn-dark" >Reservar</a>
 </div>

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

</body>

</html>
