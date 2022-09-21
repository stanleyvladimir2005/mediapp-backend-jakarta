package com.mitocode.repo;

import com.mitocode.model.Paciente;

import java.util.List;

public interface ICRUD <T, ID>{

    List<T> listar();

    T listarPorId(T t);

    T registrar(T t);

    void actualizar(T t);

    void eliminar(T t);
}
