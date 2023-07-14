package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManeger;

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManeger
				.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:datoCedula", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManeger.persist(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManeger.merge(estudiante);
	}

	@Override
	public void actualizar(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManeger
				.createQuery("UPDATE Estudiante e SET e.cedula=:datoCedula WHERE e.cedula=:datoCondicion ");
		myQuery.setParameter("datoCedula", cedulaNueva);
		myQuery.setParameter("datoCondicion", cedulaActual);
		myQuery.executeUpdate();

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estu = this.buscarPorId(id);
		this.entityManeger.remove(estu);

	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManeger.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManeger.createQuery("Select e  From Estudiante e");
		return myQuery.getResultList();
	}

}
