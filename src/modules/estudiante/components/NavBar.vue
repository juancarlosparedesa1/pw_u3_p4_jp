<template>
  <div class="navigation">
    <router-link to="/consultar" class="nav-link">Consultar</router-link>
    <router-link to="/guardar" class="nav-link">Guardar</router-link>
    <router-link to="/actualizar" class="nav-link">Actualizar</router-link>
    <router-link to="/eliminar" class="nav-link">Eliminar</router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.navigation {
  display: flex;
  justify-content: space-around;
  align-items: center;
  background-color: #007bff;
  padding: 10px;
}

.nav-link {
  color: #fff;
  text-decoration: none;
  font-size: 18px;
  padding: 10px 15px;
  border-radius: 5px;
  transition: background-color 0.2s ease;
}

.nav-link:hover {
  background-color: #0056b3;
}


.router-link-active {
  background-color: #0056b3;
}
</style>