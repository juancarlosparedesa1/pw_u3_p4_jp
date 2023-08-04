<template>
    <div class="container">
      <div class="form-group">
        <label for="">ID</label>
        <input v-model="id" type="text" class="form-input" />
        <button @click="eliminarEstudiante" class="submit-button">Eliminar</button>
      </div>
  
      <!-- <label class="form-label">Estudiante Eliminado</label>-->
  
      <div class="form-group">
        <label class="form-label">Cedula</label>
        <input v-model="cedula" type="text" class="form-input" />
      </div>
  
      <div class="form-group">
        <label class="form-label">Nombre</label>
        <input v-model="nombre" type="text" class="form-input" />
      </div>
  
      <div class="form-group">
        <label class="form-label">Apellido</label>
        <input v-model="apellido" type="text" class="form-input" />
      </div>
  
      <div class="form-group">
        <label class="form-label">Provincia</label>
        <input v-model="provincia" type="text" class="form-input" />
      </div>
  
      <div class="form-group">
        <label class="form-label">Fecha de nacimiento</label>
        <input v-model="fechaNacimiento" type="datetime" class="form-input" />
      </div>
    </div>
  </template>
  
  <script>
  import { eliminarEstudianteFachada } from "../helpers/EstudianteCliente.js";
  
  export default {
    data() {
      return {
        id: null,
        cedula: null,
        nombre: null,
        apellido: null,
        provincia: null,
        fechaNacimiento: null,
      };
    },
  
    methods: {
      async eliminarEstudiante() {
        const data = await eliminarEstudianteFachada(this.id);
        this.cedula = data.cedula;
        this.nombre = data.nombre;
        this.apellido = data.apellido;
        this.provincia = data.provincia;
        this.fechaNacimiento = data.fechaNacimiento;
      },
    },
  };
  </script>
  
  <style scoped>
  /* Estilos para el contenedor principal */
  .container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f7f7f7;
  }
  
  /* Estilos para los grupos de campos del formulario */
  .form-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }
  
  /* Estilos para las etiquetas del formulario */
  .form-label {
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  
  /* Estilos para los campos de entrada del formulario */
  .form-input {
    flex: 1;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  /* Estilos para el botón de eliminar */
  .submit-button {
    padding: 10px;
    font-size: 16px;
    font-weight: bold;
    background-color: #dc3545;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .submit-button:hover {
    background-color: #c82333;
  }
  </style>