import axios from "axios"

export const obtenerEstudianteFachada = async (cedula)=>{
    console.log('AXIOS')
    return await obtenerEstudianteAPIAxios(cedula);
}

export const ingresarEstudianteFachada = (bodyEstudiante) =>{
    ingresarEstudiante(bodyEstudiante);
}

export const actualizarEstudianteFachada = (bodyEstudiante, id) => {
    actualizarEstudiante(bodyEstudiante, id);
}

export const eliminarEstudianteFachada = async (id) =>{
    return await eliminarEstudiante(id);
}

const obtenerEstudianteAPI = async (cedula)=>{
    const data = await fetch(`http://localhost:8081/API/v1.0/Matricula/estudiantes/${cedula}`).then(r => r.json());
    console.log(data);
    return data;
}

const obtenerEstudianteAPIAxios = async (cedula)=>{
    console.log('AXIOS 2')
    const data = axios.get(`http://localhost:8081/API/v1.0/Matricula/estudiantes/${cedula}`).then(r=>r.data);
    return data;
}

const ingresarEstudiante = (bodyEstudiante) =>{
    axios.post(`http://localhost:8081/API/v1.0/Matricula/estudiantes`,bodyEstudiante).then(r=>r.data);
}

const actualizarEstudiante = (bodyEstudiante, id) => {
    axios.put(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${id}`, bodyEstudiante).then(r=>r.data);
}

const eliminarEstudiante = async (id) =>{
    const data = axios.delete(`http://localhost:8081/API/v1.0/Matricula/estudiantes/${id}`).then(r=>r.data);
    return data
}
