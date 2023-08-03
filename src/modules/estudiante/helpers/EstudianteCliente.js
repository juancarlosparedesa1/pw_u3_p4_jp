import axios from "axios"

export const obtenerEstudianteFachada = async (cedula)=>{
    return await obtenerEstudianteAPIAxios(cedula)
}

export const ingresarEstudianteFachada = (bodyEstudiante) =>{

}

export const actualizarEstudianteFachada = (bodyEstudiante, id) => {

}

export const eliminarEstudianteFachada = (id) =>{

}

const obtenerEstudianteAPI = async (cedula)=>{
    console.log("axios2")
    const data = await fetch(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${cedula}`).then(r => r.json());
    console.log(data)
    return data;
    
}

const obtenerEstudianteAPIAxios = async (cedula)=>{
    const data=axios.get()(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${cedula}`).then(r=>r.data);

}

const ingresarEstudiante = (bodyEstudiante) =>{
    
    axios.post(`http://localhost:8080/API/v1.0/Matricula/estudiantes`,bodyEstudiante).then(r=>r.data);
}
