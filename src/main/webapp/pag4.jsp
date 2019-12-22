<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Upload photo</title>

  <!-- Bootstrap Core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/stylish-portfolio.min.css" rel="stylesheet">
  <link href="css/stylish-portfolio.css" rel="stylesheet">

  <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
  
  <style>
	  .center {
		  display: block;
		  margin-left: auto;
		  margin-right: auto;
		  width: 50%;
		}
	label {
		border: none;
		background-color: green;
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
  <section>
    <div class="container text-center">
        <form method="post" action="Controller" enctype="multipart/form-data" id="data" class="box has-advanced-upload">
            <svg class="box__icon" xmlns="http://www.w3.org/2000/svg" width="50" height="43" viewBox="0 0 50 43"><path d="M48.4 26.5c-.9 0-1.7.7-1.7 1.7v11.6h-43.3v-11.6c0-.9-.7-1.7-1.7-1.7s-1.7.7-1.7 1.7v13.2c0 .9.7 1.7 1.7 1.7h46.7c.9 0 1.7-.7 1.7-1.7v-13.2c0-1-.7-1.7-1.7-1.7zm-24.5 6.1c.3.3.8.5 1.2.5.4 0 .9-.2 1.2-.5l10-11.6c.7-.7.7-1.7 0-2.4s-1.7-.7-2.4 0l-7.1 8.3v-25.3c0-.9-.7-1.7-1.7-1.7s-1.7.7-1.7 1.7v25.3l-7.1-8.3c-.7-.7-1.7-.7-2.4 0s-.7 1.7 0 2.4l10 11.6z"></path></svg>
            <input type="file" name="fileToUpload" id="fileToUpload" onchange="readURL(this); display();" required>
            <label for="fileToUpload">Haz click aquí</label>
            <br /><br />
            <img id="vaya" src="#" alt="your image"  class="center" style="display:none"/>
            <br /><br />
            <button type="submit" class="btn btn-xl btn-light mr-4">Subir</button> </form>
    </div>
    
    
	
    <script type="text/javascript">

    function readURL(input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function (e) {
            $('#vaya')
              .attr('src', e.target.result)
              .width(450)
              .height(400);
          };
          reader.readAsDataURL(input.files[0]);
        }
      }
    
    function display() {
    	  var x = document.getElementById("vaya");
    	  if (x.style.display === "none") {
    	    x.style.display = "block";
    	  }
    }
    </script>
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

</body>

</html>
