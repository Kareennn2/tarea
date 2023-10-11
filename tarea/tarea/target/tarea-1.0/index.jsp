
<%@include file="templates/header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso o Registro</title>
    </head>
    <body>
       <section class="background-radial-gradient overflow-hidden">
  <style>
    .background-radial-gradient {
      background-color: hsl(218, 41%, 15%);
      background-image: radial-gradient(650px circle at 0% 0%,
          hsl(218, 41%, 35%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%),
        radial-gradient(1250px circle at 100% 100%,
          hsl(218, 41%, 45%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%);
    }

    #radius-shape-1 {
      height: 220px;
      width: 220px;
      top: -60px;
      left: -130px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    #radius-shape-2 {
      border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
      bottom: -60px;
      right: -110px;
      width: 300px;
      height: 300px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    .bg-glass {
      background-color: hsla(0, 0%, 100%, 0.9) !important;
      backdrop-filter: saturate(200%) blur(25px);
    }
  </style>

  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <div class="row gx-lg-5 align-items-center mb-5">
      <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
          The best offer <br />
          <span style="color: hsl(218, 81%, 75%)">for your business</span>
        </h1>
        <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit.
          Temporibus, expedita iusto veniam atque, magni tempora mollitia
          dolorum consequatur nulla, neque debitis eos reprehenderit quasi
          ab ipsum nisi dolorem modi. Quos?
        </p>
      </div>

      <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

        <div class="card bg-glass">
          <div class="card-body px-4 py-5 px-md-5">
            <form id="loginForm" action="SvEntrar" method="post">
    <div style="text-align: center;">
        <h3>LOG IN</h3>
    </div>
    <!-- Usuario input -->
    <div class="form-outline mb-4">
        <label for="usuario" class="form-label">Usuario:</label>
        <input type="text" class="form-control" name="usuario" required><br>
    </div>
    <!-- Password input -->
    <div class="form-outline mb-4">
        <label for="contrasena" class="form-label">Password:</label>
        <input type="password" class="form-control" name="contrasena" required><br>
    </div>
    <div class="text-center">
        <br><button type="submit" class="btn btn-success">SIGN IN</button><!-- Submit button -->
        <button id="openRegistrationModalBtn" class="btn btn-primary" type="button">Registrarse</button>
    </div>
</form>

              <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("error") %>
            </div>
                <% } %>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    </body>
<section class="background-radial-gradient overflow-hidden">
  <style>
  /* Estilo del botón de "Registrarse" */
  #openRegistrationModalBtn {
    background-color: #44006b;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-family: 'Segoe UI', sans-serif;
    font-size: 16px;
  }

  /* Estilo del modal */
  #registrationModal {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.7);
    z-index: 1000;
    text-align: center;
  }

  .modal-content {
    background-color: #fff;
    margin: 10% auto;
    padding: 20px;
    border-radius: 10px;
    width: 70%;
    max-width: 400px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
  }

  /* Estilo del botón "Cerrar" en el modal */
  .close {
    position: absolute;
    top: 10px;
    right: 10px;
    font-size: 24px;
    color: #44006b;
    cursor: pointer;
  }
</style>


  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <!-- ... Contenido existente ... -->

    <!-- Modal de Registro -->
    <div id="registrationModal" class="modal">
      <div class="modal-content">
        <span class="close" id="closeModalBtn">&times;</span>
        <h2 style="color: #44006b; ">Registro</h2>
        <form id="registrationForm" action="SvIngresar" method="post">
          <label for="nombre"  class="form-label">Nombre y Apellido:</label>
          <input type="text" class="form-control"  name="nombre" aria-describedby="basic-addon1" required><br>
          <div id="nombre" class="form-text" ></div>
          
          <label for="usuario" class="form-label">Usuario:</label>
          <input type="text" class="form-control" name="usuario" required><br>
          <div id="usuario" class="campo-input"></div>

          <label for="contrasenia" class="form-label">Contraseña:</label>
          <input type="password" class="form-control" name="contrasenia" required><br>
      
          <input type="submit" value="Registrar">
        </form>
      </div>
    </div>
    <!-- Fin del Modal de Registro -->
  </div>
</section>
<%@include file="templates/footer.jsp" %>
<script>
  document.addEventListener('DOMContentLoaded', function () {
    // Obtén referencias a los elementos HTML
    const openRegistrationModalBtn = document.getElementById('openRegistrationModalBtn');
    const registrationModal = document.getElementById('registrationModal');

    // Abre el modal de registro cuando se hace clic en el botón "Registrarse"
    openRegistrationModalBtn.addEventListener('click', () => {
      registrationModal.style.display = 'block';
    });
  });
</script>
<script>
  // Obtén referencias a los elementos HTML
  const closeModalBtn = document.getElementById('closeModalBtn');
  const registrationModal = document.getElementById('registrationModal');

  // Cierra el modal cuando se hace clic en la "x"
  closeModalBtn.addEventListener('click', () => {
    registrationModal.style.display = 'none';
  });

  // Abre el modal de registro cuando sea necesario (puedes agregar un botón)
  // Por ejemplo, aquí se agrega un botón "Registro" para abrir el modal:
  const openModalBtn = document.createElement('button');
  openModalBtn.textContent = 'Registro';
  openModalBtn.addEventListener('click', () => {
    registrationModal.style.display = 'block';
  });

  // Agrega el botón "Registro" donde desees en tu página
  const registrationButtonContainer = document.getElementById('registrationButtonContainer');
  registrationButtonContainer.appendChild(openModalBtn);
</script>