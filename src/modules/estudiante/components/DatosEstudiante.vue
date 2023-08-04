<template>
  <div class="container">
    <div class="form-group">
      <label class="form-label">Cedula</label>
      <input v-model="cedula" type="text" class="form-input" />
      <button @click="consultarEstudiante" class="submit-button">
        Consultar
      </button>
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
      <input v-model="nombre" type="text" class="form-input" />
    </div>

    <div class="form-group">
      <label class="form-label">Fecha de Nacimiento</label>
      <input v-model="fechaNacimiento" type="datetime" class="form-input" />
    </div>
  </div>
</template>

<script>
import { obtenerEstudianteFachada } from "../helpers/EstudianteCliente.js";

export default {
  data() {
    return {
      cedula:this.$route.params.cedula,
      nombre: null,
      apellido: null,
      provincia: null,
      fechaNacimiento: null,
    };
  },

  methods: {
    async consultarEstudiante() {
      const data = await obtenerEstudianteFachada(this.cedula);
      this.nombre = data.nombre;
      this.apellido = data.apellido;
      this.provincia = data.provincia;
      this.fechaNacimiento = data.fechaNacimiento;
      console.log(data);
    },
  },

  mounted() {
    const { cedula } = this.$route.params;

    console.log(cedula);

    if (cedula != ":cedula") {
      this.cedula = cedula;

      this.consultarEstudiante();
    }
    console.log(this.$route);
    const prov=this.$route.query.provincia;
    const {prov1}=this.$route.query;
    //this.cedula;
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

/* Estilos para el grupo de campos del formulario */
.form-group {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
}

/* Estilos para los campos de entrada del formulario */
.form-input {
  flex: 1;
  width: 90%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.form-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 15px;
}
/* Estilos para el botón de consultar */
.submit-button {
  padding: 10px;
  font-size: 16px;
  font-weight: bold;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.submit-button:hover {
  background-color: #0056b3;
}

/* Estilos para las etiquetas del formulario */
.form-label {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 5px;
}
</style>