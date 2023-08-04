import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    {
        path: "/consultar/:cedula",
        //component: BienvenidaPage
        component: () => import('../modules/estudiante/pages/ConsultaEstudiante') 
    },
    {
        path: "/guardar",
        //component: JuegoPage
        component: () => import('../modules/estudiante/pages/GuardaEstudiante')
    },
    {
        path: "/actualizar",
        //component: PremiosPage
        component: () => import('../modules/estudiante/pages/ActualizarEstudiante')
    },
    {
        path: "/eliminar",
        //component: PokemonPages
        component: () => import('../modules/estudiante/pages/EliminarEstudiante')
    },
]


const router=createRouter({
    history: createWebHashHistory(),
    routes
})

export default router