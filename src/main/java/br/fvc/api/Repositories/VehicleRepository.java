package br.fvc.api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fvc.api.Models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT DISTINCT v FROM veiculo v JOIN FETCH v.agencia JOIN FETCH v.modelo ORDER BY v.id DESC")
    List<Vehicle> findAllVehicleOrderByIdDesc();

    boolean existsByPlaca(String placa);

    @Query("SELECT v FROM veiculo v JOIN FETCH v.modelo AS m WHERE m.nome LIKE %:modeloOrMarca% or v.marca LIKE %:modeloOrMarca%")
    List<Vehicle> findByModeloOrMarca(String modeloOrMarca);
}
