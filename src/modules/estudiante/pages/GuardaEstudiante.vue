<template>
  <div class="container">
    <label class="form-label">Guardar Estudiante</label>
    <DatosGuardarEstudiante />
  </div>
</template>

<script>
import DatosGuardarEstudiante from '../components/DatosGuardarEstudiante.vue';

export default {
  components: {
    DatosGuardarEstudiante
  },
  mounted(){
    const {cedula}=this.$route.params;
    console.log(cedula);
  }
}
</script>

<style scoped>
.container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f7f7f7;
  margin-top: 50px;
}

.form-label {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 15px;
}

</style>